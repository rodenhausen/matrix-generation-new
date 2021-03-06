package edu.arizona.biosemantics.matrixgeneration.transform.complete;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import edu.arizona.biosemantics.common.log.LogLevel;
import edu.arizona.biosemantics.common.ontology.search.OntologyAccess;
import edu.arizona.biosemantics.matrixgeneration.config.Configuration;
import edu.arizona.biosemantics.matrixgeneration.model.OntologySuperclassProvenance;
import edu.arizona.biosemantics.matrixgeneration.model.Provenance;
import edu.arizona.biosemantics.matrixgeneration.model.complete.AbsentPresentCharacter;
import edu.arizona.biosemantics.matrixgeneration.model.complete.Character;
import edu.arizona.biosemantics.matrixgeneration.model.complete.Matrix;
import edu.arizona.biosemantics.matrixgeneration.model.complete.Structure;
import edu.arizona.biosemantics.matrixgeneration.model.complete.StructureIdentifier;
import edu.arizona.biosemantics.matrixgeneration.model.complete.Taxon;
import edu.arizona.biosemantics.matrixgeneration.model.complete.Value;
import edu.arizona.biosemantics.matrixgeneration.model.complete.Values;

/**
 * OntologySuperclassInheritanceTransformer looks at AbsentPresentCharacters.
 * For each AbsentPresentCharacter look at ontology superclasses of the beared structures A.
 * Add a AbsentPresentCharacter with found superclasses as beared structures B.
 * If a beared structure A is present in a taxon set the AbsentPresentCharacter of beared structures B
 * also to present.
 * 
 * Reasoning: If petal is present, flower must be present too.
 * @author Thomas
 */
public class OntologySuperclassInheritanceTransformer implements Transformer {

	private OntologyAccess ontologyAccess;
	private OWLOntologyManager owlOntologyManager;
	private OWLDataFactory owlDataFactory;
	private Set<OWLClass> upperBounds;

	@Inject
	public OntologySuperclassInheritanceTransformer(@Named("OntologySuperclassInheritanceTransformer_UpperBounds")
			Set<OWLClass> upperBounds) {
		Set<OWLOntology> ontologies = new HashSet<OWLOntology>();
		owlOntologyManager = OWLManager.createOWLOntologyManager();
		owlDataFactory = owlOntologyManager.getOWLDataFactory();
		this.upperBounds = upperBounds;
		
		File ontologyDirectory = new File(Configuration.ontologyDirectory);
		for(File ontologyFile : ontologyDirectory.listFiles()) {
			try {
				OWLOntology ontology = owlOntologyManager.loadOntologyFromOntologyDocument(ontologyFile);
				ontologies.add(ontology);
			} catch (OWLOntologyCreationException e) {
				log(LogLevel.ERROR, "Couldn't load ontology " + ontologyFile.getAbsolutePath(), e);
			}
		}
		ontologyAccess = new OntologyAccess(ontologies);
	}
	
	@Override
	public void transform(Matrix matrix) {
		Set<Character> iteratable = new HashSet<Character>(matrix.getCharacters());
		for(Character character : iteratable) {
			if(character instanceof AbsentPresentCharacter) {
				StructureIdentifier bearerStructure = character.getBearerStructureIdentifier();
				StructureIdentifier bearedStructure = ((AbsentPresentCharacter)character).getBearedStructureIdentifier();
				log(LogLevel.INFO, "Infer from base character " + character.toString());
				log(LogLevel.INFO, "Infer from beared structure " + bearedStructure.toString());
				Set<Structure> inferredSuperclassStructures = getSuperclassStructures(bearedStructure);
				
				for(Structure inferredSuperclassStructure : inferredSuperclassStructures) {
					log(LogLevel.INFO, "Inferred superclass " + inferredSuperclassStructure.toString());
					
					for(Taxon taxon : matrix.getTaxa())
						if(matrix.getStructure(bearedStructure, taxon) != null) 
							matrix.addStructure(inferredSuperclassStructure, taxon);
					
					Character inferredCharacter = new AbsentPresentCharacter(new StructureIdentifier(inferredSuperclassStructure), 
							bearerStructure, this);
					log(LogLevel.DEBUG, "Create from inferred superclass character: " + inferredCharacter.toString());
					matrix.addCharacter(inferredCharacter);
					
					for(Taxon taxon : matrix.getTaxa()) 
						if(isPresent(character, taxon, matrix)) {
							log(LogLevel.DEBUG, "Set present for taxon: " + taxon.toString());
							setPresent(inferredCharacter, taxon, matrix, bearedStructure);
						}
				}
			}
		}
	}

	private void setPresent(Character inferredCharacter, Taxon taxon, Matrix matrix, StructureIdentifier bearedStructure) {
		Structure bearerStructure = matrix.getStructure(inferredCharacter.getBearerStructureIdentifier(), taxon);
		bearerStructure.addCharacterValue(inferredCharacter, new Value("present", new OntologySuperclassProvenance(bearedStructure)));
	}

	private boolean isPresent(Character character, Taxon taxon, Matrix matrix) {
		if(matrix.hasStructure(character.getBearerStructureIdentifier(), taxon)) {
			Structure bearerStructure = matrix.getStructure(character.getBearerStructureIdentifier(), taxon);
			if(bearerStructure.containsCharacterValue(character)) {
				Values values = bearerStructure.getCharacterValues(character);
				for(Value value : values) 
					if(value.getValue().trim().equals("present"))
						return true;
			}
		}
		return false;
	}

	private Set<Structure> getStructuresWherePartOf(StructureIdentifier structure) {
		Set<Structure> result = new HashSet<Structure>();
		if(structure.hasStructureOntologyId()) {
			OWLClass part = owlDataFactory.getOWLClass(IRI.create(structure.getStructureOntologyId()));
			Set<OWLClass> bearers = ontologyAccess.getBearers(part);
			for(OWLClass bearer : bearers) {
				String label = ontologyAccess.getLabel(bearer);
				if(label != null)
					result.add(new Structure(label, null, bearer.getIRI().toString()));
			}
		}
		return result;
	}
	
	private Set<Structure> getSuperclassStructures(StructureIdentifier structure) {
		Set<Structure> result = new HashSet<Structure>();
		if(structure.hasStructureOntologyId()) {
			OWLClass subclass = owlDataFactory.getOWLClass(IRI.create(structure.getStructureOntologyId()));
			Set<OWLClass> ancestors = ontologyAccess.getAncestors(subclass);
			for(OWLClass ancestor : ancestors) {
				if(!isAboveUpperBound(ancestor)) {
					String label = ontologyAccess.getLabel(ancestor);
					result.add(new Structure(label, null, ancestor.getIRI().toString()));
				} else {
					log(LogLevel.INFO, "Left out ancestor: " + ancestor.getIRI().toString() + " due to upper bound restriction");
				}
			}
		}
		return result;
	}

	private boolean isAboveUpperBound(OWLClass owlClass) {
		for(OWLClass upperBound : upperBounds) {
			if(upperBound.equals(owlClass) || ontologyAccess.getDescendants(owlClass).contains(upperBound))
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
