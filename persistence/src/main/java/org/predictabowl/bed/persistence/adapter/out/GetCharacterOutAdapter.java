package org.predictabowl.bed.persistence.adapter.out;

import java.util.Optional;

import org.predictabowl.bed.domain.PersonaggioGiocante;
import org.predictabowl.bed.persistence.repository.CharacterEntityRepository;
import org.predictabowl.bed.port.out.GetCharacterOutPort;
import org.springframework.stereotype.Component;

@Component
public class GetCharacterOutAdapter implements GetCharacterOutPort{

	private CharacterEntityRepository charRepo;
	
	public GetCharacterOutAdapter(CharacterEntityRepository charRepo) {
		super();
		this.charRepo = charRepo;
	}

	@Override
	public Optional<PersonaggioGiocante> get(long id) {
		charRepo.getReferenceById(id);
		return Optional.empty();
	}

}
