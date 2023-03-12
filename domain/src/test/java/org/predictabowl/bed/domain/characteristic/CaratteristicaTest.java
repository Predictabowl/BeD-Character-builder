package org.predictabowl.bed.domain.characteristic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.predictabowl.bed.domain.attributes.AttributoFunction;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.predictabowl.bed.domain.constants.TipoAttributo;
import org.predictabowl.bed.domain.utils.CaratteristicaFunctionsRetriever;

class CaratteristicaTest {

	private final static int FIXTURE_CAR_VAL = 5;
	
	private Caratteristica<?> sut;
	
	@Mock
	private CaratteristicaFunctionsRetriever carFRetr;

	private AutoCloseable openMocks;
	
	@BeforeEach
	void setUp() {
		openMocks = MockitoAnnotations.openMocks(this);
		sut = makeCar(DataCaratteristicaSecondaria.MUSCOLI, FIXTURE_CAR_VAL);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		openMocks.close();
	}
	
	@Test
	void test_modValue() {
		sut.modValue(3);
		assertThat(sut.getValue()).isEqualTo(FIXTURE_CAR_VAL+3);
		
		sut.modValue(-5);
		assertThat(sut.getValue()).isEqualTo(FIXTURE_CAR_VAL+3-5);
	}
	
	@Test
	void test_getAttributo_whenMissing() {
		Map<TipoAttributo, AttributoFunction> map = new HashMap<>();
		when(carFRetr.get(any())).thenReturn(map);
		
		int result = sut.getAttributoValue(TipoAttributo.CRIT);
		
		assertThat(result).isZero();
		verify(carFRetr).get(DataCaratteristicaSecondaria.MUSCOLI);
	}
	
	@Test
	void test_getAttributo_whenPresent() {
		Map<TipoAttributo, AttributoFunction> map = new HashMap<>();
		map.put(TipoAttributo.CRIT, (v) -> v*2);
		when(carFRetr.get(any())).thenReturn(map);
		
		int result = sut.getAttributoValue(TipoAttributo.CRIT);
		
		assertThat(result).isEqualTo(FIXTURE_CAR_VAL*2);
		verify(carFRetr).get(DataCaratteristicaSecondaria.MUSCOLI);
	}
	
	private Caratteristica<?> makeCar(DataCaratteristicaSecondaria type, int value) {
		return new Caratteristica<>(type, carFRetr, value);
	}

}
