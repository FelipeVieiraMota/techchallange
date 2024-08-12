package api.entities;

import jakarta.persistence.*;
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
public class VagaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVaga;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal salario;

    @Column(name = "data_publicacao", nullable = false)
    private Date dataPublicacao;

    @Column(name = "data_expiracao", nullable = false)
    private Date dataExpiracao;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private EmpresaEntity empresa;
}
