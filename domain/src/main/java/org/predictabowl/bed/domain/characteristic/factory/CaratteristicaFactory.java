package org.predictabowl.bed.domain.characteristic.factory;

import org.predictabowl.bed.domain.characteristic.Caratteristica;
import org.predictabowl.bed.domain.constants.CaratteristicaFunctions;

public interface CaratteristicaFactory<T extends Caratteristica<E>, E extends CaratteristicaFunctions> {

	public T get(E type, int value);
}
