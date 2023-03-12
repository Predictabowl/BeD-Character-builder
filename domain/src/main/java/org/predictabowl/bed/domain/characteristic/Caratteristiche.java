package org.predictabowl.bed.domain.characteristic;

import java.util.EnumMap;
import java.util.stream.Stream;

import org.predictabowl.bed.domain.characteristic.factory.CaratteristicaPrimariaFactory;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.predictabowl.bed.domain.constants.TipoAttributo;
import org.springframework.stereotype.Component;

@Component
public class Caratteristiche {

	private EnumMap<DataCaratteristicaPrimaria, CaratteristicaPrimaria> map;
	
	public Caratteristiche(CaratteristicaPrimariaFactory carFactory) {
		map = new EnumMap<>(DataCaratteristicaPrimaria.class);
		Stream.of(DataCaratteristicaPrimaria.values()).forEach(t -> 
			getMap().put(t, carFactory.get(t,5)));
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

	public int getAttributo(TipoAttributo type) {
		
		return map.values().stream().map(k -> k.getAttributoValue(type))
			.reduce(0, (subtotal,v) -> subtotal+v);
	}

	protected EnumMap<DataCaratteristicaPrimaria, CaratteristicaPrimaria> getMap() {
		return map;
	}
}
