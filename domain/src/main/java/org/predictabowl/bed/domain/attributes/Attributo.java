package org.predictabowl.bed.domain.attributes;

import java.util.Objects;

import org.predictabowl.bed.commons.interfaces.Summable;

public class Attributo implements Summable<Attributo>{
	
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
	
	@Override
	public Attributo addSummable(Attributo element) {
		if (this.type.equals(element.type)) {
			this.value += element.value;
		}
		return this;
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
	
}
