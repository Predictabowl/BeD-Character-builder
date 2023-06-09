package org.predictabowl.bed.persistence.adapter.out;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.predictabowl.bed.domain.PersonaggioGiocante;
import org.predictabowl.bed.persistence.entity.CharacterEntity;
import org.predictabowl.bed.persistence.repository.CharacterEntityRepository;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class GetCharacterOutAdapterTest {

	@Mock
	private CharacterEntityRepository charRepo;
	private AutoCloseable mocks;
	private GetCharacterOutAdapter sut;
	
	@BeforeEach
	void setUp() {
		mocks = openMocks(this);
		sut = new GetCharacterOutAdapter(charRepo);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		mocks.close();
	}
	
	@Test
	void test_getCharacter() {
		CharacterEntity pgEntity = new CharacterEntity(); 
		when(charRepo.getReferenceById(anyLong())).thenReturn(pgEntity);
		
		Optional<PersonaggioGiocante> result = sut.get(3);
		
		verify(charRepo).getReferenceById(3L);
		
	}

}
