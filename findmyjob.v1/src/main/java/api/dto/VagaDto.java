package api.dto;

import api.entities.EmpresaEntity;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record VagaDto(
    long id,
    @NotNull String titulo,
    @NotNull String descricao,
    @NotNull BigDecimal salario,
    @NotNull Date dataPublicacao,
    @NotNull Date dataExpiracao,
    @NotNull EmpresaEntity empresa
){ }
