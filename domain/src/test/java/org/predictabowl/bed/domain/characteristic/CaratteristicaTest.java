package org.predictabowl.bed.domain.characteristic;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.spy;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.predictabowl.bed.domain.attributes.Attributi;
import org.predictabowl.bed.domain.attributes.Attributo;
import org.predictabowl.bed.domain.attributes.TipoAttributo;

class CaratteristicaTest {

	private Caratteristica sut;
	
	class CarTest extends Caratteristica{

		public CarTest() {
			super(TipoCaratteristica.INTELLIGENZA);
		}
		
		public void setTestAttr(Attributi list) {
			setAttributes(list);
		}
		
	}
	
	@Test
	void test_modValue() {
		sut = new Caratteristica(TipoCaratteristica.FORZA, 5);
		
		sut.modValue(3);
		assertThat(sut.getValue()).isEqualTo(8);
		
		sut.modValue(-5);
		assertThat(sut.getValue()).isEqualTo(3);
	}
	
	@Test
	void test_getAttributo() {
		CarTest car = new CarTest();
		Attributo attr1 = new Attributo(TipoAttributo.CARICO, 3);
		Attributo attr2 = new Attributo(TipoAttributo.CARICO, 2);
		Attributo attr3 = new Attributo(TipoAttributo.CRIT, 5);
		Attributi attrs = new Attributi();
		attrs.addAttributo(attr1);
		attrs.addAttributo(attr2);
		attrs.addAttributo(attr3);
		car.setTestAttr(attrs);
		
		Attributi attrs2 = car.getAttributes();
		
		
//		Attributo result = car.getAttribute(TipoAttributo.CARICO);
		
//		assertThat(result).isEqualTo(new Attributo(TipoAttributo.CARICO,5));
	}

}
