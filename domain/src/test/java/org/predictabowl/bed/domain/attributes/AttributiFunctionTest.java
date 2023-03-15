package org.predictabowl.bed.domain.attributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntUnaryOperator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.predictabowl.bed.commons.utils.RefInteger;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.predictabowl.bed.domain.constants.TipoAttributo;

class AttributiFunctionTest {

	private Map<TipoAttributo, IntUnaryOperator> fixtureMap;
	private AttributiFunction sut;
	private RefInteger variable;
	
	@BeforeEach
	void setUp() {
		fixtureMap = new EnumMap<>(TipoAttributo.class);
		variable = new RefInteger(5);
		sut = new AttributiFunction(variable, fixtureMap);
	}
	
	@Test
	void test_getValue() {
		fixtureMap.put(TipoAttributo.CRIT, v -> v*2);
		
		int value = sut.getValue(TipoAttributo.CRIT);
		
		assertThat(value).isEqualTo(10);
		
		variable.setValue(7);
		assertThat(sut.getValue(TipoAttributo.CRIT)).isEqualTo(14);
	}

	@Test
	void test_getValue_whenFunctionIsMissing() {
		
		int result = sut.getValue(TipoAttributo.CRIT);
		
		assertThat(result).isZero();
	}
	
}
