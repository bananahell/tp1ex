package ex1.part1.teste;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ex1.part1.Automovel;
import ex1.part1.Marca;
import ex1.part1.Modelo;


public class AutomovelTest {

  @Test
  public void test() {
    Marca marc = new Marca(0, "Volkswagen", "volk");
    Modelo model = new Modelo(1, "Fox", "pequeno carro", 4, marc);
    Automovel auto = new Automovel("xxt-6666", "vermelho", 2000, "gasolina", 0, 999999999,
        "1B019283019283447", 3000, model);

    Assertions.assertEquals(auto.toString(),
        "Placa: xxt-6666\nCor: vermelho\nAno: " + 2000 +
            "\nTipo de combustível: gasolina\nQuilometragem: " + 0.0 + "\nRenavam: " + 999999999 +
            "\nChassi: 1B019283019283447\nValor de locação: " + 3000.0 +
            "\nMarca: Volkswagen\nModelo: Fox\nNúmero de portas: " + 4 + "");

    Assertions.assertEquals("xxt-6666", auto.getNumeroDaPlaca());

    auto.setNumeroDaPlaca("x");
    Assertions.assertEquals("x", auto.getNumeroDaPlaca());

    Assertions.assertEquals("vermelho", auto.getCor());

    auto.setCor("verde");
    Assertions.assertEquals("verde", auto.getCor());

    Assertions.assertEquals(2000, auto.getAno());

    auto.setAno(1999);
    Assertions.assertEquals(1999, auto.getAno());

    Assertions.assertEquals("gasolina", auto.getTipoDeCombustivel());

    auto.setTipoDeCombustivel("alcool");
    Assertions.assertEquals("alcool", auto.getTipoDeCombustivel());

    Assertions.assertEquals(0, auto.getQuilometragem());

    auto.setQuilometragem(1000);
    Assertions.assertEquals(1000, auto.getQuilometragem());

    Assertions.assertEquals(999999999, auto.getRenavam());

    auto.setRenavam(1);
    Assertions.assertEquals(1, auto.getRenavam());

    Assertions.assertEquals("1B019283019283447", auto.getChassi());

    auto.setChassi("24");
    Assertions.assertEquals("24", auto.getChassi());

    Assertions.assertEquals(3000, auto.getValorDeLocacao());

    auto.setValorDeLocacao(1200);
    Assertions.assertEquals(1200, auto.getValorDeLocacao());

    Assertions.assertEquals(auto, auto.getModelo());

    Assertions.assertEquals(false, auto.isLocado());

    auto.setLocado(true);

    Assertions.assertEquals(true, auto.isLocado());
  }

}
