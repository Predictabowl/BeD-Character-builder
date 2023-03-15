package org.predictabowl.bed.domain.utils;

import java.util.Map;
import java.util.function.IntUnaryOperator;

import org.predictabowl.bed.domain.constants.TipoAttributo;

public interface AttributiFunctionsRetriever {

	public Map<TipoAttributo, IntUnaryOperator> get(FunctionsProvider provider);
}
