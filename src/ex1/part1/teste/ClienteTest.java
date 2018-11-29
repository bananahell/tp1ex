package ex1.part1.teste;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ex1.part1.Cliente;


public class ClienteTest {

  @Test
  public void testCliente() {

    ArrayList<String> tels = new ArrayList<String>();
    tels.add(0, "25696969");
    ArrayList<String> ArrayVazio = new ArrayList<String>();

    Cliente client = new Cliente(12345678910L, "xaropinho2015", "Luciano", ArrayVazio);

    Assertions.assertEquals(12345678910L, client.getCpf());

    client.setCpf(22345678910L);
    Assertions.assertEquals(22345678910L, client.getCpf());

    Assertions.assertEquals("xaropinho2015", client.getSenha());

    client.setSenha("loro2016");
    Assertions.assertEquals("loro2016", client.getSenha());

    Assertions.assertEquals("Luciano", client.getNome());

    client.setNome("Marcinho de bangu");
    Assertions.assertEquals("Marcinho de bangu", client.getNome());

    Assertions.assertEquals(ArrayVazio, client.getTelefones());

    Assertions.assertEquals(
        "CPF: 22345678910\nNome: Marcinho de bangu\nTelefones do cliente: vazio",
        client.toString());

    client.setTelefones(tels);
    Assertions.assertEquals(tels, client.getTelefones());

    Assertions.assertEquals(
        "CPF: 22345678910\nNome: Marcinho de bangu\nTelefones do cliente:\n  25696969",
        client.toString());
  }

}
