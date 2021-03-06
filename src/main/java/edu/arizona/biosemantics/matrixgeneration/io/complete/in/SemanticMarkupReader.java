package edu.arizona.biosemantics.matrixgeneration.io.complete.in;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import edu.arizona.biosemantics.common.taxonomy.Rank;
import edu.arizona.biosemantics.common.taxonomy.RankData;
import edu.arizona.biosemantics.common.taxonomy.TaxonIdentification;
import edu.arizona.biosemantics.matrixgeneration.model.SemanticMarkupProvenance;
import edu.arizona.biosemantics.matrixgeneration.model.complete.AbsentPresentCharacter;
import edu.arizona.biosemantics.matrixgeneration.model.complete.AttributeCharacter;
import edu.arizona.biosemantics.matrixgeneration.model.complete.Character;
import edu.arizona.biosemantics.matrixgeneration.model.complete.Matrix;
import edu.arizona.biosemantics.matrixgeneration.model.complete.Relation;
import edu.arizona.biosemantics.matrixgeneration.model.complete.Statement;
import edu.arizona.biosemantics.matrixgeneration.model.complete.Structure;
import edu.arizona.biosemantics.matrixgeneration.model.complete.StructureIdentifier;
import edu.arizona.biosemantics.matrixgeneration.model.complete.Taxon;
import edu.arizona.biosemantics.matrixgeneration.model.complete.Value;

public class SemanticMarkupReader implements Reader {
	
	protected String inputDirectory;
	protected SAXBuilder saxBuilder = new SAXBuilder();
	protected XPathFactory xpathFactory = XPathFactory.instance();
	protected XPathExpression<Element> sourceXpath = 
			xpathFactory.compile("/bio:treatment/meta/source", Filters.element(), null, 
					Namespace.getNamespace("bio", "http://www.github.com/biosemantics"));
	protected XPathExpression<Element> taxonIdentificationXpath = 
			xpathFactory.compile("/bio:treatment/taxon_identification", Filters.element(), null,
					Namespace.getNamespace("bio", "http://www.github.com/biosemantics"));
	protected XPathExpression<Element> statementXpath = 
			xpathFactory.compile("//description[@type='morphology']/statement", Filters.element(), null, 
					Namespace.getNamespace("bio", "http://www.github.com/biosemantics"));	

	@Inject
	public SemanticMarkupReader(@Named("InputDirectory") String inputDirectory) {
		this.inputDirectory = inputDirectory;
	}

	@Override
	public Matrix read() throws JDOMException, IOException {
		Map<Character, Character> characters = new HashMap<Character, Character>();
		
		Map<String, Structure> idStructureMap = new HashMap<String, Structure>();
		Map<String, Relation> idRelationMap = new HashMap<String, Relation>();
		
		List<TaxonIdentification> taxonIdentifications = new LinkedList<TaxonIdentification>();
		Map<TaxonIdentification, Taxon> rankTaxaMap = new HashMap<TaxonIdentification, Taxon>();
		
		Map<StructureIdentifier, Map<Taxon, List<Structure>>> structureIdTaxonStructuresMap = 
				new HashMap<StructureIdentifier, Map<Taxon, List<Structure>>>();
		Map<Taxon, File> sourceFilesMap = new HashMap<Taxon, File>();
		
		readPlainData(idStructureMap, idRelationMap, characters, taxonIdentifications, rankTaxaMap, structureIdTaxonStructuresMap, sourceFilesMap);
		List<Taxon> rootTaxa = createTaxaHierarchy(taxonIdentifications, rankTaxaMap);
		//rankTaxaMap holds taxon hierarchical relationships
		Matrix result = new Matrix(rootTaxa, characters, structureIdTaxonStructuresMap, sourceFilesMap, rankTaxaMap);
		//have to pass through id references because maps may not have been complete due to how things are ordered in xml
		//e.g. there are cases where a relation references a structure mentioned in the subsequent statement 
		//(probably due to charaparser error but it exists there)
		ensureIdsReferenced(result, idStructureMap, idRelationMap);
		return result;
	}

	protected void ensureIdsReferenced(Matrix matrix, Map<String, Structure> idStructureMap,
			Map<String, Relation> idRelationMap) {
		for(Taxon taxon : matrix.getTaxa()) {
			for(Relation relation : taxon.getRelations()) {
				relation.setFrom(idStructureMap.get(relation.getFromId()));
				relation.setTo(idStructureMap.get(relation.getToId()));
			}
		}
	}

