package org.predictabowl.bed.domain.attributes.factory;

import org.predictabowl.bed.commons.utils.RefInteger;
import org.predictabowl.bed.domain.attributes.AttributiFunction;
import org.predictabowl.bed.domain.utils.FunctionsProvider;

public interface AttributiFunctionFactory {

	public AttributiFunction get(RefInteger variable, FunctionsProvider provider);

}
