package org.predictabowl.bed.domain.characteristic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.predictabowl.bed.domain.attributes.AttributiCollection;
import org.predictabowl.bed.domain.attributes.AttributiInterface;
import org.predictabowl.bed.domain.attributes.factory.AttributiCollectionFactory;
import org.predictabowl.bed.domain.characteristic.factory.CaratteristicaPrimariaFactoryImpl;
import org.predictabowl.bed.domain.characteristic.model.CarPValue;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;

class CaratteristicheTest {

	@Mock
	private CaratteristicaPrimariaFactoryImpl carFactory;
	@Mock
	private AttributiCollectionFactory attrCollFactory;
	@Mock
	private AttributiCollection attributeCollection;
	
	@Captor
	ArgumentCaptor<Collection<AttributiInterface>> attributiCaptor;
	
	private Map<DataCaratteristicaPrimaria, CaratteristicaPrimaria> fixtureCaratt;
	
	private AutoCloseable openMocks;
	
	@BeforeEach
	void setUp() {
		openMocks = MockitoAnnotations.openMocks(this);
		fixtureCaratt = Stream.of(DataCaratteristicaPrimaria.values())
				.collect(Collectors.toMap(c -> c, c -> mock(CaratteristicaPrimaria.class)));
		fixtureCaratt.forEach((k,v) -> when(carFactory.get(eq(k), any()))
				.thenReturn(v));
	}
	
	@AfterEach
	void tearDown() throws Exception {
		openMocks.close();
	}
	
	@Test
	void test_constructor() {
		List<AttributiInterface> subAttributi = fixtureCaratt.values().stream()
				.map(c -> {
					AttributiInterface ai = mock(AttributiInterface.class);
					when(c.getAttributi()).thenReturn(ai);
					return ai;
				}).toList();
		
		getSutInstance();
		
		Stream.of(DataCaratteristicaPrimaria.values()).forEach(c -> {
			verify(carFactory).get(c, new CarPValue(5));
			verify(fixtureCaratt.get(c)).getAttributi();
		});
		
		verify(attrCollFactory).get(attributiCaptor.capture());
		assertThat(attributiCaptor.getValue())
			.containsExactlyInAnyOrderElementsOf(subAttributi);
	}
	
	@Test
	void test_getCaratteristica_whenIsPrimaria() {
		Caratteristiche cars = getSutInstance();
		DataCaratteristicaPrimaria[] carPrimarie = DataCaratteristicaPrimaria.values();
		
		Stream.of(carPrimarie).forEach(c -> 
				assertThat(cars.getCaratteristica(c))
					.isSameAs(fixtureCaratt.get(c)));
	}
	
	@Test
	void test_getCaratteristica_whenIsSecondaria() {
		CaratteristicaSecondaria car1 = mock(CaratteristicaSecondaria.class);
		CaratteristicaSecondaria car2 = mock(CaratteristicaSecondaria.class);
		DataCaratteristicaPrimaria carP = DataCaratteristicaPrimaria.FORZA;
		when(fixtureCaratt.get(carP).getSubCar1()).thenReturn(car1);
		when(fixtureCaratt.get(carP).getSubCar2()).thenReturn(car2);
		when(car1.getType()).thenReturn(carP.sub1);
		when(car2.getType()).thenReturn(carP.sub2);
		
		Caratteristiche cars = getSutInstance();
		
		assertThat(cars.getCaratteristica(carP.sub1))
			.isSameAs(car1);
		assertThat(cars.getCaratteristica(carP.sub2))
			.isSameAs(car2);
	}
	
	@Test
	void test_getAttributi() {
		when(attrCollFactory.get(any())).thenReturn(attributeCollection);
		
		Caratteristiche sutInstance = getSutInstance();
		
		assertThat(sutInstance.getAttributi()).isSameAs(attributeCollection);
		
	}
	
	private Caratteristiche getSutInstance() {
		return new Caratteristiche(carFactory, attrCollFactory);
	}
}
