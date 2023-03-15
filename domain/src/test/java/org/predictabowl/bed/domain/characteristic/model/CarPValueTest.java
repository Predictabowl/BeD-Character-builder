package org.predictabowl.bed.domain.characteristic.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.predictabowl.bed.commons.exceptions.BeDIllegalValueException;

class CarPValueTest {

	@Test
	void test_contructorLimitValues_shouldThrow() {
		assertThatThrownBy(() -> new CarPValue(CarPValue.MIN_VALUE-1))
				.isInstanceOf(BeDIllegalValueException.class);

		assertThatThrownBy(() -> new CarPValue(CarPValue.MAX_VALUE+1))
				.isInstanceOf(BeDIllegalValueException.class);
	}
	
	@Test
	void test_setLimitValues_shouldThrow() {
		CarPValue sut = new CarPValue(5);

		assertThatThrownBy(() -> sut.setValue(CarPValue.MAX_VALUE + 1))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> sut.setValue(CarPValue.MIN_VALUE - 1))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void test_modValue_shouldNotExceedLimits() {
		CarPValue sut = new CarPValue(5);
		
		sut.modValue(10);
		assertThat(sut.getValue()).isEqualTo(CarPValue.MAX_VALUE);

		sut.modValue(-11);
		assertThat(sut.getValue()).isEqualTo(CarPValue.MIN_VALUE);
	}

	@Test
	void test_modValue() {
		CarPValue sut = new CarPValue(5);
		
		sut.modValue(2);
		assertThat(sut.getValue()).isEqualTo(7);

		sut.modValue(-3);
		assertThat(sut.getValue()).isEqualTo(4);
	}

}
