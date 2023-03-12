package org.predictabowl.bed.domain.characteristic.factory;

import org.predictabowl.bed.domain.characteristic.CaratteristicaSecondaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.predictabowl.bed.domain.utils.CaratteristicaFunctionsRetriever;
import org.springframework.stereotype.Component;

@Component
public class CaratteristicaSecondariaFactory implements 
	CaratteristicaFactory<CaratteristicaSecondaria, DataCaratteristicaSecondaria>{

	private final CaratteristicaFunctionsRetriever carFRetriever;
	
	public CaratteristicaSecondariaFactory(CaratteristicaFunctionsRetriever carFRetriever) {
		super();
		this.carFRetriever = carFRetriever;
	}

	@Override
	public CaratteristicaSecondaria get(DataCaratteristicaSecondaria type, int value) {
		return new CaratteristicaSecondaria(type, value, carFRetriever);
	}

}
