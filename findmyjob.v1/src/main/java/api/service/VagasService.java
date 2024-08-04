package api.service;

import api.repository.VagasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VagasService {
    private final VagasRepository vagasRepository;
}
