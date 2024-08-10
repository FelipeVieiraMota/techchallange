package api.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public record CandidatoDTO (

    long idCandidato,
    @NotNull String nome,
    @NotNull String cpf,
    @NotNull String email,
    @NotNull String telefone,
    @NotNull String endereco,
    @NotNull Date dataNascimento,
    @NotNull String experiencia
){}
