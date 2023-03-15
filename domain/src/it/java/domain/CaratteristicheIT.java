package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.predictabowl.bed.domain.attributes.factory.AttributiCollectionFactoryImpl;
import org.predictabowl.bed.domain.attributes.factory.AttributiFunctionFactoryImpl;
import org.predictabowl.bed.domain.characteristic.CaratteristicaPrimaria;
import org.predictabowl.bed.domain.characteristic.CaratteristicaSecondaria;
import org.predictabowl.bed.domain.characteristic.Caratteristiche;
import org.predictabowl.bed.domain.characteristic.factory.CaratteristicaPrimariaFactoryImpl;
import org.predictabowl.bed.domain.characteristic.factory.CaratteristicaSecondariaFactoryImpl;
import org.predictabowl.bed.domain.characteristic.model.SubCarOffset;
import org.predictabowl.bed.domain.constants.DataCaratteristicaPrimaria;
import org.predictabowl.bed.domain.constants.DataCaratteristicaSecondaria;
import org.predictabowl.bed.domain.utils.CostantCaratFuncRetriever;

class CaratteristicheIT {

	private Caratteristiche sut;
	
	@BeforeEach
	void setUp() {
		CostantCaratFuncRetriever carFRetr = new CostantCaratFuncRetriever();
		AttributiFunctionFactoryImpl attrFuncFactory = new  AttributiFunctionFactoryImpl(carFRetr);
		AttributiCollectionFactoryImpl attrCollFactory = new AttributiCollectionFactoryImpl();
		CaratteristicaSecondariaFactoryImpl carFact = new CaratteristicaSecondariaFactoryImpl(attrFuncFactory);
		CaratteristicaPrimariaFactoryImpl carPFactory = new CaratteristicaPrimariaFactoryImpl(attrFuncFactory, carFact, attrCollFactory);
		sut = new Caratteristiche(carPFactory, attrCollFactory);
	}
	
	@Test
	void test_CaratteristichePrimarie() {
		CaratteristicaPrimaria forza = sut.getCaratteristica(DataCaratteristicaPrimaria.FORZA);
		forza.setValue(8);
		forza.setOffset(new SubCarOffset(1));
		
		
		CaratteristicaSecondaria muscoli = forza.getSubCar1();
		CaratteristicaSecondaria vigore= forza.getSubCar2();
		assertThat(forza.getValue()).isEqualTo(8);
		assertThat(muscoli.getValue()).isEqualTo(9);
		assertThat(muscoli.getType()).isEqualTo(DataCaratteristicaSecondaria.MUSCOLI);
		assertThat(vigore.getValue()).isEqualTo(7);
		assertThat(vigore.getType()).isEqualTo(DataCaratteristicaSecondaria.VIGORE);
	}
	
}
