package api.service;

import api.dto.CandidatoDTO;
import api.entities.CandidatoEntity;
import api.exceptions.HttpNotFoundException;
import api.mappers.CandidatoMapper;
import api.repository.CandidatoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidatoService {

    private final CandidatoRepository repository;
    private final CandidatoMapper mapper;


    public CandidatoDTO obterPerfilCandidato(long id) {
        return mapper.toDto(
                repository.findById(id)
                        .orElseThrow(() -> new HttpNotFoundException("Usuário " + id + " não encontrado."))
        );

    }

    public CandidatoDTO salvarPerfilCandidato(CandidatoDTO candidato) {
        return mapper.toDto(repository.save(mapper.toEntity(candidato)));
    }

    public CandidatoDTO atualizarPerfilCandidato(long id, CandidatoDTO candidato) {
        CandidatoDTO candidatoDTO;
        CandidatoEntity candidatoAtualizado;

        try{
            candidatoAtualizado = repository.getReferenceById(id);
            candidatoAtualizado.setNome(candidato.nome());
            candidatoAtualizado.setCpf(candidato.cpf());
            candidatoAtualizado.setEmail(candidato.email());
            candidatoAtualizado.setEndereco(candidato.endereco());
            candidatoAtualizado.setTelefone(candidato.telefone());
            candidatoAtualizado.setDataNascimento(candidato.dataNascimento());

            candidatoDTO = mapper.toDto(candidatoAtualizado);
            salvarPerfilCandidato(candidatoDTO);

        }catch (EntityNotFoundException exception){
            throw new HttpNotFoundException("Usuário" + id + " não encontrado.");
        }
        return candidatoDTO;
    }

    public void deletarPerfilCandidato(long id) {

        repository.deleteById(id);
    }
}
