package org.predictabowl.bed.domain.constants.classepg;

public enum DataClassiPG {
	ASSASSINO("Assassino"),
	BARBARO("Barbaro"),
	BARDO("Bardo"),
	CAVALIERE_DELLA_MORTE("Cavaliere della Morte"),
	CHIERICO("Chierico"),
	DRUIDO("Druido"),
	GUERRIERO("Guerriero"),
	GUERRIERO_ARCANO("Guerriero Arcano"),
	INQUISITORE("Inquisitore"),
	MAGO("Mago"),
	NECROMANTE("Necromante"),
	PSIONICO("Psionico"),
	PALADINO("Paladino"),
	RANGER("Ranger"),
	SCIAMANO("Sciamano"),
	STREGONE("Stregone");
	
	public final String nome;
	
	private DataClassiPG(String nome) {
		this.nome = nome;
	}
}
