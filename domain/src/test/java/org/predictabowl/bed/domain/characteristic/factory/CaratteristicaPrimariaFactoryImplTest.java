package org.predictabowl.bed.domain.characteristic.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.predictabowl.bed.commons.utils.RefInteger;
import org.predictabowl.bed.domain.attributes.factory.AttributiCollectionFactory;
import org.predictabowl.bed.domain.attributes.factory.AttributiFunctionFactory;
import org.predictabowl.bed.domain.characteristic.CaratteristicaPrimaria;
import org.predictabowl.bed.domain.characteristic.CaratteristicaSecondaria;
import org.predictabowl.bed.domain.characteristic.model.CarPValue;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.predictabowl.bed.domain.utils.FunctionsProvider;

class CaratteristicaPrimariaFactoryImplTest {

	@Mock
	private 
	CaratteristicaSecondariaFactoryImpl carFactory;
	@Mock
	private AttributiFunctionFactory attrFuncFactory;
	@Mock
	private AttributiCollectionFactory attrCollFactory;
	@Mock
	private CaratteristicaSecondaria carS1;
	
	private AutoCloseable openMocks;
	
	@BeforeEach
	void setUp() {
		openMocks = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		openMocks.close();
	}
	
	@Test
	void test() {
		CaratteristicaPrimariaFactoryImpl sut = new CaratteristicaPrimariaFactoryImpl( 
				attrFuncFactory, carFactory, attrCollFactory);
		when(carFactory.get(any(), any())).thenReturn(carS1);
		
		CarPValue value = new CarPValue(3);
		CaratteristicaPrimaria result = sut.get(DataCaratteristicaPrimaria.CARISMA, value);
		
		assertThat(result).isExactlyInstanceOf(CaratteristicaPrimaria.class);
		verify(attrCollFactory).get(any());
		verify(carFactory, times(2))
			.get(isA(DataCaratteristicaSecondaria.class), isA(RefInteger.class));
		verify(attrFuncFactory).get(isA(RefInteger.class), isA(FunctionsProvider.class));
		assertThat(result.getValue()).isEqualTo(3);
	}

}
