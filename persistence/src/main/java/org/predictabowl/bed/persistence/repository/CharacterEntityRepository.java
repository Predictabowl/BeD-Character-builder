package org.predictabowl.bed.persistence.repository;

import org.predictabowl.bed.persistence.model.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterEntityRepository extends JpaRepository<CharacterEntity, Long>{

}
