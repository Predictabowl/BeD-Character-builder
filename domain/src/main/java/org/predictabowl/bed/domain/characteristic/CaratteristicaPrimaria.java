package org.predictabowl.bed.domain.characteristic;

import java.util.Objects;

import org.predictabowl.bed.commons.exceptions.BeDIllegalValueException;
import org.predictabowl.bed.domain.characteristic.factory.CaratteristicaFactory;
import org.predictabowl.bed.domain.characteristic.model.SubCarOffset;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.predictabowl.bed.domain.constants.TipoAttributo;
import org.predictabowl.bed.domain.utils.CaratteristicaFunctionsRetriever;

public class CaratteristicaPrimaria extends Caratteristica<DataCaratteristicaPrimaria> {

	public static final int MAX_VALUE = 10;
	public static final int MIN_VALUE = 1;
	
	private long id;
	private int offset;
	private CaratteristicaFactory<CaratteristicaSecondaria, DataCaratteristicaSecondaria> carFactory;

	public CaratteristicaPrimaria(DataCaratteristicaPrimaria type,
			int value,
			CaratteristicaFactory<CaratteristicaSecondaria, DataCaratteristicaSecondaria> carFactory,
			CaratteristicaFunctionsRetriever carFRetriever) {
		super(type, carFRetriever, value);
		selfValidate(value);
		this.carFactory = carFactory;
		this.offset = 0;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setOffset(SubCarOffset  offset) {
		this.offset = offset.getOffset();
	}

	@Override
	public void setValue(int value) {
		selfValidate(value);
		super.setValue(value);
	}

	public CaratteristicaSecondaria getSubCar1() {
		return carFactory.get(getType().sub1, getValue()+offset);
	}
	
	public CaratteristicaSecondaria getSubCar2() {
		return carFactory.get(getType().sub2, getValue()-offset);
	}
	
	public CaratteristicaFactory<CaratteristicaSecondaria, 
				DataCaratteristicaSecondaria> getCaratteristicaFactory() {
		return carFactory;
	}
	
	@Override
	public int getAttributoValue(TipoAttributo type) {
		return super.getAttributoValue(type) +
				getSubCar1().getAttributoValue(type) +
				getSubCar2().getAttributoValue(type);
	}

	@Override
	public void modValue(int mod) {
		int oldValue = getValue();
		if (oldValue + mod > MAX_VALUE) {
			setValue(MAX_VALUE);
			return;
		}
		if (oldValue + mod < MIN_VALUE) {
			setValue(MIN_VALUE);
			return;
		}
		super.modValue(mod);
	}

	private void selfValidate(int value) {
		if (value < MIN_VALUE || value > MAX_VALUE) {
			throw new BeDIllegalValueException(
					"Caratteristica Primaria value must be between 1 and 10");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(offset);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaratteristicaPrimaria other = (CaratteristicaPrimaria) obj;
		return offset == other.offset;
	}

	@Override
	public String toString() {
		return "CaratteristicaPrimaria [offset=" + offset + ", toString()=" + super.toString() + "]";
	}

}
