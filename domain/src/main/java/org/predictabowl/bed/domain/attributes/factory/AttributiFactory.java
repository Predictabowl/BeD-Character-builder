package org.predictabowl.bed.domain.attributes.factory;

import org.predictabowl.bed.domain.attributes.AttributiInterface;

public interface AttributiFactory<V, T extends AttributiInterface>{

	public T get(V value);
}
