package api.repository;

import api.entities.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {
}
