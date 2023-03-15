package org.predictabowl.bed.domain.attributes.factory;

import java.util.Collection;

import org.predictabowl.bed.domain.attributes.AttributiCollection;
import org.predictabowl.bed.domain.attributes.AttributiInterface;

public class AttributiCollectionFactoryImpl implements AttributiCollectionFactory{

	@Override
	public AttributiCollection get(Collection<AttributiInterface> collection) {
		return new AttributiCollection(collection);
	}

}
