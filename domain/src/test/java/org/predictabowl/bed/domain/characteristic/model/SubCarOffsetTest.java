package org.predictabowl.bed.domain.characteristic.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolationException;

class SubCarOffsetTest {

	@Test
	void test_maxValue() {
		 assertThatNoException().isThrownBy(() ->  new SubCarOffset(1));
		 
		 assertThatThrownBy(() -> new SubCarOffset(2))
		 	.isInstanceOf(ConstraintViolationException.class);
	}
	
	@Test
	void test_minValue() {
		 assertThatNoException().isThrownBy(() ->  new SubCarOffset(-1));
		 
		 assertThatThrownBy(() -> new SubCarOffset(-2))
		 	.isInstanceOf(ConstraintViolationException.class);
	}


}
