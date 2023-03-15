package org.predictabowl.bed.domain.classe.abilita;

import org.predictabowl.bed.domain.attributes.AttributiInterface;
import org.predictabowl.bed.commons.utils.RefInteger;
import org.predictabowl.bed.domain.attributes.AttributiFunction;

public abstract class AbilitaClasse {

	private final RefInteger livello;
	private final String nome;
	private final String descrizione;
	private final TipoAbilitaClasse tipo;
	private final AttributiFunction attributi;
	private final CostiAbilitaLivello costiAbilita;
	

	protected AbilitaClasse(int livello, String nome, String descrizione, TipoAbilitaClasse tipo, AttributiFunction attributi,
			CostiAbilitaLivello costiAbilita) {
		super();
		this.attributi = attributi;
		this.livello = this.attributi.getVariable();
		this.livello.setValue(livello);
		this.nome = nome;
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.costiAbilita = costiAbilita;
	}

	public int getLivello() {
		return livello.getValue();
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public CostiAbilitaLivello getCostiAbilita() {
		return costiAbilita;
	}

	public void setLivello(int livello) {
		this.livello.setValue(livello);
	}

	public TipoAbilitaClasse getTipo() {
		return tipo;
	}

	public AttributiInterface getAttributi() {
		return attributi;
	}

	public String getNome() {
		return nome;
	}
	
	public int getCostoPA(int livello) {
		if (tipo.equals(TipoAbilitaClasse.PASSIVA)) {
			return 0;
		}
		return costiAbilita.getCostoPA(livello);
	}
	
	public int getCostoPF(int livello) {
		if (tipo.equals(TipoAbilitaClasse.PASSIVA)) {
			return 0;
		}
		return costiAbilita.getCostoPF(livello);
	}
	
	public int getTempo(int livello) {
		if (tipo.equals(TipoAbilitaClasse.PASSIVA)) {
			return 0;
		}
		return costiAbilita.getTempo(livello);
	}
	
}
