package api.dto;

import api.entities.Empresa;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public record VagasDto (
    @NotNull String titulo,
    @NotNull String descricao,
    @NotNull BigDecimal salario,
    @NotNull Date dataPublicacao,
    @NotNull Date dataExpiracao,
    @NotNull Empresa empresa
){ }
