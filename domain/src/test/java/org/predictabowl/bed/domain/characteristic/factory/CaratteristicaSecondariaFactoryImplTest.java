package org.predictabowl.bed.domain.characteristic.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
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
import org.predictabowl.bed.domain.characteristic.CaratteristicaSecondaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;

class CaratteristicaSecondariaFactoryImplTest {

	@Mock
	private AttributiFunctionFactory attrFactory;
	@Mock
	private AttributiFunction attrFunction;
	private AutoCloseable openMocks;
	
	@BeforeEach
	void setUp() {
		openMocks = MockitoAnnotations.openMocks(this);
		when(attrFactory.get(any(), any())).thenReturn(attrFunction);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		openMocks.close();
	}
	
	@Test
	void test() {
		CaratteristicaSecondariaFactoryImpl sut = new CaratteristicaSecondariaFactoryImpl(attrFactory);
		RefInteger value = new RefInteger(3);
		
		CaratteristicaSecondaria result = sut.get(DataCaratteristicaSecondaria.CONOSCENZA, value);
		
		verify(attrFactory).get(value, DataCaratteristicaSecondaria.CONOSCENZA);
		assertThat(result).isInstanceOf(CaratteristicaSecondaria.class);
		assertThat(result.getAttributi()).isSameAs(attrFunction);
		assertThat(result.getType()).isEqualTo(DataCaratteristicaSecondaria.CONOSCENZA);
		assertThat(result.getValue()).isEqualTo(3);
	}

}
