package org.predictabowl.bed.domain.constants.classepg;

import java.util.function.IntUnaryOperator;

import org.predictabowl.bed.domain.classe.abilita.TipoAbilitaClasse;

/**
 * Esempio di enum con abilità di classe.
 * Penso abbia più senso metterlo nel database, ma come posso inserirci
 * le funzioni lambda? L'idea sarebbe un enum contenente le funzioni, e nel
 * database memorizzo lo slug di riferimento
 * 
 * La descrizione ed il nome andrebbero messi nella localization
 * @author piero
 *
 */

public enum DatiAbilitaClassePG {
	ADD_ARMATURE_AV("Addestramento Armature Avanzato", TipoAbilitaClasse.PASSIVA,
			"Il personaggio ottiene un bonus al proprio valore di Addestramento Armature pari a +1 per livello dell'abilità."),
	ARMA_LETALE("Arma Letale", TipoAbilitaClasse.PECULIARE,
			"Quando attivata il personaggio ottiene +4 MDI per livello dell’abilità."),
	COLPIRE_SPALLE("Colpire alle Spalle", TipoAbilitaClasse.PECULIARE,
			"Mentre l'abilità è attiva gli Attacchi alle Spalle ottengono un bonus di +1 LA per livello dell’abilità."),	
	DISIMPEGNO("Disimpegno", TipoAbilitaClasse.PECULIARE,
			"Quando attivata il personaggio ottiene +4 MDI per livello dell’abilità.");

	public final String nome;
	public final String descrizione;
	public final TipoAbilitaClasse tipo;

	private DatiAbilitaClassePG(String nome, TipoAbilitaClasse tipo, String descrizione) {
		this.nome = nome;
		this.tipo = tipo;
		this.descrizione = descrizione;
	}

	public IntUnaryOperator getCostoPF() {
		if (this.tipo.equals(TipoAbilitaClasse.PASSIVA)) {
			return l -> 0;
		}

		switch (this) {
		case ARMA_LETALE, COLPIRE_SPALLE:
			return l -> 1;
		case DISIMPEGNO:
			return l -> 8 - 2 * l;
		default:
			throw new IllegalArgumentException("Unexpected value: " + this);
		}
	}
}
