package org.predictabowl.bed.domain.characteristic.factory;

import org.predictabowl.bed.commons.utils.RefInteger;
import org.predictabowl.bed.domain.characteristic.CaratteristicaSecondaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;

public interface CaratteristicaSecondariaFactory {

	public CaratteristicaSecondaria get(DataCaratteristicaSecondaria type, RefInteger value);
}
