package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.entities.VagasEntity;

@Repository
public interface VagasRepository extends JpaRepository<VagasEntity, Long> {}
