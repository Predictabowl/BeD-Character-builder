package org.predictabowl.bed.domain.attributes;

import java.util.Objects;

import org.predictabowl.bed.commons.interfaces.Mergeable;
import org.predictabowl.bed.domain.constants.TipoAttributo;

public class Attributo implements Mergeable<Attributo> {

	private TipoAttributo type;
	private int value;

	public Attributo(TipoAttributo type, int value) {
		super();
		this.type = type;
		this.value = value;
	}

	public TipoAttributo getType() {
		return type;
	}

	public void setType(TipoAttributo type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void modValue(int mod) {
		value += mod;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attributo other = (Attributo) obj;
		return type == other.type;
	}

	@Override
	public String toString() {
		return "Attribute [type=" + type + ", value=" + value + "]";
	}

	@Override
	public Attributo merge(Attributo element) {
		if (type.equals(element.type)) {
			return new Attributo(type, value + element.value);
		}
		return new Attributo(type, value);
	}

}
