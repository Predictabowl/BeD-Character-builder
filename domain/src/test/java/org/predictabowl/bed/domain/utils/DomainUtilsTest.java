package org.predictabowl.bed.domain.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class DomainUtilsTest {

	@Test
	void test_noValue() {
		assertThat(DomainUtils.getCarCombinataValue()).isZero();
	}
	
	@Test
	void test_singleValue() {
		assertThat(DomainUtils.getCarCombinataValue(6)).isEqualTo(6);
	}
	
	@Test
	void test_doubleValue() {
		assertThat(DomainUtils.getCarCombinataValue(6,8)).isEqualTo(8);
	}
	
	@Test
	void test_tripleValue() {
		assertThat(DomainUtils.getCarCombinataValue(6,7,9)).isEqualTo(9);
	}
	
	@Test
	void test_illegalNumberOfArguments() {
		
		assertThatThrownBy(() -> DomainUtils.getCarCombinataValue(5,7,3,4))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