	/**
	 * 
	 * @param taxonIdentifications
	 * @param rankTaxaMap
	 * @return one rootTaxon, update rankTaxaMap
	 */
	protected List<Taxon> createTaxaHierarchy(List<TaxonIdentification> taxonIdentifications, 
			Map<TaxonIdentification, Taxon> rankTaxaMap) {
		List<Taxon> rootTaxa = new LinkedList<Taxon>();
		for(TaxonIdentification taxonIdentification : taxonIdentifications) {
			LinkedList<RankData> rankData = taxonIdentification.getRankData();
			Taxon taxon = rankTaxaMap.get(taxonIdentification);
			if(rankData.size() == 1)
				rootTaxa.add(taxon);
			if(rankData.size() > 1) {
				//int parentRankIndex = rankData.size() - 2;
				Taxon parentTaxon = null;
				//while(parentTaxon == null && parentRankIndex >= 0) {
				LinkedList<RankData> parentRankDatas = new LinkedList<RankData>(rankData);
	    		while(parentRankDatas.size() > 1) {
	    			parentRankDatas.removeLast();
	    			TaxonIdentification parentTaxonIdentificaiton = new TaxonIdentification(parentRankDatas, 
		    				taxonIdentification.getAuthor(), taxonIdentification.getDate()); //This is problematic -- parent taxon's pub metadata (author/date) may not be the same as the child taxon. Solution: make tI.getAuthor() and tI.getDate() returns fixed dummy values.
					//RankData parentRankData = rankData.get(parentRankIndex);
					parentTaxon = rankTaxaMap.get(parentTaxonIdentificaiton);
					//parentRankIndex--;
					if(parentTaxon != null)
						break;
				}
				if(parentTaxon == null)
					rootTaxa.add(taxon);
				else
					parentTaxon.addChild(taxon);
			}
		}
		return rootTaxa;
	}

	protected void readPlainData(Map<String, Structure> idStructureMap, Map<String, Relation> idRelationMap, Map<Character, Character> characters, 
			List<TaxonIdentification> taxonNames, Map<TaxonIdentification, Taxon> rankTaxaMap, Map<StructureIdentifier, Map<Taxon, List<Structure>>> structureIdTaxonStructuresMap, 
			Map<Taxon, File> sourceFilesMap) throws JDOMException, IOException {		
		HashMap<RankData, RankData> rankDataInstances = new HashMap<RankData, RankData>();
		File input = new File(inputDirectory);
		
		String wholeOrganismOntologyId = readWholeOrganismOntologyId(input);
		
		for(File file : input.listFiles()) {
			if(file.isFile()) {
				Document document = saxBuilder.build(file);
				Element sourceElement = sourceXpath.evaluateFirst(document);
				//Make author/date (metadata of the source pub) values fixed so taxa would be essentially identified using name+authority+date, 
				//This won't affect the show of pub author and pub date info in the context panel of the TextCapture Review step. Those strings are fetched from input xml file.
				//This won't affect Taxonomy Comparison because "sec" info will be manually entered by the users.
				//Hong 4/25/17
				String author = "the authors"/*sourceElement.getChildText("author")*/;
				String date = "the date" /*sourceElement.getChildText("date")*/;
				
				LinkedList<RankData> rankDatas = createRankDatas(document, rankDataInstances);
				TaxonIdentification taxonIdentification = new TaxonIdentification(rankDatas, author, date);
				taxonNames.add(taxonIdentification);
				
				Taxon taxon = createTaxon(document, idStructureMap, idRelationMap, characters, taxonIdentification, structureIdTaxonStructuresMap, 
						wholeOrganismOntologyId);
				taxon.setSourceFile(file);
				sourceFilesMap.put(taxon, file);
 				rankTaxaMap.put(taxonIdentification, taxon);
			}
		}
	}
	
