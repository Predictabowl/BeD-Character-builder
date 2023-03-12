package org.predictabowl.bed.persistence.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CaratteristicaEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String slug;
	private int value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, slug, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaratteristicaEntity other = (CaratteristicaEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(slug, other.slug) && value == other.value;
	}

	@Override
	public String toString() {
		return "CaratteristicaEntity [id=" + id + ", slug=" + slug + ", value=" + value + "]";
	}
	
}
