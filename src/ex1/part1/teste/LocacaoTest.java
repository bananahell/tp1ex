package ex1.part1.teste;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ex1.part1.Agencia;
import ex1.part1.Locacao;


public class LocacaoTest {

  @Test
  public void testLocacao() {
    
    Locacao loca0 = new Locacao(6969, 12222222222L, 2, "pum-1000");
    Locacao loca1 = new Locacao(10, 6969, 6969, 22222222222L, 2, "pao-1000");
    Locacao loca2 = new Locacao(4444, 32222222222L, 1, "pum-1001");
    Locacao loca3 = new Locacao(10, 4444, 6969, 42222222222L, 1, "pao-1001");
    LocalDateTime ahoradomomento = LocalDateTime.now();
    LocalDateTime ahoradooutromomento = LocalDateTime.now();
    // aqui ainda nao fizemos uma regra de negocio nesses dois
    // testes
    Assertions.assertEquals(0, loca0.calculaPreco());
    Assertions.assertEquals(0, loca1.calculaPreco());
    Assertions.assertEquals(0, loca2.calculaPreco());
    Assertions.assertEquals(0, loca3.calculaPreco());

    Assertions.assertEquals(1, loca0.getIdLocacao());
    Assertions.assertEquals(1, loca1.getIdLocacao());
    Assertions.assertEquals(1, loca2.getIdLocacao());
    Assertions.assertEquals(1, loca3.getIdLocacao());

    // talvez tenha que mudar o método, ou o teste
    // assertEquals(LocalDateTime.now(),loca0.getDataHoraLocado());

    // loca0.setDataHoraLocado(ahoradomomento);
    // assertEquals(ahoradomomento,loca0.getDataHoraLocado());
    // assertEquals(ahoradomomento,loca0.getDataHoraDevolvido());

    Assertions.assertEquals(0, loca0.getDias());
    Assertions.assertEquals(10, loca1.getDias());
    Assertions.assertEquals(0, loca2.getDias());
    Assertions.assertEquals(10, loca3.getDias());

    loca0.setDias(5);
    loca1.setDias(6);
    loca2.setDias(7);
    loca3.setDias(8);

    Assertions.assertEquals(5, loca0.getDias());
    Assertions.assertEquals(6, loca1.getDias());
    Assertions.assertEquals(7, loca2.getDias());
    Assertions.assertEquals(8, loca3.getDias());

    Assertions.assertEquals(6969, loca0.getAgenciaLocada());
    Assertions.assertEquals(6969, loca1.getAgenciaLocada());
    Assertions.assertEquals(4444, loca2.getAgenciaLocada());
    Assertions.assertEquals(4444, loca3.getAgenciaLocada());

    loca0.setAgenciaLocada(4444);
    loca1.setAgenciaLocada(4444);
    loca2.setAgenciaLocada(6969);
    loca3.setAgenciaLocada(6969);

    Assertions.assertEquals(4444, loca0.getAgenciaLocada());
    Assertions.assertEquals(4444, loca1.getAgenciaLocada());
    Assertions.assertEquals(6969, loca2.getAgenciaLocada());
    Assertions.assertEquals(6969, loca3.getAgenciaLocada());

    Assertions.assertEquals(0, loca0.getAgenciaDevolvida());
    Assertions.assertEquals(6969, loca1.getAgenciaDevolvida());
    Assertions.assertEquals(0, loca2.getAgenciaDevolvida());
    Assertions.assertEquals(6969, loca3.getAgenciaDevolvida());

    loca0.setAgenciaDevolvida(6969);
    loca1.setAgenciaDevolvida(4444);
    loca2.setAgenciaDevolvida(6969);
    loca3.setAgenciaDevolvida(4444);

    Assertions.assertEquals(6969, loca0.getAgenciaDevolvida());
    Assertions.assertEquals(4444, loca1.getAgenciaDevolvida());
    Assertions.assertEquals(6969, loca2.getAgenciaDevolvida());
    Assertions.assertEquals(4444, loca3.getAgenciaDevolvida());

    Assertions.assertEquals(12222222222L, loca0.getCpf());
    Assertions.assertEquals(22222222222L, loca1.getCpf());
    Assertions.assertEquals(32222222222L, loca2.getCpf());
    Assertions.assertEquals(42222222222L, loca3.getCpf());

    loca0.setCpf(4);
    loca1.setCpf(3);
    loca2.setCpf(2);
    loca3.setCpf(1);

    Assertions.assertEquals(4, loca0.getCpf());
    Assertions.assertEquals(3, loca1.getCpf());
    Assertions.assertEquals(2, loca2.getCpf());
    Assertions.assertEquals(1, loca3.getCpf());

    Assertions.assertEquals(2, loca0.getTipo());
    Assertions.assertEquals(2, loca1.getTipo());
    Assertions.assertEquals(1, loca2.getTipo());
    Assertions.assertEquals(1, loca3.getTipo());

    loca0.setTipo(1);
    loca1.setTipo(1);
    loca2.setTipo(2);
    loca3.setTipo(2);

    Assertions.assertEquals(1, loca0.getTipo());
    Assertions.assertEquals(1, loca1.getTipo());
    Assertions.assertEquals(2, loca2.getTipo());
    Assertions.assertEquals(2, loca3.getTipo());

    Assertions.assertEquals(0, loca0.getValor());
    Assertions.assertEquals(0, loca1.getValor());
    Assertions.assertEquals(0, loca2.getValor());
    Assertions.assertEquals(0, loca3.getValor());

    loca0.setValor(10);
    loca1.setValor(20);
    loca2.setValor(30);
    loca3.setValor(40);

    Assertions.assertEquals(10, loca0.getValor());
    Assertions.assertEquals(20, loca1.getValor());
    Assertions.assertEquals(30, loca2.getValor());
    Assertions.assertEquals(40, loca3.getValor());

    Assertions.assertEquals("pum-1000", loca0.getPlaca());
    Assertions.assertEquals("pao-1000", loca1.getPlaca());
    Assertions.assertEquals("pum-1001", loca2.getPlaca());
    Assertions.assertEquals("pao-1001", loca3.getPlaca());

    loca0.setPlaca("pum-2000");
    loca1.setPlaca("pao-2000");
    loca2.setPlaca("pum-2001");
    loca3.setPlaca("pao-2001");

    Assertions.assertEquals("pum-2000", loca0.getPlaca());
    Assertions.assertEquals("pao-2000", loca1.getPlaca());
    Assertions.assertEquals("pum-2001", loca2.getPlaca());
    Assertions.assertEquals("pao-2001", loca3.getPlaca());

  }

}
