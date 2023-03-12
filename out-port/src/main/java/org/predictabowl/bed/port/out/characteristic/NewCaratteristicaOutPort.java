package org.predictabowl.bed.port.out.characteristic;

import org.predictabowl.bed.port.model.CaratteristicaData;
import org.predictabowl.bed.port.out.model.SavedCaratteristica;

public interface NewCaratteristicaOutPort {

	public SavedCaratteristica add(CaratteristicaData data);
}
