package org.predictabowl.bed.domain.equip;

import org.predictabowl.bed.domain.attributes.Attributi;
import org.predictabowl.bed.domain.constants.DataTipoEquip;

public class Arma extends OggettoEquip{

	protected Arma(long id) {
		super(id, DataTipoEquip.ARMA);
	}
	
	protected Arma(long id, Attributi attributi) {
		super(id, DataTipoEquip.ARMA, attributi);
	}

}
