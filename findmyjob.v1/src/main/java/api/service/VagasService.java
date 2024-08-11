package api.service;

import api.dto.VagaDTO;
import api.entities.VagasEntity;
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

    public Page<VagaDTO> getAllByPagination(int page, int size) {
        return vagasRepository
            .findAll(PageRequest.of(page, size))
                .map(mapper::toDto);
    }

    public VagaDTO save(VagaDTO requestBody) {
        return mapper.toDto(vagasRepository.save(mapper.toEntity(requestBody)));
    }

    public VagaDTO getById(long id) {
        return mapper.toDto(
            vagasRepository.findById(id)
                .orElseThrow(()-> new HttpNotFoundException("Vaga " + id + " not found."))
        );
    }

    public VagaDTO update(long id, VagaDTO requestBody) {

        var dataToUpdate = vagasRepository.findById(id)
                .orElseThrow(()-> new HttpNotFoundException("Vaga " + id + " not found."));

        dataToUpdate = mapper.map(mapper.toEntity(requestBody), dataToUpdate, VagasEntity.class);

        return save(mapper.toDto(dataToUpdate));
    }

    public void delete(long id) {
        vagasRepository.deleteById(id);
    }
}
