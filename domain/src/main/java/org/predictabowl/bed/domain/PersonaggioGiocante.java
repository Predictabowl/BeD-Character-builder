package org.predictabowl.bed.domain;

import org.predictabowl.bed.domain.characteristic.Caratteristiche;
import org.predictabowl.bed.domain.constants.DataCaratteristicaDerivata;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.predictabowl.bed.domain.equip.Equipaggiamento;

public class PersonaggioGiocante {

	private Long id;
	private String name;
	private ClassePG cClass;
	private Caratteristiche cars;
	private Equipaggiamento equipaggiamento;
	
	public int getCaratteristicaValue(DataCaratteristicaPrimaria carP) {
		return cars.getCaratteristica(carP).getValue();
	}
	
	public int getCaratteristicaValue(DataCaratteristicaSecondaria carS) {
		return cars.getCaratteristica(carS).getValue();
	}
	
	public int getCaratteristicaValue(DataCaratteristicaDerivata carD) {
		//this will dependent from the class
		return 0;
	}
}
