package api.mappers;

import api.entities.EmpresaEntity;
import api.entities.VagaEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

class GenericMapperTest {

    private final GenericMapper genericMapper = new GenericMapper();


    @Test
    void genericMapperTest(){

        var vagasEntity1 = new VagaEntity(
                1L,
                "Teste titulo",
                "Descricao teste",
                new BigDecimal("10000"),
                new Date(),
                new Date(),
                new EmpresaEntity()
        );

        var vagasEntity2 = new VagaEntity(
                1L,
                "UPDATE",
                "UPDATE",
                new BigDecimal("20000"),
                new Date(),
                new Date(),
                new EmpresaEntity()
        );

        vagasEntity1 = genericMapper.map(vagasEntity2, vagasEntity1, VagaEntity.class);

        Assertions.assertEquals(vagasEntity1.getIdVaga(), vagasEntity2.getIdVaga());
        Assertions.assertEquals(vagasEntity1.getSalario(), vagasEntity2.getSalario());
        Assertions.assertEquals(vagasEntity1.getEmpresa(), vagasEntity2.getEmpresa());
        Assertions.assertEquals(vagasEntity1.getTitulo(), vagasEntity2.getTitulo());
        Assertions.assertEquals(vagasEntity1.getDataPublicacao(), vagasEntity2.getDataPublicacao());
        Assertions.assertEquals(vagasEntity1.getDescricao(), vagasEntity2.getDescricao());

    }
}