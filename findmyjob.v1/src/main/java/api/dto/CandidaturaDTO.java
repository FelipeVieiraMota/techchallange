package api.dto;

import api.entities.CandidatosEntity;
import api.entities.VagasEntity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

public record CandidaturaDTO (
        long idCandidatura,
        @NotNull(message = "O candidato deve ser informado.") CandidatosEntity candidato,
        @NotNull(message = "A vaga deve ser informada.") VagasEntity vaga,
        @NotNull(message = "A data da candidatura tem que estar preenchida.") Date dataCandidatura,
        @NotBlank(message = "O status da candidatura tem que estar preenchido.") String status
) {}
