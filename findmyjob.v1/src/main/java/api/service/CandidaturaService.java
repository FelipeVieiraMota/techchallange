package api.service;

import api.dto.CandidaturaDTO;
import api.entities.CandidaturasEntity;
import api.mappers.CandidaturasMapper;
import api.repository.CandidaturaRepository;
import api.exceptions.HttpNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidaturaService {

    private final CandidaturaRepository repository;
    private final CandidaturasMapper mapper;

    public CandidaturaDTO obterDetalhesCandidatura(long id) {
        CandidaturasEntity candidatura = repository.findById(id)
                .orElseThrow(() -> new HttpNotFoundException("Candidatura " + id + " não encontrada."));
        return mapper.toDto(candidatura);
    }

    public CandidaturaDTO salvarCandidatura(CandidaturaDTO candidaturaDTO) {
        CandidaturasEntity candidatura = mapper.toEntity(candidaturaDTO);
        CandidaturasEntity savedCandidatura = repository.save(candidatura);
        return mapper.toDto(savedCandidatura);
    }

    public CandidaturaDTO atualizarCandidatura(long id, CandidaturaDTO candidaturaDTO) {
        CandidaturasEntity candidaturaAtualizada = repository.findById(id)
                .orElseThrow(() -> new HttpNotFoundException("Candidatura " + id + " não encontrada."));

        candidaturaAtualizada.setCandidato(candidaturaDTO.candidato());
        candidaturaAtualizada.setVaga(candidaturaDTO.vaga());
        candidaturaAtualizada.setDataCandidatura(candidaturaDTO.dataCandidatura());
        candidaturaAtualizada.setStatus(candidaturaDTO.status());

        CandidaturasEntity updatedCandidatura = repository.save(candidaturaAtualizada);
        return mapper.toDto(updatedCandidatura);
    }

    public void deletarCandidatura(long id) {
        if (!repository.existsById(id)) {
            throw new HttpNotFoundException("Candidatura " + id + " não encontrada.");
        }
        repository.deleteById(id);
    }
}
