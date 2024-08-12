package api.mappers;

import api.dto.VagaDTO;
import api.entities.VagaEntity;
import org.springframework.stereotype.Component;

@Component
public class VagaMapper extends GenericMapper {

    public VagaDTO toDto(VagaEntity vagasEntity) {
        return new VagaDTO(
            vagasEntity.getIdVaga(),
            vagasEntity.getTitulo(),
            vagasEntity.getDescricao(),
            vagasEntity.getSalario(),
            vagasEntity.getDataPublicacao(),
            vagasEntity.getDataExpiracao(),
            vagasEntity.getEmpresa()
        );
    }

    public VagaEntity toEntity(VagaDTO vagaDto) {
        return new VagaEntity(
                vagaDto.id(),
                vagaDto.titulo(),
                vagaDto.descricao(),
                vagaDto.salario(),
                vagaDto.dataPublicacao(),
                vagaDto.dataExpiracao(),
                vagaDto.empresa()
        );
    }
}
