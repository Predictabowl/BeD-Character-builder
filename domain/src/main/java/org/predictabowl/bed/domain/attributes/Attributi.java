package org.predictabowl.bed.domain.attributes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.predictabowl.bed.commons.interfaces.Summable;

public class Attributi implements Summable<Attributi>{

	private EnumMap<TipoAttributo, Attributo> map;
	
	public Attributi() {
		map = new EnumMap<>(TipoAttributo.class);
	}
	
	public List<Attributo> getAttributi(){
		return new ArrayList<>(map.values()); 
	}
	
	public Attributo getAttributo(TipoAttributo type) {
		if (map.containsKey(type)) {
			return map.get(type);
		}
		return new Attributo(type, 0);
	}
	
	public void addAttributo(Attributo attr) {
		map.put(attr.getType(), getAttributo(attr.getType()).addSummable(attr));
	}

	@Override
	public Attributi addSummable(Attributi element) {
		map.values().forEach(k -> 
			element.map.values().forEach(k::addSummable));
		element.map.forEach((k,v) -> map.putIfAbsent(k, v));
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(map);
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
		return Objects.equals(map, other.map);
	}

	@Override
	public String toString() {
		return "Attributi [map=" + map + "]";
	}
	
}
