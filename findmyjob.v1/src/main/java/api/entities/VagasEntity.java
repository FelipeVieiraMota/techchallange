package api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
@Getter
@Setter
@Table(name = "vagas")
public class VagasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVaga;

    @NotBlank
    @NotNull
    @Column
    private String titulo;

    @NotBlank
    @NotNull
    @Column
    private String descricao;

    @Column(precision = 10, scale = 2)
    @NotBlank
    @NotNull
    private BigDecimal salario;
}
