package org.predictabowl.bed.domain.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.predictabowl.bed.domain.attributes.AttributoFunction;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;
import org.predictabowl.bed.domain.constants.TipoAttributo;

class CostantCaratFuncRetrieverTest {

	@Test
	void test() {
		CostantCaratFuncRetriever sut = new CostantCaratFuncRetriever();
		DataCaratteristicaPrimaria car = DataCaratteristicaPrimaria.COSTITUZIONE;
		
		Map<TipoAttributo, AttributoFunction> result = sut.get(car);
		
		assertThat(result).isEqualTo(car.getAttributoFunctions());
		
	}

}
