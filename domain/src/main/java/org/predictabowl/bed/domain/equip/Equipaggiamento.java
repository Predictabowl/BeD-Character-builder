package org.predictabowl.bed.domain.equip;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.predictabowl.bed.commons.exceptions.BeDIllegalValueException;
import org.predictabowl.bed.domain.constants.SlotAccessoriPG;

public class Equipaggiamento {

	private Map<SlotAccessoriPG, Accessorio> accessori;
	private Arma arma1;
	private Arma arma2;
	private Armatura armatura;
	private Scudo scudo;

	public Equipaggiamento() {
		super();
		this.accessori = new EnumMap<>(SlotAccessoriPG.class);
	}
	
	public void setAccessorio(Accessorio acc, SlotAccessoriPG slot) {
		if(Objects.isNull(acc)) {
			accessori.remove(slot);
			return;
		}
		
		if(!slot.type.equals(acc.getType())) {
			throw new BeDIllegalValueException(
					"Cannot equip a "+acc.getType()+" in a slot "+slot);
		} 
		accessori.put(slot, acc);
	}
	
	public boolean unsetAccessorio(SlotAccessoriPG slot) {
		throw new UnsupportedOperationException("Not Implemented yet");
	}
	
	public Optional<Accessorio> getAccessorio(SlotAccessoriPG slot) {
		return Optional.ofNullable(accessori.get(slot));
	}

	public Optional<Arma> getArma1() {
		return Optional.ofNullable(arma1);
	}

	public void setArma1(Arma arma1) {
		this.arma1 = arma1;
	}

	public Optional<Arma> getArma2() {
		return Optional.ofNullable(arma2);
	}

	public void setArma2(Arma arma2) {
		this.arma2 = arma2;
	}

	public Optional<Armatura> getArmatura() {
		return Optional.ofNullable(armatura);
	}

	public void setArmatura(Armatura armatura) {
		this.armatura = armatura;
	}

	public Optional<Scudo> getScudo() {
		return Optional.ofNullable(scudo);
	}

	public void setScudo(Scudo scudo) {
		this.scudo = scudo;
	}
}
