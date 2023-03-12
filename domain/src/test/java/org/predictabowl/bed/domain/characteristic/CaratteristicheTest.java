package org.predictabowl.bed.domain.characteristic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.predictabowl.bed.domain.characteristic.factory.CaratteristicaPrimariaFactory;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.predictabowl.bed.domain.constants.TipoAttributo;

class CaratteristicheTest {

	@Mock
	private CaratteristicaPrimariaFactory carFactory;
	@Mock
	private CaratteristicaPrimaria carP;
	
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
	void test_constructor() {
		when(carFactory.get(any(), anyInt())).thenReturn(carP);
		
		getSutInstance();
		
		Stream.of(DataCaratteristicaPrimaria.values()).forEach(c -> {
			verify(carFactory).get(c, 5);
		});
	}
	
	@Test
	void test_getCaratteristica_whenIsPrimaria() {
		Map<DataCaratteristicaPrimaria, CaratteristicaPrimaria> mocks = 
				Stream.of(DataCaratteristicaPrimaria.values())
				.collect(Collectors.toMap(c -> c, c -> mock(CaratteristicaPrimaria.class)));
		mocks.forEach((k,v) -> when(carFactory.get(eq(k), anyInt()))
				.thenReturn(v));

		Caratteristiche cars = getSutInstance();
		DataCaratteristicaPrimaria[] carPrimarie = DataCaratteristicaPrimaria.values();
		
		Stream.of(carPrimarie).forEach(c -> 
				assertThat(cars.getCaratteristica(c))
					.isSameAs(mocks.get(c)));
	}
	
	@Test
	void test_getCaratteristica_whenIsSecondaria() {
		when(carFactory.get(any(), anyInt())).thenReturn(carP);
		CaratteristicaSecondaria car1 = mock(CaratteristicaSecondaria.class);
		CaratteristicaSecondaria car2 = mock(CaratteristicaSecondaria.class);
		when(carP.getSubCar1()).thenReturn(car1);
		when(carP.getSubCar2()).thenReturn(car2);
		when(car1.getType()).thenReturn(DataCaratteristicaSecondaria.MUSCOLI);
		when(car2.getType()).thenReturn(DataCaratteristicaSecondaria.VIGORE);
		
		Caratteristiche cars = getSutInstance();
		
		assertThat(cars.getCaratteristica(DataCaratteristicaSecondaria.MUSCOLI))
			.isSameAs(car1);
		assertThat(cars.getCaratteristica(DataCaratteristicaSecondaria.VIGORE))
			.isSameAs(car2);
	}
	
	@Test
	void test_getAttributo() {
		Map<DataCaratteristicaPrimaria,CaratteristicaPrimaria> map = 
				Stream.of(DataCaratteristicaPrimaria.values())
					.collect(Collectors.toMap(t -> t, t -> mock(CaratteristicaPrimaria.class)));
		
		map.forEach((k,v) -> {
			when(carFactory.get(eq(k), anyInt())).thenReturn(v);
			when(v.getAttributoValue(any())).thenReturn(2);
		});
		
		Caratteristiche sut = getSutInstance();
		int result = sut.getAttributo(TipoAttributo.CRIT);
		
		assertThat(result).isEqualTo(map.values().size()*2);
		map.values().forEach(c -> {
			verify(c).getAttributoValue(TipoAttributo.CRIT);
		});
	}
	
	private Caratteristiche getSutInstance() {
		return new Caratteristiche(carFactory);
	}
}
