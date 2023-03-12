package org.predictabowl.bed.domain.characteristic;

import java.util.Map;
import java.util.Objects;

import org.predictabowl.bed.domain.attributes.AttributoFunction;
import org.predictabowl.bed.domain.constants.CaratteristicaFunctions;
import org.predictabowl.bed.domain.constants.TipoAttributo;
import org.predictabowl.bed.domain.utils.CaratteristicaFunctionsRetriever;

public class Caratteristica<T extends CaratteristicaFunctions> {

	private T type;
	private int value;
	private CaratteristicaFunctionsRetriever carFRetriever;

	public Caratteristica(T type,
			CaratteristicaFunctionsRetriever carFRetriever,
			int value) {
		this.type = type;
		this.carFRetriever = carFRetriever;
		this.value = value;
	}

	public Caratteristica(T type, CaratteristicaFunctionsRetriever carFRetriever) {
		this(type, carFRetriever, 5);
	}
	
	public T getType() {
		return type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public int getAttributoValue(TipoAttributo type) {
		return getAttributoFunction(type).apply(value);
	}
	
	private AttributoFunction getAttributoFunction(TipoAttributo type) {
		Map<TipoAttributo,AttributoFunction> attrFs = carFRetriever.get(getType());
		if (attrFs.containsKey(type)) {
			return attrFs.get(type);
		}
		return (Integer v) -> 0; 
	}

	public void modValue(int mod) {
		value += mod;
	}

	@Override
	public String toString() {
		return "Caratteristica [type=" + type + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, value);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caratteristica<T> other = (Caratteristica<T>) obj;
		return Objects.equals(type, other.type) && value == other.value;
	}

	public CaratteristicaFunctionsRetriever getCarFRetriever() {
		return carFRetriever;
	}

}
