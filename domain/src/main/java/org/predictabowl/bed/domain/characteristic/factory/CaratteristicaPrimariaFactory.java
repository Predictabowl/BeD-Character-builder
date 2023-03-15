package org.predictabowl.bed.domain.characteristic.factory;

import org.predictabowl.bed.domain.characteristic.CaratteristicaPrimaria;
import org.predictabowl.bed.domain.characteristic.model.CarPValue;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;

public interface CaratteristicaPrimariaFactory {

	public CaratteristicaPrimaria get(DataCaratteristicaPrimaria carP, CarPValue value);
}
