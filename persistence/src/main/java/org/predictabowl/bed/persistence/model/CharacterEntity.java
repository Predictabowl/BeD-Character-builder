package org.predictabowl.bed.persistence.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CharacterEntity {

	@GeneratedValue
	@Id
	private Long id;
	
	@Column(nullable = false)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
