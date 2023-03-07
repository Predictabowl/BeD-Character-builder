package org.predictabowl.bed.domain.characteristic;

import java.util.Objects;

import org.predictabowl.bed.domain.attributes.Attributi;

public class Caratteristica {

	private TipoCaratteristica type;
	private int value;
	private Attributi attributes;

	public Caratteristica(TipoCaratteristica type, int value) {
		this.type = type;
		this.value = value;
		this.attributes = new Attributi();
		calculateAttributes();
	}

	public Caratteristica(TipoCaratteristica type) {
		this(type, 5);
	}

	public TipoCaratteristica getType() {
		return type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		calculateAttributes();
	}

	public Attributi getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributi attributes) {
		this.attributes = attributes;
	}

	public void modValue(int mod) {
		value += mod;
	}

	protected void calculateAttributes() {
//		child classes should override this method to populate all attributes
	}

	@Override
	public int hashCode() {
		return Objects.hash(attributes, type, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caratteristica other = (Caratteristica) obj;
		return Objects.equals(attributes, other.attributes) && type == other.type && value == other.value;
	}

	@Override
	public String toString() {
		return "Caratteristica [type=" + type + ", value=" + value + ", attributes=" + attributes + "]";
	}

}
