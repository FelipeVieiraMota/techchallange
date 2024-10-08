package api.repository;

import api.entities.CandidaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidaturaRepository extends JpaRepository<CandidaturaEntity, Long> {
}
