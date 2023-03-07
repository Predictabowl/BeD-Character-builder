package org.predictabowl.bed.domain.characteristic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.predictabowl.bed.domain.characteristic.TipoCaratteristica.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.predictabowl.bed.commons.exceptions.BeDIllegalValueException;
import org.predictabowl.bed.domain.attributes.Attributi;
import org.predictabowl.bed.domain.attributes.Attributo;
import org.predictabowl.bed.domain.attributes.TipoAttributo;

class CaratteristicaPrimariaTest {

	private static final int FIXTURE_MAX_VALUE = 10;
	private static final int FIXTURE_MIN_VALUE = 1;
	private static final int FIXTURE_VALUE = 7;

	private CaratteristicaPrimaria sut;
	
	class CarPrimariaTest extends CaratteristicaPrimaria {

		public CarPrimariaTest() {
			super(TipoCaratteristica.FORZA, 5);
		}
		
		public void setTestList(Attributi list) {
			setAttributes(list);
		}
		
	}
	
	@BeforeEach
	void setUp() {
		sut = new CaratteristicaPrimaria(DESTREZZA, FIXTURE_VALUE);
	}

	@Test
	void test_cannotBuild_withNonPrimaryCar() {
		assertThatThrownBy(() -> new CaratteristicaPrimaria(CONOSCENZA))
			.isExactlyInstanceOf(BeDIllegalValueException.class);
	}
	
	@Test
	void test_baseValue_subCharacteristics() {
		Caratteristica sub1 = sut.getSubCar1();
		assertThat(sub1.getValue()).isEqualTo(FIXTURE_VALUE);
		assertThat(sub1.getType()).isEqualTo(DESTREZZA.sub1.get());
		Caratteristica sub2 = sut.getSubCar2();
		assertThat(sub2.getValue()).isEqualTo(FIXTURE_VALUE);
		assertThat(sub2.getType()).isEqualTo(DESTREZZA.sub2.get());
	}

	@Test
	void test_exceedinglimitValues_shouldThrow() {
		assertThatThrownBy(() -> new CaratteristicaPrimaria(DESTREZZA, FIXTURE_MIN_VALUE - 1))
				.isInstanceOf(BeDIllegalValueException.class);

		assertThatThrownBy(() -> new CaratteristicaPrimaria(DESTREZZA, FIXTURE_MAX_VALUE + 1))
				.isInstanceOf(BeDIllegalValueException.class);

		assertThatThrownBy(() -> sut.setValue(FIXTURE_MAX_VALUE + 1)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> sut.setValue(FIXTURE_MIN_VALUE - 1)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void test_setOffset_limitValues() {
		assertThatThrownBy(() -> sut.setOffset(2)).isInstanceOf(BeDIllegalValueException.class)
				.withFailMessage("Offset value must be between -1 ad 1.");

		assertThatThrownBy(() -> sut.setOffset(-2)).isInstanceOf(BeDIllegalValueException.class)
				.withFailMessage("Offset value must be between -1 ad 1.");
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
		assertThat(sut.getValue()).isEqualTo(FIXTURE_VALUE+2);
		
		sut.modValue(-3);
		assertThat(sut.getValue()).isEqualTo(FIXTURE_VALUE-1);
	}
	
	@Test
	void test_setOffset_shouldChange_SubCaracteristics() {
		sut.setOffset(1);
		
		assertThat(sut.getSubCar1().getValue()).isEqualTo(FIXTURE_VALUE+1);
		assertThat(sut.getSubCar2().getValue()).isEqualTo(FIXTURE_VALUE-1);
		
		sut.setOffset(-1);
		
		assertThat(sut.getSubCar1().getValue()).isEqualTo(FIXTURE_VALUE-1);
		assertThat(sut.getSubCar2().getValue()).isEqualTo(FIXTURE_VALUE+1);
		
		sut.setOffset(0);
		
		assertThat(sut.getSubCar1().getValue()).isEqualTo(FIXTURE_VALUE);
		assertThat(sut.getSubCar2().getValue()).isEqualTo(FIXTURE_VALUE);
	}
	
//	@Test
//	void test_getAllAttributes() {
//		Caratteristica s1 = Mockito.mock(Caratteristica.class);
//		Caratteristica s2 = Mockito.mock(Caratteristica.class);
//		CarPrimariaTest carP = spy(new CarPrimariaTest(s1, s2));
//		
//		List<Attributo> list1 = new LinkedList<>();
//		List<Attributo> list2 = new LinkedList<>();
//		List<Attributo> list3 = new LinkedList<>();
//		Attributo attr1 = new Attributo(TipoAttributo.CARICO, 5);
//		Attributo attr2 = new Attributo(TipoAttributo.PARARE, 3);
//		Attributo attr3 = new Attributo(TipoAttributo.VA, 7);
//		list1.add(attr1);
//		list2.add(attr2);
//		list3.add(attr3);
//		carP.setTestList(list3);
//		when(s1.getAttributes()).thenReturn(list1);
//		when(s2.getAttributes()).thenReturn(list2);
//		
//		List<Attributo> result = carP.getAllAttributes();
//		
//		assertThat(result).containsExactlyInAnyOrder(attr1,attr2,attr3);
//	}
//
//	@Test
//	void test_getAttribute() {
//		CaratteristicaPrimaria carP = spy(new CaratteristicaPrimaria(EQUILIBRIO, 5, sub2, sub1));
//		
//		Attributo result = carP.getAttribute(TipoAttributo.VA);
//		
//		InOrder inOrder = Mockito.inOrder(carP);
//		inOrder.verify(carP).getAllAttributes();
//		inOrder.verify(carP).getSummedAttribute(null, TipoAttributo.VA);
//	}
}
