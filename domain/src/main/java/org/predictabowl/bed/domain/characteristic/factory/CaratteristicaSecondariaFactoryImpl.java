package org.predictabowl.bed.domain.characteristic.factory;

import org.predictabowl.bed.commons.utils.RefInteger;
import org.predictabowl.bed.domain.attributes.factory.AttributiFunctionFactory;
import org.predictabowl.bed.domain.characteristic.CaratteristicaSecondaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.springframework.stereotype.Component;

@Component
public class CaratteristicaSecondariaFactoryImpl implements	CaratteristicaSecondariaFactory{

	private final AttributiFunctionFactory attrFactory;
	

	public CaratteristicaSecondariaFactoryImpl(AttributiFunctionFactory attrFactory) {
		this.attrFactory = attrFactory;
	}

	@Override
	public CaratteristicaSecondaria get(DataCaratteristicaSecondaria type, RefInteger value) {
		return new CaratteristicaSecondaria(type, value, attrFactory);
	}

}
