package org.predictabowl.bed.domain.utils;

import java.util.Map;
import java.util.function.IntUnaryOperator;

import org.predictabowl.bed.domain.constants.TipoAttributo;
import org.springframework.stereotype.Component;

@Component
public class CostantCaratFuncRetriever implements AttributiFunctionsRetriever {

	@Override
	public Map<TipoAttributo, IntUnaryOperator> get(FunctionsProvider carat) {
		return carat.getAttributoFunctions();
	}

}
