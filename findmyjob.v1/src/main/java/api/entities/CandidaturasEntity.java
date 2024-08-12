package api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "candidaturas")
@AllArgsConstructor
@NoArgsConstructor
public class CandidaturasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidatura")
    private long idCandidatura;

    @ManyToOne
    @JoinColumn(name = "candidato_id", nullable = false)
    private CandidatosEntity candidato;

    @ManyToOne
    @JoinColumn(name = "vaga_id", nullable = false)
    private VagasEntity vaga;

    @Column(name = "data_candidatura", nullable = false)
    private Date dataCandidatura;

    @Column(nullable = true)
    private String status;
}
