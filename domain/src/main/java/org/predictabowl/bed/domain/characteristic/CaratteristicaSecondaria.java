package org.predictabowl.bed.domain.characteristic;

import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.predictabowl.bed.domain.utils.CaratteristicaFunctionsRetriever;

public class CaratteristicaSecondaria extends Caratteristica<DataCaratteristicaSecondaria>{

	public CaratteristicaSecondaria(DataCaratteristicaSecondaria type, int value,
			CaratteristicaFunctionsRetriever carFRetriever) {
		super(type, carFRetriever, value);
	}

}
