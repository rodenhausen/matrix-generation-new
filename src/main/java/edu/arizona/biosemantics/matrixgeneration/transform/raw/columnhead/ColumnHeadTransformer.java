package edu.arizona.biosemantics.matrixgeneration.transform.raw.columnhead;

import edu.arizona.biosemantics.matrixgeneration.model.Character;
import edu.arizona.biosemantics.matrixgeneration.model.raw.ColumnHead;

public interface ColumnHeadTransformer {

	public ColumnHead transform(Character character);

}