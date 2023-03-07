package org.predictabowl.bed.domain.characteristic;

import java.util.EnumMap;

public class Caratteristiche {

	private EnumMap<TipoCaratteristica, CaratteristicaPrimaria> map;
	
	public Caratteristiche() {
		map = new EnumMap<>(TipoCaratteristica.class);
		TipoCaratteristica.getCarPrimarie().forEach(t -> 
			map.put(t, t.getInstance()));
	}
	
	public Caratteristica getCaratteristica(TipoCaratteristica type) {
		if(type.isPrimaria) {
			return map.get(type);
		}
		CaratteristicaPrimaria car = map.get(type.getCarPrimaria().get());
		if (car.getSubCar1().getType().equals(type)){
			return car.getSubCar1();
		}
		return car.getSubCar2();
	}
	
	public void setCaratteristica(TipoCaratteristica type, int value) {
		if(type.isPrimaria) {
			map.get(type).setValue(value);
		}
	}
	
	public void offsetCaratteristica(TipoCaratteristica type, int offset) {
		if(type.isPrimaria) {
			map.get(type).setOffset(offset);
		}
	}
}
