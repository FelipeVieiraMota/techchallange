package api.controller;


import api.dto.EmpresaDTO;

import api.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;


@RestController
@RequestMapping("/v1/api/empresa")
@AllArgsConstructor
public class EmpresaController {

    private EmpresaService empresaService;

    @Operation(description = "Retorna a lista de todas as empresas cadastradas.")
    @GetMapping
    public ResponseEntity<Collection<EmpresaDTO>> findAll() {
        return ResponseEntity.ok(empresaService.finaAll());
    }

    @Operation(description = "Retorna a empresa cadastrada.")
    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(empresaService.findById(id));
    }

    @Operation(description = "Cadastra uma nova empresa.")
    @PostMapping
    public ResponseEntity<EmpresaDTO> save(@Valid @RequestBody EmpresaDTO empresaDTO) {
        return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.CREATED.value())).body(empresaService.save(empresaDTO));
    }

    @Operation(description = "Atualiza a empresa cadastrada.")
    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO> update(@PathVariable long id, @Valid @RequestBody EmpresaDTO empresaDTO) {
        return ResponseEntity.ok(empresaService.update(id, empresaDTO));
    }

    @Operation(description = "Apaga a empresa cadastrada.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
