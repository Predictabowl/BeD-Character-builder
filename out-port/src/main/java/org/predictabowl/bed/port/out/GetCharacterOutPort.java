package org.predictabowl.bed.port.out;

import java.util.Optional;

import org.predictabowl.bed.domain.Character;

public interface GetCharacterOutPort {

	public Optional<Character> get(long id);
}
