package org.predictabowl.bed.domain.constants;

import java.util.EnumMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.IntUnaryOperator;
import java.util.stream.Stream;

import org.predictabowl.bed.domain.utils.FunctionsProvider;

public enum DataCaratteristicaSecondaria implements FunctionsProvider {
	MUSCOLI,
	VIGORE,
	EQUILIBRIO,
	PRECISIONE,
	SALUTE,
	RESISTENZA,
	RAGIONE,
	CONOSCENZA,
	INTUIZIONE,
	VOLONTA,
	RISOLUTEZZA,
	PRESENZA;

	public DataCaratteristicaPrimaria getCarPrimaria() {
		return Stream.of(DataCaratteristicaPrimaria.values())
			.filter(c -> equals(c.sub1) || equals(c.sub2))
				.findFirst().orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Map<TipoAttributo, IntUnaryOperator> getAttributoFunctions() {
		EnumMap<TipoAttributo, IntUnaryOperator> map = new EnumMap<>(TipoAttributo.class);
		switch (this) {
			case MUSCOLI: 
				map.put(TipoAttributo.CARICO, v -> v * 10 + 2);
				map.put(TipoAttributo.PCRIT, v -> v * 3 - 7);
				break;
			
			case VIGORE:
				map.put(TipoAttributo.PARARE, v -> v * 3 - 18);
				map.put(TipoAttributo.PF, v -> v * 6 + 5);
				break;
			
			default: break;
		}
		return map;
	}

}
