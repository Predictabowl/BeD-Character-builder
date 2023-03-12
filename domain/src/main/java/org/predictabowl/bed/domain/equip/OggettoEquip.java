package org.predictabowl.bed.domain.equip;

import org.predictabowl.bed.domain.attributes.Attributi;
import org.predictabowl.bed.domain.constants.DataTipoEquip;

public abstract class OggettoEquip{

	private long id;
	private final DataTipoEquip type;
	private Attributi attributi;

	protected OggettoEquip(long id, DataTipoEquip type, Attributi attributi) {
		super();
		this.type = type;
		this.setAttributi(attributi);
		this.id = id;
	}
	
	protected OggettoEquip(long id, DataTipoEquip type) {
		this(id, type, new Attributi());
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DataTipoEquip  getType() {
		return type;
	}
	
	public Attributi getAttributi(){
		return attributi;
	}

	public void setAttributi(Attributi attributi) {
		this.attributi = attributi;
	}
	
}
