package api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

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

    @NotBlank
    @NotNull
    @Column(name = "data_publicacao")
    private Date dataPublicacao;

    @NotBlank
    @NotNull
    @Column(name = "data_expiracao")
    private Date dataExpiracao;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private EmpresaEntity empresa;
}
