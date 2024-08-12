package api.repository;

import api.entities.CandidaturasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidaturaRepository extends JpaRepository<CandidaturasEntity, Long> {
}
