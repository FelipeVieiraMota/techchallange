package api.controller;

import api.dto.VagaDTO;
import jakarta.validation.Valid;
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
    public ResponseEntity<Page<VagaDTO>> getAllByPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        return ResponseEntity.ok(vagasService.getAllByPagination(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaDTO> getById(@PathVariable long id){
        return ResponseEntity.ok(vagasService.getById(id));
    }

    @PostMapping
    public ResponseEntity<VagaDTO> create(@Valid @RequestBody VagaDTO requestBody) throws URISyntaxException {
        var response = vagasService.save(requestBody);
        var path = "/v1/api/vagas/" + response.id();
        return ResponseEntity.created(new URI(path)).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VagaDTO> update(@PathVariable long id, @Valid @RequestBody VagaDTO requestBody) {
        return ResponseEntity.ok(vagasService.update(id, requestBody));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        vagasService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
