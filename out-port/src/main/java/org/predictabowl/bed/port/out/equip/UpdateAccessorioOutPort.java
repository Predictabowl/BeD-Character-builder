package org.predictabowl.bed.port.out.equip;

import org.predictabowl.bed.domain.equip.Accessorio;

public interface UpdateAccessorioOutPort {
	
	public Accessorio update(int accessorioId, Accessorio accessorio);
}
