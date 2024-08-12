package api.mappers;

import api.dto.CandidaturaDTO;
import api.entities.CandidaturaEntity;
import org.springframework.stereotype.Component;

@Component
public class CandidaturaMapper {

    public CandidaturaDTO toDto(CandidaturaEntity candidaturasEntity){
        return new CandidaturaDTO(
                candidaturasEntity.getIdCandidatura(),
                candidaturasEntity.getCandidato(),
                candidaturasEntity.getVaga(),
                candidaturasEntity.getDataCandidatura(),
                candidaturasEntity.getStatus()
        );
    }

    public CandidaturaEntity toEntity(CandidaturaDTO candidaturaDTO){
        return new CandidaturaEntity(
                candidaturaDTO.idCandidatura(),
                candidaturaDTO.candidato(),
                candidaturaDTO.vaga(),
                candidaturaDTO.dataCandidatura(),
                candidaturaDTO.status()
        );
    }
}
