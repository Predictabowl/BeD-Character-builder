package org.predictabowl.bed.domain.equip;

import org.predictabowl.bed.domain.attributes.Attributi;
import org.predictabowl.bed.domain.constants.DataTipoEquip;

public class Scudo extends OggettoEquip {

	protected Scudo(long id) {
		super(id, DataTipoEquip.SCUDO);
	}
	
	protected Scudo(long id, Attributi attributi) {
		super(id, DataTipoEquip.SCUDO, attributi);
	}
}
