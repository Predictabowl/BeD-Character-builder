package org.predictabowl.bed.domain.characteristic.factory;

import org.predictabowl.bed.domain.attributes.factory.AttributiCollectionFactory;
import org.predictabowl.bed.domain.attributes.factory.AttributiFunctionFactory;
import org.predictabowl.bed.domain.characteristic.CaratteristicaPrimaria;
import org.predictabowl.bed.domain.characteristic.model.CarPValue;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;
import org.springframework.stereotype.Component;

@Component
public class CaratteristicaPrimariaFactoryImpl implements CaratteristicaPrimariaFactory{

	private final AttributiFunctionFactory attrFuncFactory;
	private final CaratteristicaSecondariaFactoryImpl carFactory;
	private final AttributiCollectionFactory attrCollFactory;
	
	public CaratteristicaPrimariaFactoryImpl(
			AttributiFunctionFactory attrFuncFactory,
			CaratteristicaSecondariaFactoryImpl carFactory,
			AttributiCollectionFactory attrCollFactory) {
		super();
		this.attrFuncFactory = attrFuncFactory;
		this.carFactory = carFactory;
		this.attrCollFactory = attrCollFactory;
	}

	@Override
	public CaratteristicaPrimaria get(DataCaratteristicaPrimaria type, CarPValue value) {
		return new CaratteristicaPrimaria(type, value, carFactory, attrFuncFactory, attrCollFactory);
	}

}
