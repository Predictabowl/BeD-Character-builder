package org.predictabowl.bed.domain.characteristic.factory;

import org.predictabowl.bed.domain.characteristic.CaratteristicaPrimaria;
import org.predictabowl.bed.domain.characteristic.CaratteristicaSecondaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.predictabowl.bed.domain.utils.CaratteristicaFunctionsRetriever;
import org.springframework.stereotype.Component;

@Component
public class CaratteristicaPrimariaFactory implements 
		CaratteristicaFactory<CaratteristicaPrimaria, DataCaratteristicaPrimaria>{

	private final CaratteristicaFunctionsRetriever carFRetriever;
	private final CaratteristicaFactory<CaratteristicaSecondaria, DataCaratteristicaSecondaria> carFactory;
	
	public CaratteristicaPrimariaFactory(
			CaratteristicaFunctionsRetriever carFRetriever,
			CaratteristicaFactory<CaratteristicaSecondaria, DataCaratteristicaSecondaria> carFactory) {
		super();
		this.carFRetriever = carFRetriever;
		this.carFactory = carFactory;
	}

	@Override
	public CaratteristicaPrimaria get(DataCaratteristicaPrimaria type, int value) {
		return new CaratteristicaPrimaria(type, value, carFactory, carFRetriever);
	}

}
