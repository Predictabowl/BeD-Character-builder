package org.predictabowl.bed.domain.characteristic.factory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.predictabowl.bed.domain.characteristic.CaratteristicaSecondaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.predictabowl.bed.domain.utils.CaratteristicaFunctionsRetriever;

class CaratteristicaSecondariaFactoryTest {

	@Mock
	private CaratteristicaFunctionsRetriever carFRetr;
	
	@Test
	void test() {
		MockitoAnnotations.openMocks(this);
		CaratteristicaSecondariaFactory sut = new CaratteristicaSecondariaFactory(carFRetr);
		
		CaratteristicaSecondaria result = sut.get(DataCaratteristicaSecondaria.CONOSCENZA, 3);
		
		assertThat(result).isInstanceOf(CaratteristicaSecondaria.class);
		assertThat(result.getCarFRetriever()).isSameAs(carFRetr);
		assertThat(result.getType()).isEqualTo(DataCaratteristicaSecondaria.CONOSCENZA);
		assertThat(result.getValue()).isEqualTo(3);
	}

}
