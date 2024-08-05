package api.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;


public record EmpresaDTO(long idEmpresa,
                         @NotBlank(message = "A Razão Social tem que estar preenchida.") String razaoSocial,
                         @NotBlank(message = "O CNPJ tem que estar preenchido.") @Size(min = 14, max = 14, message = "CNPJ deve ter 14 caracteres.") String cnpj,
                         @NotBlank(message = "O Endereço tem que estar preenchido.") String endereco,
                         @NotBlank(message = "O Telefone tem que estar preenchido.") String telefone,
                         @NotBlank(message = "O mail tem que estar preenchido.")
                         @Email(message = "E-mail está inválido") String email) {
}
