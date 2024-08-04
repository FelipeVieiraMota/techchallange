package api.mappers;

import api.dto.VagasDto;
import api.entities.VagasEntity;
import org.springframework.stereotype.Component;

@Component
public class VagasMapper {

    public VagasDto toDto(VagasEntity vagasEntity) {
        return new VagasDto(
            vagasEntity.getTitulo(),
            vagasEntity.getDescricao(),
            vagasEntity.getSalario(),
            vagasEntity.getDataPublicacao(),
            vagasEntity.getDataExpiracao(),
            vagasEntity.getEmpresa()
        );
    }

    public VagasEntity toEntity(VagasDto vagasDto) {
        return new VagasEntity(
                vagasDto.titulo(),
                vagasDto.descricao(),
                vagasDto.salario(),
                vagasDto.dataPublicacao(),
                vagasDto.dataExpiracao(),
                vagasDto.empresa()
        );
    }
}
