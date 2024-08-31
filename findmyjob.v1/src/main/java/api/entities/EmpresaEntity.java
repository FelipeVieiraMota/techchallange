package api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "empresas")
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private long idEmpresa;

    @Column(nullable = false)
    private String razaoSocial;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

}
