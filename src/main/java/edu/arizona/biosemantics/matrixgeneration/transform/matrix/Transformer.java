package edu.arizona.biosemantics.matrixgeneration.transform.matrix;

import java.util.List;

import edu.arizona.biosemantics.matrixgeneration.model.Matrix;
import edu.arizona.biosemantics.matrixgeneration.model.Taxon;

public interface Transformer {

	public void transform(Matrix matrix);

}