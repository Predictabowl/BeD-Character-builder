package org.predictabowl.bed.domain.characteristic;

import java.util.Objects;

import org.predictabowl.bed.commons.exceptions.BeDIllegalValueException;

public class CaratteristicaPrimaria extends Caratteristica {

	public static final int MAX_VALUE = 10;
	public static final int MIN_VALUE = 1;
	
	private TipoCaratteristica type;
	private Caratteristica sub1;
	private Caratteristica sub2;

	public CaratteristicaPrimaria(TipoCaratteristica type, int value) {
		super(type, value);
		if(!type.isPrimaria) {
			throw new BeDIllegalValueException("Characteristic type "+type+" is not primary");
		}
		selfValidate(value);
		this.sub1 = new Caratteristica(
				type.sub1.orElseThrow(IllegalArgumentException::new),
				value);
		this.sub2 = new Caratteristica(
				type.sub2.orElseThrow(IllegalArgumentException::new),
				value);
	}
	
	public CaratteristicaPrimaria(TipoCaratteristica type) {
		this(type, 5);
	}

	public void setOffset(int offset) {
		if (offset > 1 || offset < -1) {
			throw new BeDIllegalValueException("Offset value must be between -1 ad 1.");
		}
		this.sub1.setValue(getValue()+offset);
		this.sub2.setValue(getValue()-offset);
	}

	public TipoCaratteristica getType() {
		return type;
	}

	protected void setType(TipoCaratteristica type) {
		this.type = type;
	}

	@Override
	public void setValue(int value) {
		selfValidate(value);
		super.setValue(value);
	}

	public Caratteristica getSubCar1() {
		return sub1;
	}
	
	public Caratteristica getSubCar2() {
		return sub2;
	}
	
//	public List<Attributo> getAllAttributes(){
//		LinkedList<Attributo> attributes = new LinkedList<>(getAttributes());
//		attributes.addAll(sub1.getAttributes());
//		attributes.addAll(sub2.getAttributes());
//		return attributes;
//	}

	@Override
	public void modValue(int mod) {
		int oldValue = getValue();
		if (oldValue + mod > MAX_VALUE) {
			setValue(MAX_VALUE);
			return;
		}
		if (oldValue + mod < MIN_VALUE) {
			setValue(MIN_VALUE);
			return;
		}
		super.modValue(mod);
	}

	private void selfValidate(int value) {
		if (value < MIN_VALUE || value > MAX_VALUE) {
			throw new BeDIllegalValueException("Caratteristica Primaria value must be between 1 and 10");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(sub1, sub2, type);
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
		return Objects.equals(sub1, other.sub1) && Objects.equals(sub2, other.sub2) && type == other.type;
	}

	@Override
	public String toString() {
		return "CaratteristicaPrimaria [type=" + type + ", sub1=" + sub1 + ", sub2=" + sub2 + ", toString()="
				+ super.toString() + "]";
	}
	
}
