package org.predictabowl.bed.domain.constants;

import org.predictabowl.bed.domain.PersonaggioGiocante;
import org.predictabowl.bed.domain.utils.DomainUtils;

public enum DataTipoArma {
	AGILE,
	ARTEFATTO,
	BILANCIATA,
	MASSICCIA,;

	public int getLA(PersonaggioGiocante pg) {
		switch (this) {
			case AGILE:
				return pg.getCaratteristicaValue(DataCaratteristicaPrimaria.DESTREZZA);
			case ARTEFATTO:
				return pg.getCaratteristicaValue(DataCaratteristicaDerivata.MANA);
			case BILANCIATA:
				return DomainUtils.getCarCombinataValue(
						pg.getCaratteristicaValue(DataCaratteristicaPrimaria.FORZA),
						pg.getCaratteristicaValue(DataCaratteristicaPrimaria.DESTREZZA));
			case MASSICCIA:
				return pg.getCaratteristicaValue(DataCaratteristicaPrimaria.FORZA);
			default:
				throw new IllegalArgumentException("Unexpected value: " + this);
		}
	}
	
}
