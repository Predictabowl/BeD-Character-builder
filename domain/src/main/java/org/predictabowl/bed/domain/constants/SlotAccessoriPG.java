package org.predictabowl.bed.domain.constants;

import static org.predictabowl.bed.domain.constants.DataTipoEquip.*;

public enum SlotAccessoriPG {
	SLOT_ANELLO1(ANELLO),
	SLOT_ANELLO2(ANELLO),
	SLOT_AMULETO(AMULETO),
	SLOT_BRACCIALI(BRACCIALI),
	SLOT_CINTURA(CINTURA),
	SLOT_ELMO(ELMO),
	SLOT_GUANTI(GUANTI),
	SLOT_MANTELLO(MANTELLO),
	SLOT_STIVALI(STIVALI);
	
	public final DataTipoEquip type;

	private SlotAccessoriPG(DataTipoEquip type) {
		this.type = type;
	}
}
