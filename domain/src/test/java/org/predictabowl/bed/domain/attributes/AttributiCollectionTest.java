package org.predictabowl.bed.domain.attributes;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.predictabowl.bed.domain.constants.TipoAttributo;

class AttributiCollectionTest {

	private static final int FIXTURE_VALUE_1 = 5;
	private static final int FIXTURE_VALUE_2 = 7;
	private static final int FIXTURE_VALUE_3 = 13;
	
	private AttributiCollection sut;
	private List<AttributiInterface> mocks;
	
	@BeforeEach
	void setUp() {
		mocks = new ArrayList<>();
		mocks.add(mock(AttributiInterface.class));
		mocks.add(mock(AttributiInterface.class));
		mocks.add(mock(AttributiInterface.class));
		
		sut = new AttributiCollection(mocks);
		
		when(mocks.get(0).getValue(any())).thenReturn(FIXTURE_VALUE_1);
		when(mocks.get(1).getValue(any())).thenReturn(FIXTURE_VALUE_2);
		when(mocks.get(2).getValue(any())).thenReturn(FIXTURE_VALUE_3);
	}
	
	@Test
	void test_getValue() {
		int result = sut.getValue(TipoAttributo.CRIT);
		
		assertThat(result).isEqualTo(FIXTURE_VALUE_1+FIXTURE_VALUE_2+FIXTURE_VALUE_3);
		verify(mocks.get(0)).getValue(TipoAttributo.CRIT);
		verify(mocks.get(1)).getValue(TipoAttributo.CRIT);
		verify(mocks.get(2)).getValue(TipoAttributo.CRIT);
	}

}
