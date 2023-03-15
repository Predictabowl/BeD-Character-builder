package org.predictabowl.bed.domain.attributes;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

import org.predictabowl.bed.domain.constants.TipoAttributo;

public class AttributiCollection implements AttributiInterface {

	private final Collection<AttributiInterface> collection;
	
	public AttributiCollection(Collection<AttributiInterface> collection) {
		this.collection = collection;
	}

	public Collection<AttributiInterface> getCollection() {
		return collection;
	}
	
	@Override
	public int getValue(TipoAttributo type) {
		return collection.stream().mapToInt(a -> a.getValue(type))
				.sum();
	}

	@Override
	public int hashCode() {
		return Objects.hash(collection);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttributiCollection other = (AttributiCollection) obj;
		return Objects.equals(collection, other.collection);
	}

	@Override
	public String toString() {
		return "AttributiCollection [collection=" + collection + "]";
	}
}
