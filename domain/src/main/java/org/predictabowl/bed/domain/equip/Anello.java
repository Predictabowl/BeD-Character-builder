package org.predictabowl.bed.domain.equip;

import org.predictabowl.bed.domain.attributes.Attributi;
import org.predictabowl.bed.domain.constants.DataTipoEquip;

public class Anello extends OggettoEquip{

	protected Anello(long id) {
		super(id, DataTipoEquip.ANELLO);
	}

	public Anello(long id, Attributi attributi) {
		super(id, DataTipoEquip.ANELLO, attributi);
	}
}
