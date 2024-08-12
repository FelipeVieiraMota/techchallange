package api.dto;

import api.entities.CandidatoEntity;
import api.entities.VagaEntity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

public record CandidaturaDTO (
        long idCandidatura,
        @NotNull(message = "O candidato deve ser informado.") CandidatoEntity candidato,
        @NotNull(message = "A vaga deve ser informada.") VagaEntity vaga,
        @NotNull(message = "A data da candidatura tem que estar preenchida.") Date dataCandidatura,
        @NotBlank(message = "O status da candidatura tem que estar preenchido.") String status
) {}
