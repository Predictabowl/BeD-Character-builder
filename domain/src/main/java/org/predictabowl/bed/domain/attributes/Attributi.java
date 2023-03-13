package org.predictabowl.bed.domain.attributes;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

import org.predictabowl.bed.commons.interfaces.Mergeable;
import org.predictabowl.bed.domain.constants.TipoAttributo;

public class Attributi implements Mergeable<Attributi> {

	private final Map<TipoAttributo, Integer> values;
	
	public Attributi() {
		this.values = new EnumMap<>(TipoAttributo.class);
	}
	
	// This constructor retains the entries with value 0
	public Attributi(Attributi attributi) {
		this.values = new EnumMap<>(attributi.values);
	}
	
	public Attributi(Map<TipoAttributo,Integer> values) {
		Map<TipoAttributo,Integer> collect = values.entrySet().stream()
		.filter(e -> e.getValue() != 0)
		.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
		this.values = new EnumMap<>(collect);
	}
	
	public int getValue(TipoAttributo attributo) {
		if (values.containsKey(attributo)) {
			return values.get(attributo);
		}
		return 0;
	}
		
	public void setValue(TipoAttributo attributo, int value) {
		if(value == 0) {
			values.remove(attributo);
		} else {
			values.put(attributo, value);
		}
	}
	
	public void modValue(TipoAttributo type, int mod){
		setValue(type, getValue(type)+mod);
	}
	
	public Map<TipoAttributo, Integer> getMap() {
		return values;
	}
	
	@Override
	public Attributi merge(Attributi element) {
		Attributi mergedA = new Attributi(values);
		element.values.forEach(mergedA::modValue);
		return mergedA;
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attributi other = (Attributi) obj;
		return Objects.equals(values, other.values);
	}

	@Override
	public String toString() {
		return "Attributi [values=" + values + "]";
	}
}
