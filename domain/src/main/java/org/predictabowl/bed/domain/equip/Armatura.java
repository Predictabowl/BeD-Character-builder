package org.predictabowl.bed.domain.equip;

import org.predictabowl.bed.domain.attributes.Attributi;
import org.predictabowl.bed.domain.constants.DataTipoEquip;

public class Armatura extends OggettoEquip{

	protected Armatura(long id) {
		super(id, DataTipoEquip.ARMATURA);
	}

	protected Armatura(long id, Attributi attributi) {
		super(id, DataTipoEquip.ARMATURA, attributi);
	}
}
