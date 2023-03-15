package org.predictabowl.bed.domain.characteristic;

import java.util.Objects;

import org.predictabowl.bed.commons.utils.RefInteger;
import org.predictabowl.bed.domain.attributes.AttributiFunction;
import org.predictabowl.bed.domain.attributes.AttributiInterface;
import org.predictabowl.bed.domain.attributes.factory.AttributiFunctionFactory;
import org.predictabowl.bed.domain.utils.FunctionsProvider;

public class Caratteristica<T extends FunctionsProvider> {

	private final T type;
	private final RefInteger value;
	private final AttributiFunction attributi;

	protected Caratteristica(T type, RefInteger value, AttributiFunctionFactory attrsFactory) {
		this.type = type;
		this.value = value;
		this.attributi = attrsFactory.get(this.value, type);
	}

	public T getType() {
		return type;
	}

	public int getValue() {
		return value.getValue();
	}
	
	protected void setValue(int value) {
		this.value.setValue(value);
	}
	
	protected RefInteger getRefValue() {
		return value;
	}

	public AttributiInterface getAttributi() {
		return attributi;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(type, value);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caratteristica<T> other = (Caratteristica<T>) obj;
		return Objects.equals(type, other.type) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "Caratteristica [type=" + type + ", value=" + value + "]";
	}

}
