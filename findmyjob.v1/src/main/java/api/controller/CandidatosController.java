package api.controller;

import api.dto.CandidatoDTO;
import api.service.CandidatosService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/candidatos")
@RequiredArgsConstructor
public class CandidatosController {

    private final CandidatosService candidatosService;

    @Operation(description = "Retorna o perfil do candidato cadastrado.")
    @GetMapping("/{id}")
    public ResponseEntity<CandidatoDTO> obterPerfilCandidato(@PathVariable long id) {
        return ResponseEntity.ok(candidatosService.obterPerfilCandidato(id));
    }

    @Operation(description = "Cadastra um novo candidato.")
    @PostMapping()
    public ResponseEntity<CandidatoDTO> salvarPerfilCandidato(@Valid @RequestBody CandidatoDTO candidato){
        return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.CREATED.value())).body(candidatosService.salvarPerfilCandidato(candidato));
    }

    @Operation(description = "Atualiza o informações de um candidato cadastrado.")
    @PutMapping("/{id}")
    public ResponseEntity<CandidatoDTO> atualizarPerfilCandidato(@PathVariable long id, @RequestBody CandidatoDTO candidato){
        return ResponseEntity.ok(candidatosService.atualizarPerfilCandidato(id, candidato));
    }

    @Operation(description = "Deleta o perfil de um candidato cadastrado.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPerfilCandidato(@PathVariable long id){
        candidatosService.deletarPerfilCandidato(id);
        return ResponseEntity.noContent().build();
    }
}
