package ex1.part1.teste;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ex1.part1.Marca;


public class MarcaTest {

  @Test
  public void testMarca() {
    Marca marca1 = new Marca(0, "Chevrolet", "chev");
    Assertions.assertEquals(0, marca1.getIdMarca());
    marca1.setIdMarca(1);
    Assertions.assertEquals(1, marca1.getIdMarca());

    Assertions.assertEquals("Chevrolet", marca1.getNomeMarca());
    marca1.setNomeMarca("Volkswagen");
    Assertions.assertEquals("Volkswagen", marca1.getNomeMarca());
    Assertions.assertEquals("chev", marca1.getDadosMarca());
    marca1.setDadosMarca("volk");
    Assertions.assertEquals("volk", marca1.getDadosMarca());
  }

}
