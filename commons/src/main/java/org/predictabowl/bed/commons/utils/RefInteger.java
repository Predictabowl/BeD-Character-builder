package org.predictabowl.bed.commons.utils;

import java.util.Objects;

public class RefInteger{

	private int value;

	public RefInteger(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void modValue(int mod) {
		this.value += mod;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RefInteger other = (RefInteger) obj;
		return value == other.value;
	}

	@Override
	public String toString() {
		return "RefInteger [value=" + value + "]";
	}
	
}
