package org.predictabowl.bed.domain.constants;

import static org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria.CONOSCENZA;
import static org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria.EQUILIBRIO;
import static org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria.INTUIZIONE;
import static org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria.MUSCOLI;
import static org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria.PRECISIONE;
import static org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria.PRESENZA;
import static org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria.RAGIONE;
import static org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria.RESISTENZA;
import static org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria.RISOLUTEZZA;
import static org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria.SALUTE;
import static org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria.VIGORE;
import static org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria.VOLONTA;

import java.util.EnumMap;
import java.util.Map;

import org.predictabowl.bed.domain.attributes.AttributoFunction;

public enum DataCaratteristicaPrimaria implements CaratteristicaFunctions{
	FORZA(MUSCOLI, VIGORE),
	DESTREZZA(EQUILIBRIO, PRECISIONE),
	COSTITUZIONE(RESISTENZA, SALUTE),
	INTELLIGENZA(CONOSCENZA, RAGIONE),
	SAGGEZZA(INTUIZIONE, VOLONTA),
	CARISMA(PRESENZA, RISOLUTEZZA);

	public final DataCaratteristicaSecondaria sub1;
	public final DataCaratteristicaSecondaria sub2;

	private DataCaratteristicaPrimaria(DataCaratteristicaSecondaria sub1, 
			DataCaratteristicaSecondaria sub2) {
		this.sub1 = sub1;
		this.sub2 = sub2;
	}

	@Override
	public Map<TipoAttributo, AttributoFunction> getAttributoFunctions() {
		return new EnumMap<>(TipoAttributo.class);
	}

}
