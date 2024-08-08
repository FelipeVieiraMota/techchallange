package api.mappers;

import api.dto.VagaDto;
import api.entities.VagasEntity;
import org.springframework.stereotype.Component;

@Component
public class VagasMapper {

    public VagaDto toDto(VagasEntity vagasEntity) {
        return new VagaDto(
            vagasEntity.getIdVaga(),
            vagasEntity.getTitulo(),
            vagasEntity.getDescricao(),
            vagasEntity.getSalario(),
            vagasEntity.getDataPublicacao(),
            vagasEntity.getDataExpiracao(),
            vagasEntity.getEmpresa()
        );
    }

    public VagasEntity toEntity(VagaDto vagaDto) {
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

    public VagasEntity map(VagasEntity sourceEntity, VagasEntity entityToReceiveDataFromSource){
        entityToReceiveDataFromSource.setIdVaga(sourceEntity.getIdVaga());
        entityToReceiveDataFromSource.setTitulo(sourceEntity.getTitulo());
        entityToReceiveDataFromSource.setDescricao(sourceEntity.getDescricao());
        entityToReceiveDataFromSource.setSalario(sourceEntity.getSalario());
        entityToReceiveDataFromSource.setDataPublicacao(sourceEntity.getDataPublicacao());
        entityToReceiveDataFromSource.setDataExpiracao(sourceEntity.getDataExpiracao());
        entityToReceiveDataFromSource.setEmpresa(sourceEntity.getEmpresa());
        return entityToReceiveDataFromSource;
    }
}
