package ex1.part1.teste;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ex1.part1.Marca;
import ex1.part1.Modelo;


public class ModeloTest {

  @Test
  public void test() {
    Marca marca1 = new Marca(0, "Volkswagen", "volk");
    Modelo modelo1 = new Modelo(1, "santana", "meu pai tinha um", 4, marca1);

    Assertions.assertEquals(1, modelo1.getIdModelo());

    modelo1.setIdModelo(2);
    Assertions.assertEquals(2, modelo1.getIdModelo());

    Assertions.assertEquals("santana", modelo1.getNomeModelo());

    modelo1.setNomeModelo("fusca");
    Assertions.assertEquals("fusca", modelo1.getNomeModelo());

    Assertions.assertEquals("meu pai tinha um", modelo1.getDadosModelo());

    modelo1.setDadosModelo("soh que roubaram ele na praia da urca");
    Assertions.assertEquals("soh que roubaram ele na praia da urca", modelo1.getDadosModelo());

    Assertions.assertEquals(4, modelo1.getNumeroDePortas());

    modelo1.setNumeroDePortas(2);
    Assertions.assertEquals(2, modelo1.getNumeroDePortas());

    Assertions.assertEquals(modelo1, modelo1.getMarca());

  }

}
