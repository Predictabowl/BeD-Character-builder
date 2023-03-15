package org.predictabowl.bed.domain.characteristic;

import java.util.EnumMap;
import java.util.stream.Stream;

import org.predictabowl.bed.domain.attributes.AttributiCollection;
import org.predictabowl.bed.domain.attributes.AttributiInterface;
import org.predictabowl.bed.domain.attributes.factory.AttributiCollectionFactory;
import org.predictabowl.bed.domain.characteristic.factory.CaratteristicaPrimariaFactoryImpl;
import org.predictabowl.bed.domain.characteristic.model.CarPValue;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.springframework.stereotype.Component;

@Component
public class Caratteristiche {

	private EnumMap<DataCaratteristicaPrimaria, CaratteristicaPrimaria> map;
	private final AttributiCollection attributiCollection;
	
	public Caratteristiche(CaratteristicaPrimariaFactoryImpl carFactory,
			AttributiCollectionFactory attributiCollectionFactory) {
		map = new EnumMap<>(DataCaratteristicaPrimaria.class);
		Stream.of(DataCaratteristicaPrimaria.values()).forEach(t -> 
			getMap().put(t, carFactory.get(t,new CarPValue(5))));
		
		this.attributiCollection = attributiCollectionFactory.get(
				map.values().stream().map(c -> c.getAttributi()).toList());
	}
	
	public CaratteristicaPrimaria getCaratteristica(DataCaratteristicaPrimaria type) {
		return getMap().get(type);
	}
	
	public CaratteristicaSecondaria getCaratteristica(DataCaratteristicaSecondaria type) {
		CaratteristicaPrimaria car = getMap().get(type.getCarPrimaria());

		if (car.getSubCar1().getType().equals(type)){
			return car.getSubCar1();
		}
		return car.getSubCar2();
	}
	
	public AttributiInterface getAttributi() {
		return attributiCollection;
	}

	protected EnumMap<DataCaratteristicaPrimaria, CaratteristicaPrimaria> getMap() {
		return map;
	}
}
