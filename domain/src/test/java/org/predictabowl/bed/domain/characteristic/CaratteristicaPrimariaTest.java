package org.predictabowl.bed.domain.characteristic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria.DESTREZZA;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.predictabowl.bed.commons.utils.RefInteger;
import org.predictabowl.bed.domain.attributes.AttributiCollection;
import org.predictabowl.bed.domain.attributes.AttributiFunction;
import org.predictabowl.bed.domain.attributes.AttributiInterface;
import org.predictabowl.bed.domain.attributes.factory.AttributiCollectionFactory;
import org.predictabowl.bed.domain.attributes.factory.AttributiFunctionFactory;
import org.predictabowl.bed.domain.characteristic.factory.CaratteristicaSecondariaFactory;
import org.predictabowl.bed.domain.characteristic.model.CarPValue;
import org.predictabowl.bed.domain.characteristic.model.SubCarOffset;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;

class CaratteristicaPrimariaTest {

	private static final int FIXTURE_VALUE = 7;

	private CaratteristicaPrimaria sut;
	@Mock
	private CaratteristicaSecondariaFactory carFactory;
	@Mock
	private AttributiFunctionFactory attrFunFactory;
	@Mock
	private AttributiCollectionFactory attrCollFactory;
	@Mock
	private AttributiCollection attrCollection;
	@Mock
	private CarPValue carPValue;
	@Mock
	private CaratteristicaSecondaria carS1;
	@Mock
	private CaratteristicaSecondaria carS2;
	@Mock
	private AttributiFunction attributiI0;
	@Mock
	private AttributiInterface attributiI1;
	@Mock
	private AttributiInterface attributiI2;
	@Captor
	private ArgumentCaptor<Collection<AttributiInterface>> collCaptor;
	
	private AutoCloseable openMocks;

	@BeforeEach
	void setUp() {
		openMocks = MockitoAnnotations.openMocks(this);
		when(carPValue.getValue()).thenReturn(FIXTURE_VALUE);
		when(attrFunFactory.get(any(), isA(DataCaratteristicaPrimaria.class)))
			.thenReturn(attributiI0);
		when(carFactory.get(eq(DESTREZZA.sub1), any())).thenReturn(carS1);
		when(carFactory.get(eq(DESTREZZA.sub2), any())).thenReturn(carS2);
		when(carS1.getAttributi()).thenReturn(attributiI1);
		when(carS2.getAttributi()).thenReturn(attributiI2);
		when(attrCollFactory.get(any())).thenReturn(attrCollection);
		sut = makeCarPr(DESTREZZA);
	}

	@AfterEach
	void tearDown() throws Exception {
		openMocks.close();
	}

	@Test
	void test_constructSubCars() {
		when(carPValue.getValue()).thenReturn(15);
		
		verify(attrFunFactory).get(carPValue, DESTREZZA);
		assertThat(sut.getValue()).isEqualTo(15);
		
		verify(carFactory).get(DESTREZZA.sub1, new RefInteger(FIXTURE_VALUE));
		verify(carFactory).get(DESTREZZA.sub2, new RefInteger(FIXTURE_VALUE));
		assertThat(sut.getSubCar1()).isSameAs(carS1);
		assertThat(sut.getSubCar2()).isSameAs(carS2);
		
	}
	
	@Test
	void test_constructAttributiCollection() {
		verify(attrCollFactory).get(collCaptor.capture());
		assertThat(collCaptor.getValue())
			.containsExactlyInAnyOrder(attributiI0, attributiI1, attributiI2);
		assertThat(sut.getAttributi()).isSameAs(attrCollection);
	}

	@Test
	void test_offset() {
		
		sut.setOffset(new SubCarOffset(1));

		verify(carS1).setValue(FIXTURE_VALUE+1);
		verify(carS2).setValue(FIXTURE_VALUE-1);
		
		sut.setOffset(new SubCarOffset(0));

		verify(carS1).setValue(FIXTURE_VALUE);
		verify(carS2).setValue(FIXTURE_VALUE);
	}

	@Test
	void test_modValue() {
		sut.modValue(2);
		verify(carPValue).modValue(2);
	}
	
	@Test
	void test_setValue() {
		sut.setValue(3);
		verify(carPValue).setValue(3);
	}
	
	private CaratteristicaPrimaria makeCarPr(DataCaratteristicaPrimaria type) {
		return new CaratteristicaPrimaria(type, carPValue, carFactory, 
				attrFunFactory, attrCollFactory);
	}
}
