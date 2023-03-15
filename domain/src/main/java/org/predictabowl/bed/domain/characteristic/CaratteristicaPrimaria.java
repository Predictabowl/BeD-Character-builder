package org.predictabowl.bed.domain.characteristic;

import java.util.ArrayList;
import java.util.Objects;

import org.predictabowl.bed.commons.utils.RefInteger;
import org.predictabowl.bed.domain.attributes.AttributiCollection;
import org.predictabowl.bed.domain.attributes.AttributiInterface;
import org.predictabowl.bed.domain.attributes.factory.AttributiCollectionFactory;
import org.predictabowl.bed.domain.attributes.factory.AttributiFunctionFactory;
import org.predictabowl.bed.domain.characteristic.factory.CaratteristicaSecondariaFactory;
import org.predictabowl.bed.domain.characteristic.model.CarPValue;
import org.predictabowl.bed.domain.characteristic.model.SubCarOffset;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;

public class CaratteristicaPrimaria extends Caratteristica<DataCaratteristicaPrimaria> {

	private long id;
	private final CaratteristicaSecondaria subCar1;
	private final CaratteristicaSecondaria subCar2;
	private final AttributiCollection attributiColl;

	public CaratteristicaPrimaria(DataCaratteristicaPrimaria type,
			CarPValue value,
			CaratteristicaSecondariaFactory carFactory,
			AttributiFunctionFactory attrsFactory,
			AttributiCollectionFactory attCollFactory) {
		super(type, value, attrsFactory);
		this.subCar1 = carFactory.get(type.sub1, new RefInteger(getValue()));
		this.subCar2 = carFactory.get(type.sub2, new RefInteger(getValue()));
		this.attributiColl = buildAttributi(attCollFactory);
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public void setValue(int value) {
		super.getRefValue().setValue(value);
	}
	
	public void modValue(int mod) {
		super.getRefValue().modValue(mod);
	}

	public void setOffset(SubCarOffset  offset) {
		int intOffset = offset.getOffset();
		subCar1.setValue(getValue()+intOffset);
		subCar2.setValue(getValue()-intOffset);
	}

	public CaratteristicaSecondaria getSubCar1() {
		return subCar1;
	}
	
	public CaratteristicaSecondaria getSubCar2() {
		return subCar2;
	}
	
	@Override
	public AttributiInterface getAttributi() {
		return this.attributiColl;
	}
	
	public AttributiInterface getOnlyPrimaryCarAttributi() {
		return super.getAttributi();
	}

	private AttributiCollection buildAttributi(AttributiCollectionFactory factory) {
		ArrayList<AttributiInterface> collection = new ArrayList<>(3);
		collection.add(super.getAttributi());
		collection.add(this.getSubCar1().getAttributi());
		collection.add(this.getSubCar2().getAttributi());
		return factory.get(collection);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(attributiColl, id, subCar1, subCar2);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaratteristicaPrimaria other = (CaratteristicaPrimaria) obj;
		return Objects.equals(attributiColl, other.attributiColl) && id == other.id
				&& Objects.equals(subCar1, other.subCar1) && Objects.equals(subCar2, other.subCar2);
	}

	@Override
	public String toString() {
		return "CaratteristicaPrimaria [id=" + id + ", subCar1=" + subCar1 + ", subCar2=" + subCar2 + ", attributiColl="
				+ attributiColl + "]";
	}
	
}
