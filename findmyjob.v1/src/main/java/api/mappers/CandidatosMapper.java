package api.mappers;

import api.dto.CandidatoDTO;
import api.entities.CandidatosEntity;
import org.springframework.stereotype.Component;

@Component
public class CandidatosMapper {

    public CandidatoDTO toDto(CandidatosEntity candidatosEntity){
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

    public CandidatosEntity toEntity(CandidatoDTO candidatoDTO){
        return new CandidatosEntity(
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
