package org.predictabowl.bed.domain.attributes.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.predictabowl.bed.domain.attributes.AttributiCollection;
import org.predictabowl.bed.domain.attributes.AttributiInterface;

class AttributiCollectionFactoryImplTest {

	@Test
	void test() {
		AttributiCollectionFactoryImpl sut = new AttributiCollectionFactoryImpl();
		Collection<AttributiInterface> collection = new ArrayList<>();
		
		AttributiCollection result = sut.get(collection);
		
		assertThat(result.getCollection()).isSameAs(collection);
	}

}
