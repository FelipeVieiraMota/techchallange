package api.mappers;

import api.dto.CandidaturaDTO;
import api.entities.CandidaturasEntity;
import org.springframework.stereotype.Component;

@Component
public class CandidaturasMapper {

    public CandidaturaDTO toDto(CandidaturasEntity candidaturasEntity){
        return new CandidaturaDTO(
                candidaturasEntity.getIdCandidatura(),
                candidaturasEntity.getCandidato(),
                candidaturasEntity.getVaga(),
                candidaturasEntity.getDataCandidatura(),
                candidaturasEntity.getStatus()
        );
    }

    public CandidaturasEntity toEntity(CandidaturaDTO candidaturaDTO){
        return new CandidaturasEntity(
                candidaturaDTO.idCandidatura(),
                candidaturaDTO.candidato(),
                candidaturaDTO.vaga(),
                candidaturaDTO.dataCandidatura(),
                candidaturaDTO.status()
        );
    }
}
