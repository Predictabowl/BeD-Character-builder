package org.predictabowl.bed.domain.attributes.factory;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.IntUnaryOperator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.predictabowl.bed.commons.utils.RefInteger;
import org.predictabowl.bed.domain.attributes.AttributiFunction;
import org.predictabowl.bed.domain.constants.TipoAttributo;
import org.predictabowl.bed.domain.utils.AttributiFunctionsRetriever;
import org.predictabowl.bed.domain.utils.FunctionsProvider;

class AttributiFunctionFactoryImplTest {

	private AttributiFunctionFactoryImpl sut;
	@Mock
	private AttributiFunctionsRetriever retriever;
	@Mock
	private FunctionsProvider provider;
	
	private AutoCloseable openMocks;
	
	@BeforeEach
	void setUp() {
		openMocks = MockitoAnnotations.openMocks(this);
		sut = new AttributiFunctionFactoryImpl(retriever);
	}
	
	@AfterEach
	void tearDown() throws Exception{
		openMocks.close();
	}
	
	@Test
	void test() {
		Map<TipoAttributo, IntUnaryOperator> functions = new EnumMap<>(TipoAttributo.class);
		when(retriever.get(any())).thenReturn(functions);
		RefInteger variable = new RefInteger(3);
		
		AttributiFunction result = sut.get(variable, provider);
		
		verify(retriever).get(provider);
		assertThat(result.getFunctions()).isSameAs(functions);
		assertThat(result.getVariable()).isSameAs(variable);
	}

}
