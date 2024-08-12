package api.service;

import api.dto.CandidaturaDTO;
import api.entities.CandidaturaEntity;
import api.mappers.CandidaturaMapper;
import api.repository.CandidaturaRepository;
import api.exceptions.HttpNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidaturaService {

    private final CandidaturaRepository repository;
    private final CandidaturaMapper mapper;

    public CandidaturaDTO obterDetalhesCandidatura(long id) {
        CandidaturaEntity candidatura = repository.findById(id)
                .orElseThrow(() -> new HttpNotFoundException("Candidatura " + id + " não encontrada."));
        return mapper.toDto(candidatura);
    }

    public CandidaturaDTO salvarCandidatura(CandidaturaDTO candidaturaDTO) {
        CandidaturaEntity candidatura = mapper.toEntity(candidaturaDTO);
        CandidaturaEntity savedCandidatura = repository.save(candidatura);
        return mapper.toDto(savedCandidatura);
    }

    public CandidaturaDTO atualizarCandidatura(long id, CandidaturaDTO candidaturaDTO) {
        CandidaturaEntity candidaturaAtualizada = repository.findById(id)
                .orElseThrow(() -> new HttpNotFoundException("Candidatura " + id + " não encontrada."));

        candidaturaAtualizada.setCandidato(candidaturaDTO.candidato());
        candidaturaAtualizada.setVaga(candidaturaDTO.vaga());
        candidaturaAtualizada.setDataCandidatura(candidaturaDTO.dataCandidatura());
        candidaturaAtualizada.setStatus(candidaturaDTO.status());

        CandidaturaEntity updatedCandidatura = repository.save(candidaturaAtualizada);
        return mapper.toDto(updatedCandidatura);
    }

    public void deletarCandidatura(long id) {
        if (!repository.existsById(id)) {
            throw new HttpNotFoundException("Candidatura " + id + " não encontrada.");
        }
        repository.deleteById(id);
    }
}
