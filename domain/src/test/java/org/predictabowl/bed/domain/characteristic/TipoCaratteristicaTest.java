package org.predictabowl.bed.domain.characteristic;

import static org.assertj.core.api.Assertions.*;
import static org.predictabowl.bed.domain.characteristic.TipoCaratteristica.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class TipoCaratteristicaTest {

	@Test
	void test_getCarPrimaria_whenPresent() {
		assertThat(TipoCaratteristica.INTUIZIONE.isPrimaria).isFalse();
		
		Optional<TipoCaratteristica> result =
				TipoCaratteristica.INTUIZIONE.getCarPrimaria();
		
		assertThat(result).contains(TipoCaratteristica.SAGGEZZA);
	}
	
	@Test
	void test_getCarPrimaria_whenNotPresent() {
		assertThat(TipoCaratteristica.INTELLIGENZA.isPrimaria).isTrue();
		
		Optional<TipoCaratteristica> result =  
				TipoCaratteristica.INTELLIGENZA.getCarPrimaria();
		
		assertThat(result).isEmpty();
	}
	
	@Test
	void test_getInstances() {
		assertThat(FORZA.getInstance()).isInstanceOf(Forza.class);
		assertThat(DESTREZZA.getInstance()).isInstanceOf(Destrezza.class);
		assertThat(COSTITUZIONE.getInstance()).isInstanceOf(Costituzione.class);
		assertThat(INTELLIGENZA.getInstance()).isInstanceOf(Intelligenza.class);
		assertThat(SAGGEZZA.getInstance()).isInstanceOf(Saggezza.class);
		assertThat(CARISMA.getInstance()).isInstanceOf(Carisma.class);
	}
	
	@Test
	void test_getFromSlug() {
		assertThat(TipoCaratteristica.getFromSlug("Something")).isEmpty();
		
		assertThat(TipoCaratteristica.getFromSlug(VIGORE.slug)).contains(VIGORE);
	}
}
