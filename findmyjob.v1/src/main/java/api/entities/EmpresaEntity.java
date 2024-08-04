package api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "empresa")
public class EmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private long idEmpresa;

    @NotBlank
    @Column(nullable = false)
    private String razaoSocial;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String cnpj;

    @NotBlank
    @Column(nullable = false)
    private String endereco;

    @NotBlank
    @Column(nullable = false)
    private String telefone;

    @NotBlank
    @Column(nullable = false)
    private String email;


    @OneToMany(mappedBy = "idVaga")
    private List<VagasEntity> vagas;
}
