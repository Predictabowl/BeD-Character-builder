package org.predictabowl.bed.domain.attributes.factory;

import org.predictabowl.bed.commons.utils.RefInteger;
import org.predictabowl.bed.domain.attributes.AttributiFunction;
import org.predictabowl.bed.domain.utils.AttributiFunctionsRetriever;
import org.predictabowl.bed.domain.utils.FunctionsProvider;
import org.springframework.stereotype.Component;

@Component
public class AttributiFunctionFactoryImpl implements AttributiFunctionFactory{
	
	private AttributiFunctionsRetriever retriever;
	
	public AttributiFunctionFactoryImpl(AttributiFunctionsRetriever retriever) {
		this.retriever = retriever;
	}
	
	@Override
	public AttributiFunction get(RefInteger variable, FunctionsProvider provider) {
		return new AttributiFunction(variable, retriever.get(provider));
	}

}
