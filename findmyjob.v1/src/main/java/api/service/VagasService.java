package api.service;

import api.dto.VagaDto;
import api.mappers.VagasMapper;
import api.repository.VagasRepository;
import api.exceptions.HttpNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VagasService {

    private final VagasRepository vagasRepository;
    private final VagasMapper mapper;

    public Page<VagaDto> obterVagasPorPaginacao(int page, int size) {
        return vagasRepository
            .findAll(PageRequest.of(page, size))
                .map(mapper::toDto);
    }

    public VagaDto criarVaga(VagaDto requestBody) {
        return mapper.toDto(vagasRepository.save(mapper.toEntity(requestBody)));
    }

    public VagaDto obterVagasPorId(long id) {
        return mapper.toDto(
            vagasRepository.findById(id)
                .orElseThrow(()-> new HttpNotFoundException("User " + id + " not found."))
        );
    }
}
