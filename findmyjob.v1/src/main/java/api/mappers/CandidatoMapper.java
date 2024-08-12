package api.mappers;

import api.dto.CandidatoDTO;
import api.entities.CandidatoEntity;
import org.springframework.stereotype.Component;

@Component
public class CandidatoMapper {

    public CandidatoDTO toDto(CandidatoEntity candidatosEntity){
        return new CandidatoDTO(
                candidatosEntity.getIdCandidato(),
                candidatosEntity.getNome(),
                candidatosEntity.getCpf(),
                candidatosEntity.getEmail(),
                candidatosEntity.getTelefone(),
                candidatosEntity.getEndereco(),
                candidatosEntity.getDataNascimento(),
                candidatosEntity.getExperiencia()
        );
    }

    public CandidatoEntity toEntity(CandidatoDTO candidatoDTO){
        return new CandidatoEntity(
                candidatoDTO.idCandidato(),
                candidatoDTO.nome(),
                candidatoDTO.cpf(),
                candidatoDTO.email(),
                candidatoDTO.telefone(),
                candidatoDTO.endereco(),
                candidatoDTO.dataNascimento(),
                candidatoDTO.experiencia()
        );
    }
}
