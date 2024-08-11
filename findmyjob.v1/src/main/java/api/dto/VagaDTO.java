package api.dto;

import api.entities.EmpresaEntity;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Date;

public record VagaDTO(
    long id,
    @NotBlank(message = "O título tem que estar preenchido.") String titulo,
    @NotBlank(message = "A descrição tem que estar preenchida.") String descricao,
    @NotBlank(message = "O salário tem que estar preenchido.") BigDecimal salario,
    @NotBlank(message = "A Data de Publicação tem que estar preenchida.") Date dataPublicacao,
    @NotBlank(message = "A Data de Expiração tem que estar preenchida.") Date dataExpiracao,
    @NotBlank(message = "A empresa tem que estar preenchida.") EmpresaEntity empresa
){ }
