package api.controller;

import api.dto.EmpresaDTO;
import api.dto.VagaDto;
import jakarta.validation.Valid;
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
    public ResponseEntity<Page<VagaDto>> getAllByPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        return ResponseEntity.ok(vagasService.getAllByPagination(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaDto> getById(@PathVariable long id){
        return ResponseEntity.ok(vagasService.getById(id));
    }

    @PostMapping
    public ResponseEntity<VagaDto> create(@Valid @RequestBody VagaDto requestBody) throws URISyntaxException {
        var response = vagasService.save(requestBody);
        var path = "/v1/api/vagas/" + response.id();
        return ResponseEntity.created(new URI(path)).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VagaDto> update(@PathVariable long id, @Valid @RequestBody VagaDto requestBody) {
        return ResponseEntity.ok(vagasService.update(id, requestBody));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        vagasService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
