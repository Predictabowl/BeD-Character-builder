package org.predictabowl.bed.domain;

import java.util.ArrayList;
import java.util.List;

import org.predictabowl.bed.domain.characteristic.Caratteristiche;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;
import org.predictabowl.bed.domain.utils.DomainUtils;
import org.yaml.snakeyaml.util.EnumUtils;

public class ClassePG {

	private final List<DataCaratteristicaPrimaria> carManaList;
	
	public ClassePG(List<String> carManaSlugs) {
		super();
		this.carManaList = carManaSlugs.stream()
				.map(s -> EnumUtils.findEnumInsensitiveCase(DataCaratteristicaPrimaria.class, s))
				.toList();
	}
	
	public ClassePG() {
		this(new ArrayList<>());
	}

	public int getCarManaValue(Caratteristiche cars) {
		return DomainUtils.getCarCombinataValue(carManaList.stream()
				.mapToInt(c -> cars.getCaratteristica(c).getValue())
				.toArray());
	}

	public List<DataCaratteristicaPrimaria> getCarManaList() {
		return carManaList;
	}
}
