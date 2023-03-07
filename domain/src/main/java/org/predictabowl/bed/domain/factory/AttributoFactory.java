package org.predictabowl.bed.domain.factory;

import org.predictabowl.bed.domain.attributes.Attributo;
import org.predictabowl.bed.domain.attributes.TipoAttributo;

public interface AttributoFactory {
	public Attributo get(TipoAttributo type);
	public Attributo get(TipoAttributo type, int value);
}
