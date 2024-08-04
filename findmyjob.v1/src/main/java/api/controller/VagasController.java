package api.controller;

import api.dto.VagasDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import api.service.VagasService;

@RestController
@RequestMapping("/v1/api/vagas")
@RequiredArgsConstructor
public class VagasController {

    private final VagasService vagasService;

    @GetMapping
    public Page<VagasDto> obterVagasPorPaginacao(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        return vagasService.obterVagasPorPaginacao(page, size);
    }
}