	protected String readWholeOrganismOntologyId(File input) throws JDOMException, IOException {
		String result = null;
		for(File file : input.listFiles()) {
			if(file.isFile()) {
				Document document = saxBuilder.build(file);
				for (Element statement : statementXpath.evaluate(document)) {
					List<Element> structures = statement.getChildren("biological_entity");
					for(Element structure : structures) {
						String name = structure.getAttributeValue("name");
						String constraint = structure.getAttributeValue("constraint");
						String ontologyId = structure.getAttributeValue("ontologyid"); //TODO: parse ontologyid value
						//ontologyid="http://purl.obolibrary.org/obo/PO_0025060[blade:cardinal part of multi-tissue plant structure/laminablade:1.0];"
						ontologyId = ontologyId!=null && ontologyId.contains("[")? ontologyId.substring(0, ontologyId.indexOf("[")):ontologyId;
						if(name != null && name.equals("whole_organism") && (constraint == null || constraint.trim().isEmpty())) {
							result = ontologyId;
						}
					}
				}
			}
		}
		return result;
	}

	protected void createWholeOrganism(String wholeOrganismOntologyId, Taxon taxon, 
			Map<StructureIdentifier, Map<Taxon, List<Structure>>> structureIdTaxonStructuresMap) {
		Structure wholeOrganism = new Structure("whole_organism", null, wholeOrganismOntologyId);
		taxon.setWholeOrganism(wholeOrganism);
		addStructureToStructureIdTaxonStructuresMap(wholeOrganism, taxon, structureIdTaxonStructuresMap);
	}

	protected void addStructureToStructureIdTaxonStructuresMap(
			Structure structure, Taxon taxon, Map<StructureIdentifier, Map<Taxon, List<Structure>>> structureIdTaxonStructuresMap) {
		StructureIdentifier structureIdentifier = new StructureIdentifier(structure);
		if(!structureIdTaxonStructuresMap.containsKey(structureIdentifier))
			structureIdTaxonStructuresMap.put(structureIdentifier, new HashMap<Taxon, List<Structure>>());
		if(!structureIdTaxonStructuresMap.get(structureIdentifier).containsKey(taxon))
			structureIdTaxonStructuresMap.get(structureIdentifier).put(taxon, new LinkedList<Structure>());
		if(structureIdentifier.getStructureName().equals("whole_organism")) {
			List<Structure> wholeOrganisms = structureIdTaxonStructuresMap.get(structureIdentifier).get(taxon);
			wholeOrganisms.clear();
			wholeOrganisms.add(structure);
		} else {
			structureIdTaxonStructuresMap.get(structureIdentifier).get(taxon).add(structure);
		}
	}

	protected Taxon createTaxon(Document document, Map<String, Structure> idStructureMap, 
			Map<String, Relation> idRelationMap, Map<Character, Character> characters, TaxonIdentification taxonIdentification, 
			Map<StructureIdentifier, Map<Taxon, List<Structure>>> structureIdTaxonStructuresMap, String wholeOrganismOntologyId) {
		Taxon taxon = new Taxon();
		taxon.setTaxonIdentification(taxonIdentification);
		StringBuilder descriptionBuilder = new StringBuilder();
		
		createWholeOrganism(wholeOrganismOntologyId, taxon, structureIdTaxonStructuresMap);
		for (Element statement : statementXpath.evaluate(document)) {
			String text = statement.getChild("text").getText();
			descriptionBuilder.append(text + ". ");
			
			//create and add the statement
			Statement sent = new Statement(statement.getAttribute("id").toString(),text);
			taxon.addStatement(sent);
			
			List<Element> structures = statement.getChildren("biological_entity");
			for(Element structure : structures) {
				if(structure.getAttribute("type") != null && structure.getAttributeValue("type").equals("structure")){
					taxon.addStructure(createStructure(sent, structure, idStructureMap, characters, taxon, structureIdTaxonStructuresMap));
				}
					
			}
			
			List<Element> relations = statement.getChildren("relation");
			for(Element relation : relations) {
				taxon.addRelation(createRelation(relation, idStructureMap, idRelationMap));
			}
		}
		taxon.setDescription(descriptionBuilder.toString().trim());
		return taxon;
	}

	protected LinkedList<RankData> createRankDatas(Document document, HashMap<RankData, RankData> rankDataInstances) {
		LinkedList<RankData> rankDatas = new LinkedList<RankData>();
		
		List<Element> taxonNames = new LinkedList<Element>();
		for(Element taxonIdentifiaction : taxonIdentificationXpath.evaluate(document)) {
			if(taxonIdentifiaction.getAttributeValue("status").equalsIgnoreCase("accepted")) {
				taxonNames.addAll(taxonIdentifiaction.getChildren("taxon_name"));
			}
		}
		
		for(Element taxonName : taxonNames) {
			String rank = taxonName.getAttributeValue("rank");
			String date = taxonName.getAttributeValue("date");
			String authority = taxonName.getAttributeValue("authority");
			String name = taxonName.getText();
			RankData rankData = new RankData(Rank.valueOf(rank.toUpperCase()), name, authority, date);
			if(!rankDataInstances.containsKey(rankData))
				rankDataInstances.put(rankData, rankData);
			rankDatas.add(rankDataInstances.get(rankData));
		}
		Collections.sort(rankDatas);
		
		for(int i=1; i<rankDatas.size(); i++) {
			rankDatas.get(i).setParent(rankDatas.get(0));
		}
		return rankDatas;
	}

