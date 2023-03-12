package org.predictabowl.bed.domain.characteristic.factory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.predictabowl.bed.domain.characteristic.Caratteristica;
import org.predictabowl.bed.domain.characteristic.CaratteristicaPrimaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;
import org.predictabowl.bed.domain.utils.CaratteristicaFunctionsRetriever;

class CaratteristicaPrimariaFactoryTest {

	@Mock
	private 
	CaratteristicaSecondariaFactory carFactory;
	@Mock
	private CaratteristicaFunctionsRetriever carFRetr;
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
		CaratteristicaPrimariaFactory sut = new CaratteristicaPrimariaFactory( 
				carFRetr, carFactory);
		
		CaratteristicaPrimaria result = sut.get(DataCaratteristicaPrimaria.CARISMA, 3);
		
		assertThat(result).isInstanceOf(Caratteristica.class);
		assertThat(result.getCarFRetriever()).isSameAs(carFRetr);
		assertThat(result.getCaratteristicaFactory()).isSameAs(carFactory);
		assertThat(result.getType()).isEqualTo(DataCaratteristicaPrimaria.CARISMA);
		assertThat(result.getValue()).isEqualTo(3);
	}

}
