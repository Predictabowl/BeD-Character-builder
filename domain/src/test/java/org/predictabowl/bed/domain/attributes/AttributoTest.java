package org.predictabowl.bed.domain.attributes;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.predictabowl.bed.domain.constants.TipoAttributo;

class AttributoTest {

	@Test
	void test_merge_whenSameType() {
		Attributo a1 = new Attributo(TipoAttributo.CARICO, 3);
		Attributo a2 = new Attributo(TipoAttributo.CARICO, 5);
		
		Attributo result = a1.merge(a2);
		
		assertThat(result).usingRecursiveComparison()
			.isEqualTo(new Attributo(TipoAttributo.CARICO, 8))
			.isNotSameAs(a1);
	}
	
	@Test
	void test_merge_whenDifferentTpye() {
		Attributo a1 = new Attributo(TipoAttributo.CARICO, 3);
		Attributo a2 = new Attributo(TipoAttributo.CRIT, 5);
		
		Attributo result = a1.merge(a2);
		
		assertThat(result).usingRecursiveComparison()
			.isEqualTo(a1)
			.isNotSameAs(a1);
	}
	
	@Test
	void test_modValue() {
		Attributo a1 = new Attributo(TipoAttributo.CARICO, 3);
		
		a1.modValue(5);
		assertThat(a1.getValue()).isEqualTo(8);
		
		a1.modValue(-10);
		assertThat(a1.getValue()).isEqualTo(-2);
	}

}
