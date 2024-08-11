package api.mappers;

import api.dto.EmpresaDTO;
import api.entities.EmpresaEntity;
import org.springframework.stereotype.Component;


@Component
public class EmpresaMapper {

    public EmpresaDTO toDto(EmpresaEntity empresa) {
        return new EmpresaDTO(
                empresa.getIdEmpresa(),
                empresa.getRazaoSocial(),
                empresa.getCnpj(),
                empresa.getEndereco(),
                empresa.getTelefone(),
                empresa.getEmail()
        );
    }

    public EmpresaEntity toEntity(EmpresaDTO empresaDTO) {
        return new EmpresaEntity(
                empresaDTO.idEmpresa(),
                empresaDTO.razaoSocial(),
                empresaDTO.cnpj(),
                empresaDTO.endereco(),
                empresaDTO.telefone(),
                empresaDTO.email()
        );
    }
}
