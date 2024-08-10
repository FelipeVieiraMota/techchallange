package api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "candidatos")
public class CandidatosEntity {

    public CandidatosEntity(
            long idCandidato,
            String nome,
            String cpf,
            String email,
            String telefone,
            String endereco,
            Date dataNascimento,
            String experiencia){

        this.idCandidato = idCandidato;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.experiencia = experiencia;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidato")
    private long idCandidato;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String cpf;

    @NotBlank
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String telefone;

    @NotBlank
    @Column(nullable = false)
    private String endereco;

    @NotBlank
    @NotNull
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @NotBlank
    @Column(nullable = false)
    private String experiencia;

}
