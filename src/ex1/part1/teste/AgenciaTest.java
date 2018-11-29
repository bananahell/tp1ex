package ex1.part1.teste;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ex1.part1.Agencia;
import ex1.part1.Automovel;
import ex1.part1.Marca;
import ex1.part1.Modelo;


public class AgenciaTest {

  @Test
  public void testAgencia() {
    Agencia agen = new Agencia(6969, "L2 sul");
    Marca marc = new Marca(0, "Volkswagen", "volk");
    Modelo model = new Modelo(1, "Fox", "pequeno carro", 4, marc);
    Automovel auto = new Automovel("xxt-6666", "vermelho", 2000, "gasolina", 0, 999999999,
        "1B019283019283447", 3000, model);

    Assertions.assertEquals(6969, agen.getCodAgencia());

    agen.setCodAgencia(42);
    Assertions.assertEquals(42, agen.getCodAgencia());

    Assertions.assertEquals("L2 sul", agen.getLocal());

    agen.setLocal("perto de casa");
    Assertions.assertEquals("perto de casa", agen.getLocal());

    ArrayList<String> ArrayVazio = new ArrayList<String>();
    ArrayList<String> Array = new ArrayList<String>();
    Array.add(0, "xxt-6666");

    Assertions.assertEquals(ArrayVazio, agen.getAutomoveisPlacas());

    agen.setAutomoveis(Array);
    Assertions.assertEquals(Array, agen.getAutomoveisPlacas());

    agen.setAutomoveis(ArrayVazio);
    Assertions.assertEquals(
        "Código da agência: " + 42 + "\nLocal: perto de casa\nCarros presentes (por placa): vazio",
        agen.toString());

    agen.adicionaAutomovel("xxt-6666");
    Assertions.assertEquals(Array, agen.getAutomoveisPlacas());

    Assertions.assertEquals("Código da agência: " + 42 +
        "\nLocal: perto de casa\nCarros presentes (por placa):\n  xxt-6666", agen.toString());

    agen.tiraAutomovel("xxt-6666");
    Assertions.assertEquals(ArrayVazio, agen.getAutomoveisPlacas());

    agen.tiraAutomovel("xxt-6666");
    Assertions.assertEquals(ArrayVazio, agen.getAutomoveisPlacas());

    agen.tiraAutomovel("placa que nao existe");
    Assertions.assertEquals(ArrayVazio, agen.getAutomoveisPlacas());

  }

}
