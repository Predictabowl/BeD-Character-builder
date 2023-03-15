package org.predictabowl.bed.persistence.entity;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AbilitaClasse {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NaturalId
	private String name;
	
	private String descrizione; //if saved in DB cannot be localized?
	private int basePF;
	private int multiplierPF;
	private String functionPF;
	private int basePA;
	private int multiplierPA;
	private String functionPA;
	private int baseMaxLevel;
	private int multiplierMaxLevel;
	private String functionMaxLevel;
	private int costoPAC;
	private String effectLambdaTag;

}
