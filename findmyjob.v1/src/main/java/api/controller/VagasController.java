package api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api.service.VagasService;

@RestController
@RequestMapping("/v1/api/vagas")
@RequiredArgsConstructor
public class VagasController {
    private final VagasService vagasService;

    // Get all products
    @GetMapping
    public ResponseEntity<String> getAllProducts() {
        return ResponseEntity.ok("Hello World!");
    }
}
