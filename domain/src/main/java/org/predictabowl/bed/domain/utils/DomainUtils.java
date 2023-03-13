package org.predictabowl.bed.domain.utils;

public class DomainUtils {

	private DomainUtils() {
	}

	public static int getCarCombinataValue(int ...values) {
		switch(values.length) {
			case 0:
				return 0;
			case 1:
				return values[0];
			case 2:
				return Math.min(values[0], values[1]) + Math.floorDiv(values[0] + values[1] - 9, 2);
			case 3:
				return Math.min(Math.min(values[0], values[1]), values[2]) +
						Math.floorDiv(values[0] + values[1] + values[2] - 15, 2);
			default:
				throw new IllegalArgumentException("The number of Caratteristics must be between 0 and 3");
		}
	}
}
