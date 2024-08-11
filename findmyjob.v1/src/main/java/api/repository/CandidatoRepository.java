package api.repository;

import api.entities.CandidatosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<CandidatosEntity, Long> {}

