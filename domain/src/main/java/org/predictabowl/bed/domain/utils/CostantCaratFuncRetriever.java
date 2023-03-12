package org.predictabowl.bed.domain.utils;

import java.util.Map;

import org.predictabowl.bed.domain.attributes.AttributoFunction;
import org.predictabowl.bed.domain.constants.CaratteristicaFunctions;
import org.predictabowl.bed.domain.constants.TipoAttributo;
import org.springframework.stereotype.Component;

@Component
public class CostantCaratFuncRetriever implements CaratteristicaFunctionsRetriever {

	@Override
	public Map<TipoAttributo, AttributoFunction> get(CaratteristicaFunctions carat) {
		return carat.getAttributoFunctions();
	}

}
