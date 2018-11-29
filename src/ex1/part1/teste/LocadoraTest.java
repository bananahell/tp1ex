package ex1.part1.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ex1.part1.Agencia;
import ex1.part1.Automovel;
import ex1.part1.Cliente;
import ex1.part1.Locacao;
import ex1.part1.Locadora;
import ex1.part1.Marca;
import ex1.part1.Modelo;


public class LocadoraTest {

  @Test
  public void testLocadora() throws Exception {
    
    Marca marc = new Marca(0, "Volkswagen", "volk");
    Modelo model = new Modelo(1, "Fox", "pequeno carro", 4, marc);
    Automovel auto = new Automovel("xxt-6666", "vermelho", 2000, "gasolina", 0, 999999999,"1B019283019283447", 3000, model);
    ArrayList<String> ArrayVazio = new ArrayList<String>();
    Cliente client = new Cliente(12345678910L, "xaropinho2015", "Luciano", ArrayVazio);
    Locacao loca = new Locacao(6969, 12345678910L, 2, "pum-1000");
    Locacao loca1 = new Locacao(4444, 12345678911L, 1, "pai-1000");
    
    Agencia l2 = new Agencia(6969, "L2 sul");
    Agencia w3 = new Agencia(4444, "W3 sul");
    
    Locadora locadora = new Locadora();
    
    
    assertEquals(0,locadora.getUltimaLocacao());
    
    //assertEquals(0,locadora.getUltimaLocacaoNoCpfDoAutomovel(cpf, placa));
    
    assertEquals(false,locadora.existeAgencia(6969));   
    assertEquals(false,locadora.existeAutomovel("xxt-6666"));   
    assertEquals(false,locadora.existeCliente(12345678910L));
    assertEquals(false,locadora.existeLocacao(1));
    
    /*Nao sei testar exceçoes ainda
    assertEquals(0,locadora.getAgencia(6969));
    assertEquals(0,locadora.getAutomovel("xxt-6666"));
    assertEquals(0,locadora.getCliente(12345678910L));
    assertEquals(0,locadora.getLocacao(1));
    */
    
    assertEquals("Agências:vazio",locadora.toStringAgencias());
    
    locadora.addAgencia(l2);
    locadora.addAutomovel(auto);
    locadora.addCliente(client);
    locadora.addLocacao(loca);
    
    assertEquals(true,locadora.existeAgencia(6969));   
    assertEquals(true,locadora.existeAutomovel("xxt-6666"));   
    assertEquals(true,locadora.existeCliente(12345678910L));
    assertEquals(true,locadora.existeLocacao(1));
    
    assertEquals(l2,locadora.getAgencia(6969));
    assertEquals(auto,locadora.getAutomovel("xxt-6666"));
    assertEquals(client,locadora.getCliente(12345678910L));
    assertEquals(loca,locadora.getLocacao(1));
    
    assertEquals("Agências:\nCódigo da agência: 6969\nLocal: L2 sul",locadora.toStringAgencias());
    
    //locadora.addLocacao(loca1); aqui a locadora soh faz locacoes de id 1
    //assertEquals(2,locadora.getUltimaLocacao());
    //locadora.deleteLocacao(2);
    
    locadora.deleteAgencia(6969);
    locadora.deleteAutomovel("xxt-6666");
    locadora.deleteCliente(12345678910L);
    locadora.deleteLocacao(1);
    
    assertEquals(false,locadora.existeAgencia(6969));   
    assertEquals(false,locadora.existeAutomovel("xxt-6666"));   
    assertEquals(false,locadora.existeCliente(12345678910L));
    assertEquals(false,locadora.existeLocacao(1));
  }
}


