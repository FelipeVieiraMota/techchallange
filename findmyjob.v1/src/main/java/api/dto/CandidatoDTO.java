package api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

public record CandidatoDTO (

    long idCandidato,
    @NotBlank(message = "O nome tem que estar preenchido.") String nome,
    @NotBlank(message = "O CPF tem que estar preenchido.") @Size(min = 11, max = 11, message = "CPF deve ter 14 caracteres.")String cpf,
    @NotBlank(message = "O email tem que estar preenchido.") @Email(message = "E-mail está inválido") String email,
    @NotBlank(message = "O telefone tem que estar preenchido.") String telefone,
    @NotBlank(message = "O endereço tem que estar preenchido.") String endereco,
    @NotNull Date dataNascimento,
    @NotBlank(message = "A experiência tem que estar preenchida.")  String experiencia
){}
