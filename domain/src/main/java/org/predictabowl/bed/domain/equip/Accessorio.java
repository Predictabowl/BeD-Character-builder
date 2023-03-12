package org.predictabowl.bed.domain.equip;

import org.predictabowl.bed.domain.attributes.Attributi;
import org.predictabowl.bed.domain.constants.SlotAccessoriPG;

public class Accessorio extends OggettoEquip{

	protected Accessorio(long id, SlotAccessoriPG type) {
		super(id, type.type);
	}

	public Accessorio(long id, SlotAccessoriPG type, Attributi attributi) {
		super(id, type.type, attributi);
	}

}
