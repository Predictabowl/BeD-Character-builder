package org.predictabowl.bed.domain.utils;

import java.util.Map;
import java.util.function.IntUnaryOperator;

import org.predictabowl.bed.domain.constants.TipoAttributo;

public interface FunctionsProvider {
	
	public Map<TipoAttributo, IntUnaryOperator> getAttributoFunctions();
}
