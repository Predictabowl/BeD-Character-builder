package org.predictabowl.bed.domain.characteristic;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public enum TipoCaratteristica {
	MUSCOLI(null, null, "Muscoli"),
	VIGORE(null, null, "Vigore"),
	EQUILIBRIO(null, null,"Equilibrio"),
	PRECISIONE(null, null,"Precisione"),
	SALUTE(null, null,"Salute"),
	RESISTENZA(null, null,"Resistenza"),
	RAGIONE(null, null,"Ragione"),
	CONOSCENZA(null, null,"Conoscenza"),
	INTUIZIONE(null, null,"Intuizione"),
	VOLONTA(null, null,"Volontà"),
	RISOLUTEZZA(null, null,"Risolutezza"),
	PRESENZA(null, null,"Presenza"),
	FORZA(MUSCOLI, VIGORE,"Forza"),
	DESTREZZA(EQUILIBRIO, PRECISIONE,"Destrezza"),
	COSTITUZIONE(RESISTENZA, SALUTE,"Costituzione"),
	INTELLIGENZA(CONOSCENZA, RAGIONE,"Intelligenza"),
	SAGGEZZA(INTUIZIONE, VOLONTA,"Saggezza"),
	CARISMA(PRESENZA, RISOLUTEZZA,"Carisma");
	
	public final Optional<TipoCaratteristica> sub1;
	public final Optional<TipoCaratteristica> sub2;
	public final String slug;
	public final boolean isPrimaria;
	
	private TipoCaratteristica(TipoCaratteristica sub1, TipoCaratteristica sub2, String slug) {
		this.sub1 = Optional.ofNullable(sub1);
		this.sub2 = Optional.ofNullable(sub2);
		this.slug = slug;
		this.isPrimaria = this.isCarPrimaria();
	}
	
	public Optional<TipoCaratteristica> getCarPrimaria() {
		if (isPrimaria){
			return Optional.empty();
		}
		return getCarPrimarie().stream()
				.filter(c -> c.sub1.get().equals(this) || c.sub2.get().equals(this)).findFirst();
	}
	
	public static List<TipoCaratteristica> getCarPrimarie(){
		return Stream.of(values())
				.filter(c -> c.isPrimaria).toList();
	}
	
	public CaratteristicaPrimaria getInstance() {
		return switch (this) {
			case FORZA: yield new Forza();
			case DESTREZZA: yield new Destrezza();
			case COSTITUZIONE: yield new Costituzione();
			case INTELLIGENZA: yield new Intelligenza();
			case SAGGEZZA: yield new Saggezza();
			case CARISMA: yield new Carisma();
			default:throw new IllegalArgumentException("Value not allowed: " + this);
		};
	}
	
	public static Optional<TipoCaratteristica> getFromSlug(String slug) {
		return Stream.of(values()).filter(t -> t.slug.equals(slug)).findFirst(); 
	}
	
	private boolean isCarPrimaria() {
		return !sub1.isEmpty() || !sub2.isEmpty();
	}
}
