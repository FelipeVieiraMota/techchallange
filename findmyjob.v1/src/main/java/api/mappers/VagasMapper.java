package api.mappers;

import api.dto.VagaDTO;
import api.entities.VagasEntity;
import org.springframework.stereotype.Component;

@Component
public class VagasMapper extends GenericMapper {

    public VagaDTO toDto(VagasEntity vagasEntity) {
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

    public VagasEntity toEntity(VagaDTO vagaDto) {
        return new VagasEntity(
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
