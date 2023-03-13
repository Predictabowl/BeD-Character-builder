package org.predictabowl.bed.port.out;

import java.util.Optional;

import org.predictabowl.bed.domain.PersonaggioGiocante;

public interface GetCharacterOutPort {

	public Optional<PersonaggioGiocante> get(long id);
}
