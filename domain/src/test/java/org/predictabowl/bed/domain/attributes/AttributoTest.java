package org.predictabowl.bed.domain.attributes;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AttributoTest {

	@Test
	void test_addAttributiDiTipoDiverso() {
		Attributo sut = new Attributo(TipoAttributo.CARICO, 3);
		Attributo attr = new Attributo(TipoAttributo.PARARE, 3);
		
		Attributo result = sut.addSummable(attr);
		
		assertThat(sut.getValue()).isEqualTo(3);
		assertThat(result).isSameAs(sut);
	}
	
	@Test
	void test_addAttributiDiTipoUguale() {
		Attributo sut = new Attributo(TipoAttributo.CRIT, 3);
		Attributo attr = new Attributo(TipoAttributo.CRIT, 7);
		
		Attributo result = sut.addSummable(attr);
		
		assertThat(sut.getValue()).isEqualTo(10);
		assertThat(result).isSameAs(sut);
	}

}
