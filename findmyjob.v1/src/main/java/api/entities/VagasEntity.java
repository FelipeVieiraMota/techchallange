package api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class VagasEntity {

    public VagasEntity(
        String titulo,
        String descricao,
        BigDecimal salario,
        Date dataPublicacao,
        Date dataExpiracao,
        EmpresaEntity empresa
    ){
        this.titulo = titulo;
        this.descricao = descricao;
        this.salario = salario;
        this.dataPublicacao = dataPublicacao;
        this.dataExpiracao = dataExpiracao;
        this.empresa = empresa;
    }

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
