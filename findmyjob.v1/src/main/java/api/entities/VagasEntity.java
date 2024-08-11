package api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "vagas")
@AllArgsConstructor
@NoArgsConstructor
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
    @NotNull
    private BigDecimal salario;

    @NotNull
    @Column(name = "data_publicacao")
    private Date dataPublicacao;

    @NotNull
    @Column(name = "data_expiracao")
    private Date dataExpiracao;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private EmpresaEntity empresa;
}
