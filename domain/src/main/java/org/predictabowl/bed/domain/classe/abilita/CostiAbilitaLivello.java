package org.predictabowl.bed.domain.classe.abilita;

import java.util.function.IntUnaryOperator;


public class CostiAbilitaLivello implements CostiAbilita{
	
	private final IntUnaryOperator calcPA;
	private final IntUnaryOperator calcPF;
	private final IntUnaryOperator calcTempo;
	
	public CostiAbilitaLivello(IntUnaryOperator calcPA, IntUnaryOperator calcPF, IntUnaryOperator calcTempo) {
		super();
		this.calcPA = calcPA;
		this.calcPF = calcPF;
		this.calcTempo = calcTempo;
	}

	@Override
	public int getCostoPA(int livello) {
		return calcPA.applyAsInt(livello);
	}
	
	@Override
	public int getCostoPF(int livello) {
		return calcPF.applyAsInt(livello);
	}
	
	@Override
	public int getTempo(int livello) {
		return calcTempo.applyAsInt(livello);
	}

	public IntUnaryOperator getCalcPA() {
		return calcPA;
	}

	public IntUnaryOperator getCalcPF() {
		return calcPF;
	}

	public IntUnaryOperator getCalcTempo() {
		return calcTempo;
	}

}
