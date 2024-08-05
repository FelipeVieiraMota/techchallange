package api.controller;

import api.dto.VagaDto;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.service.VagasService;


import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/v1/api/vagas")
@RequiredArgsConstructor
public class VagasController {

    private final VagasService vagasService;

    @GetMapping
    public ResponseEntity<Page<VagaDto>> obterVagasPorPaginacao(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        return ResponseEntity.ok(vagasService.obterVagasPorPaginacao(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaDto> obterVagasPorId(@PathVariable long id){
        return ResponseEntity.ok(vagasService.obterVagasPorId(id));
    }

    @PostMapping
    public ResponseEntity<VagaDto> criarVaga(
        @NotNull @RequestBody VagaDto requestBody
    ) throws URISyntaxException {
        var response = vagasService.criarVaga(requestBody);
        var path = "/v1/api/vagas/" + response.id();
        return ResponseEntity.created(new URI("/v1/api/vagas")).body(response);
    }
}
