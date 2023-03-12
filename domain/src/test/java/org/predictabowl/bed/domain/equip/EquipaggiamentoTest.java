package org.predictabowl.bed.domain.equip;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.predictabowl.bed.commons.exceptions.BeDIllegalValueException;
import org.predictabowl.bed.domain.constants.SlotAccessoriPG;

class EquipaggiamentoTest {

	private Equipaggiamento sut;
	
	@BeforeEach
	void setUp() {
		sut = new Equipaggiamento();
	}
	
	@Test
	void test_slots_empty() {
		Stream.of(SlotAccessoriPG.values()).forEach(a -> {
			assertThat(sut.getAccessorio(a)).isEmpty();
		});
		assertThat(sut.getArma1()).isEmpty();
		assertThat(sut.getArma2()).isEmpty();
		assertThat(sut.getArmatura()).isEmpty();
		assertThat(sut.getScudo()).isEmpty();
	}

	@Test
	void test_setAccessorio_onDifferentSlot_shouldThrow() {
		Accessorio a1 = new Accessorio(2, SlotAccessoriPG.SLOT_ANELLO1);
		assertThatThrownBy(() ->  sut.setAccessorio(a1, SlotAccessoriPG.SLOT_AMULETO))
				.isInstanceOf(BeDIllegalValueException.class);
	}
	
	@Test
	void test_setAccessorio_success() {
		Accessorio a1 = new Accessorio(3, SlotAccessoriPG.SLOT_ANELLO1);

		sut.setAccessorio(a1, SlotAccessoriPG.SLOT_ANELLO2);
		Optional<Accessorio> accessorio = sut.getAccessorio(SlotAccessoriPG.SLOT_ANELLO2);
		assertThat(accessorio).contains(a1);
		
		sut.setAccessorio(null, SlotAccessoriPG.SLOT_ANELLO2);
		accessorio = sut.getAccessorio(SlotAccessoriPG.SLOT_ANELLO2);
		assertThat(accessorio).isEmpty();
	}
}
