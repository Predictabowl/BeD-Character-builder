package org.predictabowl.bed.domain.characteristic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.predictabowl.bed.commons.utils.RefInteger;
import org.predictabowl.bed.domain.attributes.AttributiFunction;
import org.predictabowl.bed.domain.attributes.factory.AttributiFunctionFactory;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;

class CaratteristicaTest {

	private final static int FIXTURE_CAR_VAL = 5;
	
	private Caratteristica<?> sut;
	
	@Mock
	private AttributiFunctionFactory attrsFactory;
	@Mock
	private AttributiFunction attrFunc;

	private AutoCloseable openMocks;
	
	@BeforeEach
	void setUp() {
		openMocks = MockitoAnnotations.openMocks(this);
		when(attrsFactory.get(isA(RefInteger.class), any())).thenReturn(attrFunc);
		sut = makeCar(DataCaratteristicaSecondaria.MUSCOLI, FIXTURE_CAR_VAL);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		openMocks.close();
	}
	
	@Test
	void test_constructor(){
		
		verify(attrsFactory).get(isA(RefInteger.class), eq(DataCaratteristicaSecondaria.MUSCOLI));
		assertThat(sut.getAttributi()).isSameAs(attrFunc);
	}
	
	@Test
	void test_getValue() {
		assertThat(sut.getValue()).isEqualTo(FIXTURE_CAR_VAL);
	}
	
	
	private Caratteristica<?> makeCar(DataCaratteristicaSecondaria type, int value) {
		return new Caratteristica<>(type, new RefInteger(value), attrsFactory);
	}

}
