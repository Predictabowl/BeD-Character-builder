package org.predictabowl.bed.domain.attributes.factory;

import java.util.Collection;

import org.predictabowl.bed.domain.attributes.AttributiCollection;
import org.predictabowl.bed.domain.attributes.AttributiInterface;

public interface AttributiCollectionFactory {

	public AttributiCollection get(Collection<AttributiInterface> collection);
}
