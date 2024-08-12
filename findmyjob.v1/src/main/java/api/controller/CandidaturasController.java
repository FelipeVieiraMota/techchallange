package api.controller;

import api.dto.CandidaturaDTO;
import api.service.CandidaturaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/candidatura")
@RequiredArgsConstructor
public class CandidaturasController {

    private final CandidaturaService candidaturaService;

    @Operation(description = "Retorna os detalhes de uma candidatura.")
    @GetMapping("/{id}")
    public ResponseEntity<CandidaturaDTO> obterDetalhesCandidatura(@PathVariable long id) {
        return ResponseEntity.ok(candidaturaService.obterDetalhesCandidatura(id));
    }

    @Operation(description = "Registra uma nova candidatura.")
    @PostMapping()
    public ResponseEntity<CandidaturaDTO> salvarCandidatura(@Valid @RequestBody CandidaturaDTO candidaturaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidaturaService.salvarCandidatura(candidaturaDTO));
    }

    @Operation(description = "Atualiza as informações de uma candidatura.")
    @PutMapping("/{id}")
    public ResponseEntity<CandidaturaDTO> atualizarCandidatura(@PathVariable long id, @Valid @RequestBody CandidaturaDTO candidaturaDTO) {
        return ResponseEntity.ok(candidaturaService.atualizarCandidatura(id, candidaturaDTO));
    }

    @Operation(description = "Deleta uma candidatura.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCandidatura(@PathVariable long id) {
        candidaturaService.deletarCandidatura(id);
        return ResponseEntity.noContent().build();
    }
}
