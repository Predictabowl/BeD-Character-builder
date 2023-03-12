package org.predictabowl.bed.domain.constants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DataCaratteristicaSecondariaTest {

	@Test
	void test_getCarPrimaria_whenPresent() {
		DataCaratteristicaPrimaria result =
				DataCaratteristicaSecondaria.INTUIZIONE.getCarPrimaria();
		
		assertThat(result).isEqualTo(DataCaratteristicaPrimaria.SAGGEZZA);
	}
	
}
