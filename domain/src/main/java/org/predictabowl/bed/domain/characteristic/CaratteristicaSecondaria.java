package org.predictabowl.bed.domain.characteristic;

import org.predictabowl.bed.commons.utils.RefInteger;
import org.predictabowl.bed.domain.attributes.factory.AttributiFunctionFactory;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;

public class CaratteristicaSecondaria extends Caratteristica<DataCaratteristicaSecondaria>{

	public CaratteristicaSecondaria(DataCaratteristicaSecondaria type, RefInteger value,
			AttributiFunctionFactory attrsFactory) {
		super(type, value, attrsFactory);
	}

}
