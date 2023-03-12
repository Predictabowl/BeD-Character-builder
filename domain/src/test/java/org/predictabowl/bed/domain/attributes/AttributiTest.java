package org.predictabowl.bed.domain.attributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.predictabowl.bed.domain.constants.TipoAttributo;

class AttributiTest {

	private Attributi sut;
	private Map<TipoAttributo, Integer> values;

	@BeforeEach
	void setUp() {
		sut = spy(new Attributi());
		values = sut.getMap();
	}
	
	@Test
	void test_getValue_whenMissing() {
		
		int result = sut.getValue(TipoAttributo.CRIT);
		
		assertThat(result).isZero();
		assertThat(values).isEmpty();
	}
	
	@Test
	void test_getValue_whenPresent() {
		values.put(TipoAttributo.CRIT, 4);

		int result = sut.getValue(TipoAttributo.CRIT);
		
		assertThat(result).isEqualTo(4);
	}
	
	@Test
	void test_setValue() {
		values.put(TipoAttributo.MCG, 7);
		
		assertThat(values).containsExactly(Map.entry(TipoAttributo.MCG,7));
	}
	
	@Test
	void test_setAttributo_whenValueZeroShouldBeRemoved() {
		values.put(TipoAttributo.CARICO, 5);
		
		assertThat(values).contains(Map.entry(TipoAttributo.CARICO, 5));
		
		sut.setValue(TipoAttributo.CARICO,0);
		
		assertThat(values).isEmpty();
	}
	
	@Test
	void test_modAttributo() {
		sut.modValue(TipoAttributo.CRIT,10);
		assertThat(values).contains(Map.entry(TipoAttributo.CRIT, 10));
		
		sut.modValue(TipoAttributo.CRIT,-3);
		assertThat(values).contains(Map.entry(TipoAttributo.CRIT, 7));
		
		sut.modValue(TipoAttributo.CRIT,-7);
		assertThat(values).isEmpty();
	}
	
	@Test
	void test_mergeAttributi() {
		values.put(TipoAttributo.CARICO, 1);
		values.put(TipoAttributo.PARARE, 5);
		
		Attributi attrs2 = new Attributi();
		Map<TipoAttributo,Integer> values2 = attrs2.getMap();
		values2.put(TipoAttributo.CRIT, 4);
		values2.put(TipoAttributo.CARICO, 5);
		
		Attributi result = sut.merge(attrs2);
		Map<TipoAttributo, Integer> resultMap = result.getMap();
		
		assertThat(resultMap).isNotSameAs(values)
			.isNotSameAs(values2);
		Map<TipoAttributo, Integer> expectedMap = new EnumMap<>(TipoAttributo.class);
		expectedMap.put(TipoAttributo.CARICO, 6);
		expectedMap.put(TipoAttributo.CRIT, 4);
		expectedMap.put(TipoAttributo.PARARE, 5);
		assertThat(resultMap).containsExactlyInAnyOrderEntriesOf(expectedMap);
	}
	
	@Test
	void test_constructorFromMap() {
		Map<TipoAttributo, Integer> inputMap = new EnumMap<>(TipoAttributo.class);
		inputMap.put(TipoAttributo.CRIT, 3);
		inputMap.put(TipoAttributo.MCG, 5);
		inputMap.put(TipoAttributo.PARARE, 0);
		
		Attributi attrs = new Attributi(inputMap);
		
		assertThat(attrs.getMap()).containsExactly(
				Map.entry(TipoAttributo.CRIT, 3),
				Map.entry(TipoAttributo.MCG, 5));
	}

}
