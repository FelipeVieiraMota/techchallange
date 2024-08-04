package api.service;

import api.dto.VagasDto;
import api.mappers.VagasMapper;
import api.repository.VagasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VagasService {

    private final VagasRepository vagasRepository;
    private final VagasMapper mapper;

    public Page<VagasDto> obterVagasPorPaginacao(int page, int size) {
        return vagasRepository
            .findAll(PageRequest.of(page, size))
                .map(mapper::toDto);
    }
}
