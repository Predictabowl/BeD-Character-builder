package org.predictabowl.bed.domain.characteristic.model;

import org.predictabowl.bed.commons.exceptions.BeDIllegalValueException;
import org.predictabowl.bed.commons.utils.RefInteger;

public class CarPValue extends RefInteger{

	public static final int MIN_VALUE = 1;
	public static final int MAX_VALUE = 10;
	
	public CarPValue(int value) {
		super(value);
		this.selfValidate(value);
	}

	@Override
	public void setValue(int value) {
		super.setValue(value);
		this.selfValidate(value);
	}
	
	@Override
	public void modValue(int mod) {
		if (getValue()+mod < MIN_VALUE) {
			setValue(MIN_VALUE);
			return;
		}
		if (getValue()+mod > MAX_VALUE) {
			setValue(MAX_VALUE);
			return;
		}
		super.modValue(mod);
	}

	private void selfValidate(int value) {
		if (value < MIN_VALUE || value > MAX_VALUE) {
			throw new BeDIllegalValueException(
					"Caratteristica Primaria value must be between "+
							MIN_VALUE+" and "+ MAX_VALUE);
		}
	}

}