	protected Relation createRelation(Element relation, Map<String, Structure> idStructureMap, Map<String, Relation> idRelationMap) {
		Relation result = new Relation();
		String fromId = relation.getAttributeValue("from");
		String toId = relation.getAttributeValue("to");
		Structure fromStructure = idStructureMap.get(fromId);
		Structure toStructure = idStructureMap.get(toId);
		String id = relation.getAttributeValue("id");
		idRelationMap.put(id, result);
		String name = relation.getAttributeValue("name");
		String negated = relation.getAttributeValue("negation");
		String alterName = relation.getAttributeValue("alter_name");
		String geographicalConstraint = relation.getAttributeValue("geographical_constraint");
		String inBrackets = relation.getAttributeValue("in_brackets");
		String modifier = relation.getAttributeValue("modifier");
		String notes = relation.getAttributeValue("notes");
		String ontologyId = relation.getAttributeValue("ontologyid");
		String organConstraint = relation.getAttributeValue("organ_constraint");
		String parallelismConstraint = relation.getAttributeValue("parallelism_constraint");
		String provenance = relation.getAttributeValue("provenance");
		String taxonConstraint = relation.getAttributeValue("taxon_constraint");
		
		result.setAlterName(alterName);
		result.setFrom(fromStructure);
		result.setFromId(fromId);
		result.setGeographicalConstraint(geographicalConstraint);
		result.setId(id);
		result.setInBrackets(inBrackets);
		result.setModifier(modifier);
		result.setName(name);
		result.setNegated(Boolean.valueOf(negated));
		result.setNotes(notes);
		result.setOntologyId(ontologyId);
		result.setOrganConstraint(organConstraint);
		result.setParallelismConstriant(parallelismConstraint);
		result.setProvenance(provenance);
		result.setTaxonConstraint(taxonConstraint);
		result.setTo(toStructure);
		result.setToId(toId);
		return result;
	}

