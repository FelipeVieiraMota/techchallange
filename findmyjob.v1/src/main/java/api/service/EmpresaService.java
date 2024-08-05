package api.service;

import api.dto.EmpresaDTO;
import api.entities.EmpresaEntity;
import api.mappers.EmpresaMapper;

import api.repository.EmpresaRepository;
import api.exceptions.HttpNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Collection;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmpresaService {
    private EmpresaRepository empresaRepository;
    private EmpresaMapper mapper;

    public Collection<EmpresaDTO> finaAll() {
        return empresaRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public EmpresaDTO findById(long id) {
        return mapper.toDto(empresaRepository.findById(id).orElseThrow(() -> new HttpNotFoundException("User " + id + " not found.")));
    }

    public EmpresaDTO save(EmpresaDTO empresa) {
        return mapper.toDto(empresaRepository.save(mapper.toEntity(empresa)));
    }

    public EmpresaDTO update(long id, EmpresaDTO empresa) {
        EmpresaEntity empresaAtualizada;
        EmpresaDTO empresaDTO;
        try {
            empresaAtualizada = empresaRepository.getReferenceById(id);
            empresaAtualizada.setRazaoSocial(empresa.razaoSocial());
            empresaAtualizada.setCnpj(empresa.cnpj());
            empresaAtualizada.setEndereco(empresa.endereco());
            empresaAtualizada.setTelefone(empresa.telefone());
            empresaAtualizada.setEmail(empresa.email());
            empresaDTO = mapper.toDto(empresaAtualizada);
            save(empresaDTO);
        } catch (EntityNotFoundException e) {
            throw new HttpNotFoundException("Usuário " + id + " não encontrado.");
        }

        return empresaDTO;
    }

    public void delete(long id) {
        empresaRepository.deleteById(id);
    }

}
