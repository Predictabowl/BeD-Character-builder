package org.predictabowl.bed.persistence.entity;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CharacterEntity {

	@GeneratedValue
	@Id
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<CaratteristicaEntity> caratteristiche;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<CaratteristicaEntity> getCaratteristiche() {
		return caratteristiche;
	}
	
	public void setCaratteristiche(Set<CaratteristicaEntity> caratteristiche) {
		this.caratteristiche = caratteristiche;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterEntity other = (CharacterEntity) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CharacterEntity [id=" + id + ", name=" + name + "]";
	}
	
}