	protected Structure createStructure(Statement statement, Element structure, Map<String, Structure> idStructureMap, Map<Character, Character> characters, 
			Taxon taxon, Map<StructureIdentifier, Map<Taxon, List<Structure>>> structureIdTaxonStructuresMap) {
		Structure result = new Structure();
		String id = structure.getAttributeValue("id");

		result.setName(structure.getAttributeValue("name"));
		result.setAlterName(structure.getAttributeValue("alter_name"));
		result.setConstraint(structure.getAttributeValue("constraint"));
		result.setConstraintid(structure.getAttributeValue("constraintid"));
		result.setGeographicalConstraint(structure.getAttributeValue("geographical_constraint"));
		result.setId(id);
		result.setInBracket(structure.getAttributeValue("in_bracket"));
		result.setInBrackets(structure.getAttributeValue("in_brackets"));
		result.setNameOriginal(structure.getAttributeValue("name_original"));
		result.setParallelismConstraint(structure.getAttributeValue("paralellism_constraint"));
		result.setNotes(structure.getAttributeValue("notes"));
		result.setOntologyId(structure.getAttributeValue("ontologyid"));
		result.setProvenance(structure.getAttributeValue("provenance"));
		result.setTaxonConstraint(structure.getAttributeValue("taxon_constraint"));
		
		//bad code, should link character info to the existing WholeOrganism
		//if(result.getName().equals("whole_organism")&&taxon.getWholeOrganism()==null)
		//	taxon.setWholeOrganism(result);
		if(result.getName().equals("whole_organism")){
			if(taxon.getWholeOrganism()==null)
				taxon.setWholeOrganism(result);
			else
				result = taxon.getWholeOrganism();
		}
					
		idStructureMap.put(id, result);
		this.addStructureToStructureIdTaxonStructuresMap(result, taxon, structureIdTaxonStructuresMap);
		StructureIdentifier structureIdentifier = new StructureIdentifier(result);
		
		for(Element characterElement : structure.getChildren("character")) {
			String name = characterElement.getAttributeValue("name");
			Character character = createCharacter(taxon, structureIdentifier, name);
			if(!characters.containsKey(character))
				characters.put(character, character);
			character = characters.get(character);
			
			String v = characterElement.getAttributeValue("value"); //attribute value: growth_form's value is *plant*
			Value value = new Value(v, new SemanticMarkupProvenance(taxon, character));
			value.setIsModifier(Boolean.getBoolean(characterElement.getAttributeValue("is_modifier")));
			value.setValueOriginal(characterElement.getAttributeValue("value_original"));
			value.setCharType(characterElement.getAttributeValue("char_type"));
			value.setConstraint(characterElement.getAttributeValue("constraint"));
			value.setConstraintId(characterElement.getAttributeValue("constraintid"));
			value.setFrom(characterElement.getAttributeValue("from"));
			value.setFromInclusive(characterElement.getAttributeValue("from_inclusive"));
			value.setFromUnit(characterElement.getAttributeValue("from_unit"));
			value.setFromModifier(characterElement.getAttributeValue("from_modifier"));
			value.setModifier(characterElement.getAttributeValue("modifier"));
			value.setGeographicalConstraint(characterElement.getAttributeValue("geographical_constraint"));
			value.setInBrackets(characterElement.getAttributeValue("in_brackets"));
			value.setOrganConstraint(characterElement.getAttributeValue("organ_constraint"));
			value.setOtherConstraint(characterElement.getAttributeValue("other_constraint"));
			value.setParallelismConstraint(characterElement.getAttributeValue("parallelism_constraint"));
			value.setTaxonConstraint(characterElement.getAttributeValue("taxon_constraint"));
			value.setTo(characterElement.getAttributeValue("to"));
			value.setToInclusive(characterElement.getAttributeValue("to_inclusive"));
			value.setToUnit(characterElement.getAttributeValue("to_unit"));
			value.setToModifier(characterElement.getAttributeValue("to_modifier"));
			value.setType(characterElement.getAttributeValue("type"));
			value.setUpperRestricted(characterElement.getAttributeValue("upper_restricted"));
			value.setUnit(characterElement.getAttributeValue("unit"));
			value.setValue(characterElement.getAttributeValue("value"));
			value.setOntologyId(characterElement.getAttributeValue("ontologyid"));
			value.setProvenance(characterElement.getAttributeValue("provenance"));
			value.setNotes(characterElement.getAttributeValue("notes"));
			value.setNegation(characterElement.getAttributeValue("negation"));
			value.setEstablishmentMeans(characterElement.getAttributeValue("establishment_means"));
			value.setSrc(characterElement.getAttributeValue("src"));
			
			value.setStatement(statement); //statement: object wrapping the sentence
			
			boolean isModifier = false;
			try {
				isModifier = Boolean.parseBoolean(characterElement.getAttributeValue("is_modifier"));
			} catch(Exception e) {	} 
			value.setIsModifier(isModifier);

			result.addCharacterValue(character, value);
			/*StructureIdentifier toAddStructureIdentifier = null;
			if(character instanceof AbsentPresentCharacter) {
				toAddStructureIdentifier = ((AbsentPresentCharacter) character).getBearedStructureIdentifier();
			} else if(character instanceof AttributeCharacter) {
				toAddStructureIdentifier = character.getBearerStructureIdentifier();
			}
			if(!structureIdTaxonStructuresMap.containsKey(toAddStructureIdentifier))
				structureIdTaxonStructuresMap.put(toAddStructureIdentifier, new HashMap<Taxon, List<Structure>>());
			if(!structureIdTaxonStructuresMap.get(toAddStructureIdentifier).containsKey(taxon))
				structureIdTaxonStructuresMap.get(toAddStructureIdentifier).put(taxon, new LinkedList<Structure>());
			structureIdTaxonStructuresMap.get(toAddStructureIdentifier).get(taxon).add(result);*/
		}
	
		return result;
	}

	protected Character createCharacter(Taxon taxon, StructureIdentifier structureIdentifier, String name) {
		if("presence".equals(name))
			return new AbsentPresentCharacter(structureIdentifier, new StructureIdentifier(taxon.getWholeOrganism()), this);
		return new AttributeCharacter(name, "of", structureIdentifier, this);
	}

}
