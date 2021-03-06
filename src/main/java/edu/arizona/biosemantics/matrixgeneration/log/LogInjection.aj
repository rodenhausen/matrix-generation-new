package edu.arizona.biosemantics.matrixgeneration.log;

import edu.arizona.biosemantics.common.log.AbstractLogInjection;
import edu.arizona.biosemantics.common.log.ILoggable;

public aspect LogInjection extends AbstractLogInjection {

	declare parents : edu.arizona.biosemantics.matrixgeneration..* implements ILoggable;
}
