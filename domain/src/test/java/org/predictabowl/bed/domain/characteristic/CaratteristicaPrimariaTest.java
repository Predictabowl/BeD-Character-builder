package org.predictabowl.bed.domain.characteristic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria.DESTREZZA;
import static org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria.CONOSCENZA;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.predictabowl.bed.commons.exceptions.BeDIllegalValueException;
import org.predictabowl.bed.domain.attributes.AttributoFunction;
import org.predictabowl.bed.domain.characteristic.factory.CaratteristicaFactory;
import org.predictabowl.bed.domain.characteristic.model.SubCarOffset;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.predictabowl.bed.domain.constants.TipoAttributo;
import org.predictabowl.bed.domain.utils.CaratteristicaFunctionsRetriever;

class CaratteristicaPrimariaTest {

	private static final int FIXTURE_MAX_VALUE = 10;
	private static final int FIXTURE_MIN_VALUE = 1;
	private static final int FIXTURE_VALUE = 7;

	private CaratteristicaPrimaria sut;
	@Mock
	private CaratteristicaFactory<CaratteristicaSecondaria, DataCaratteristicaSecondaria> carFactory;
	@Mock
	private CaratteristicaFunctionsRetriever carFRetriever;
	
	private AutoCloseable openMocks;

	@BeforeEach
	void setUp() {
		openMocks = MockitoAnnotations.openMocks(this);
		sut = makeCarPr(DESTREZZA, FIXTURE_VALUE);
	}

	@AfterEach
	void tearDown() throws Exception {
		openMocks.close();
	}

	@Test
	void test_baseValue_subCharacteristic1() {
		CaratteristicaSecondaria car = makeCar(CONOSCENZA, 2);
		when(carFactory.get(any(), anyInt())).thenReturn(car);

		CaratteristicaSecondaria sub1 = sut.getSubCar1();
		assertThat(sub1).isSameAs(car);
		verify(carFactory).get(DataCaratteristicaPrimaria.DESTREZZA.sub1, FIXTURE_VALUE);
	}
	
	@Test
	void test_baseValue_subCharacteristic2() {
		CaratteristicaSecondaria car = makeCar(CONOSCENZA, 3);
		when(carFactory.get(any(), anyInt())).thenReturn(car);

		CaratteristicaSecondaria sub2 = sut.getSubCar2();
		assertThat(sub2).isSameAs(car);
		verify(carFactory).get(DataCaratteristicaPrimaria.DESTREZZA.sub2, FIXTURE_VALUE);
	}
	
	@Test
	void test_offset() {
		CaratteristicaSecondaria car = makeCar(CONOSCENZA, 3);
		when(carFactory.get(any(), anyInt())).thenReturn(car);

		sut.setOffset(new SubCarOffset(1));

		sut.getSubCar2();
		verify(carFactory).get(DataCaratteristicaPrimaria.DESTREZZA.sub2, FIXTURE_VALUE-1);
		
		sut.getSubCar1();
		verify(carFactory).get(DataCaratteristicaPrimaria.DESTREZZA.sub1, FIXTURE_VALUE+1);
	}

	@Test
	void test_exceedinglimitValues_shouldThrow() {
		assertThatThrownBy(() -> makeCarPr(DESTREZZA, FIXTURE_MIN_VALUE-1))
				.isInstanceOf(BeDIllegalValueException.class);

		assertThatThrownBy(() -> makeCarPr(DESTREZZA, FIXTURE_MAX_VALUE+1))
				.isInstanceOf(BeDIllegalValueException.class);

		assertThatThrownBy(() -> sut.setValue(FIXTURE_MAX_VALUE + 1)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> sut.setValue(FIXTURE_MIN_VALUE - 1)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void test_modValue_shouldNotExceedLimits() {
		sut.modValue(10);
		assertThat(sut.getValue()).isEqualTo(FIXTURE_MAX_VALUE);

		sut.modValue(-11);
		assertThat(sut.getValue()).isEqualTo(FIXTURE_MIN_VALUE);
	}

	@Test
	void test_modValue() {
		sut.modValue(2);
		assertThat(sut.getValue()).isEqualTo(FIXTURE_VALUE + 2);

		sut.modValue(-3);
		assertThat(sut.getValue()).isEqualTo(FIXTURE_VALUE - 1);
	}
	
	@Test
	void test_getAttributo_shouldMergeResults() {
		Caratteristica<?> car1 = mock(CaratteristicaSecondaria.class);
		Caratteristica<?> car2 = mock(CaratteristicaSecondaria.class);
		when(car1.getAttributoValue(any())).thenReturn(3);
		when(car2.getAttributoValue(any())).thenReturn(5);
		
		CaratteristicaPrimaria spySut = spy(sut);
		doReturn(car1).when(spySut).getSubCar1();
		doReturn(car2).when(spySut).getSubCar2();
		Map<TipoAttributo, AttributoFunction> map = new EnumMap<>(TipoAttributo.class);
		when(carFRetriever.get(any())).thenReturn(map);
		map.put(TipoAttributo.CRIT, v -> -2);
		
		int result = spySut.getAttributoValue(TipoAttributo.CRIT);
		
		verify(spySut).getSubCar1();
		verify(spySut).getSubCar2();
		verify(car1).getAttributoValue(TipoAttributo.CRIT);
		verify(car2).getAttributoValue(TipoAttributo.CRIT);
		assertThat(result).isEqualTo(6);
	}
	
	private CaratteristicaPrimaria makeCarPr(DataCaratteristicaPrimaria type, int value) {
		return new CaratteristicaPrimaria(type, value, carFactory, carFRetriever);
	}
	
	private CaratteristicaSecondaria makeCar(DataCaratteristicaSecondaria type, int value) {
		return new CaratteristicaSecondaria(type, value, carFRetriever);
	}
}
