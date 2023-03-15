package org.predictabowl.bed.domain.attributes;

import java.util.Map;
import java.util.function.IntUnaryOperator;

import org.predictabowl.bed.commons.utils.RefInteger;
import org.predictabowl.bed.domain.constants.TipoAttributo;

public class AttributiFunction implements AttributiInterface{

	private final RefInteger variable;
	private final Map<TipoAttributo, IntUnaryOperator> functions;
	
	public AttributiFunction(RefInteger variabile, Map<TipoAttributo, IntUnaryOperator> functions) {
		this.variable = variabile;
		this.functions = functions;
	}
	
	public Map<TipoAttributo, IntUnaryOperator> getFunctions(){
		return functions;
	}

	@Override
	public int getValue(TipoAttributo type) {
		if (!functions.containsKey(type)) {
			return 0; 
		}
		return functions.get(type).applyAsInt(variable.getValue());
	}

	public RefInteger getVariable() {
		return variable;
	}
}
