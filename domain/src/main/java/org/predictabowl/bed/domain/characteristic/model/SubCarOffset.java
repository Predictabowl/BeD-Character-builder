package org.predictabowl.bed.domain.characteristic.model;

import org.predictabowl.bed.commons.validation.AutoValidatingInputModel;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class SubCarOffset extends AutoValidatingInputModel<SubCarOffset>{
	
	@Min(-1) @Max(1)
	private int offset;

	public SubCarOffset(@Min(-1) @Max(1) int offset) {
		super();
		this.offset = offset;
		validateSelf();
	}

	public int getOffset() {
		return offset;
	}
}
