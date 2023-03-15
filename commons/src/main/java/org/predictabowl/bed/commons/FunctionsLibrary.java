package org.predictabowl.bed.commons;

import org.predictabowl.bed.commons.interfaces.TriFunction;

public enum FunctionsLibrary {
	BASE_LEVEL_MULTIPLIER;

	public TriFunction<Integer, Integer, Integer, Integer> getFunction() {
		switch (this) {
		case BASE_LEVEL_MULTIPLIER:
			return (b, l, m) -> b + (m * l);
		default:
			throw new IllegalArgumentException("Unexpected value: " + this);
		}
	}
}
