package org.predictabowl.bed.domain.attributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.predictabowl.bed.domain.attributes.TipoAttributo.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AttributiTest {

	private Attributi sut;
	
	@BeforeEach
	void setUp() {
		sut = new Attributi();
	}
	
	@Test
	void test_getAttributo() {
		Attributo result = sut.getAttributo(CRIT);
		List<Attributo> list = sut.getAttributi();
		
		assertThat(result).isEqualTo(new Attributo(CRIT, 0));
		assertThat(list).isEmpty();
	}
	
//	@Test
//	void test_addAttributo() {
//		Attributo attr = new Attributo(PARARE, 10);
//		
//		sut.addAttributo(attr);
//		List<Attributo> map = sut.getAttributi();
//		
//		assertThat(map).contains(attr);
//		
//		Attributo spyAttr = spy(map.get(0));
//		map.put(PARARE, spyAttr);
//		sut.addAttributo(attr);
//		
//		verify(spyAttr).addSummable(attr);
//	}
	
//	@Test
//	void test_addSummable() {
//		Attributo attr1 = spy(new Attributo(CARICO, 5));
//		Attributo attr2 = spy(new Attributo(CRIT, 3));
//		Attributo attr3 = spy(new Attributo(CRIT, 4));
//		Attributo attr4 = spy(new Attributo(VA, 6));
//		
//		Map<TipoAttributo, Attributo> map = sut.getMap();
//		map.put(CARICO, attr1);
//		map.put(CRIT, attr2);
//		
//		Attributi attrs = new Attributi();
//		Map<TipoAttributo, Attributo> map2 = attrs.getMap();
//		map2.put(CRIT, attr3);
//		map2.put(VA, attr4);
//		
//		sut.addSummable(attrs);
//		
//		verify(attr1).addSummable(attr3);
//		verify(attr1).addSummable(attr4);
//		verify(attr2).addSummable(attr3);
//		verify(attr2).addSummable(attr4);
//		
//		assertThat(map).size().isEqualTo(3);
//		assertThat(map).containsEntry(VA, attr4);
//	}

}
