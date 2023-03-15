package org.predictabowl.bed.commons.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RefIntegerTest {

	@Test
	void test_modValue() {
		RefInteger sut = new RefInteger(5);
		
		sut.modValue(3);
		assertThat(sut.getValue()).isEqualTo(8);
		
		sut.modValue(-5);
		assertThat(sut.getValue()).isEqualTo(3);
	}

}
