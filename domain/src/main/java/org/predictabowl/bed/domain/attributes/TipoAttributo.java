package org.predictabowl.bed.domain.attributes;

public enum TipoAttributo {
	CARICO("Carico"),
	CRIT("Crit"),
	MCG("MCG"),
	MCR("MCR"),
	MDI("MDI"),
	MDR("MDR"),
	PARARE("Parare"),
	PCRIT("Pcrit"),
	PF("PF"),
	SCHIVARE("Schivare"),
	VA("VA");
	
	public final String slug;
	
	private TipoAttributo (String slug) {
		this.slug = slug;
	}
}
