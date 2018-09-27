package ex1.part1;

import java.util.ArrayList;


public class Locadora {

  private static ArrayList<Automovel> automoveis = new ArrayList<>();
  private static ArrayList<Cliente> clientes = new ArrayList<>();
  private static ArrayList<Locacao> locacoes = new ArrayList<>();
  private static ArrayList<Agencia> agencias = new ArrayList<>();

  public static int getUltimaLocacao() {
    return (Locadora.locacoes.isEmpty()) ? 0
        : Locadora.locacoes.get(Locadora.locacoes.size() - 1).getIdLocacao();
  }

  public static void addAgencia(Agencia agencia) {
    Locadora.agencias.add(agencia);
  }

  public static void addAutomovel(Automovel automovel) {
    Locadora.automoveis.add(automovel);
  }

  public static void addCliente(Cliente cliente) {
    Locadora.clientes.add(cliente);
  }

  public static void addLocacao(Locacao locacao) {
    Locadora.locacoes.add(locacao);
  }

  public static void deleteAgencia(int codAgencia) throws Exception {
    try {
      Locadora.agencias.remove(Locadora.getAgencia(codAgencia));
    } catch (Exception e) {
      throw e;
    }
  }

  public static void deleteAutomovel(String placa) throws Exception {
    try {
      Locadora.automoveis.remove(Locadora.getAutomovel(placa));
    } catch (Exception e) {
      throw e;
    }
  }

  public static void deleteCliente(int cpf) throws Exception {
    try {
      Locadora.clientes.remove(Locadora.getCliente(cpf));
    } catch (Exception e) {
      throw e;
    }
  }

  public static void deleteLocacao(int idLocacao) throws Exception {
    try {
      Locadora.locacoes.remove(Locadora.getLocacao(idLocacao));
    } catch (Exception e) {
      throw e;
    }
  }

  public static Agencia getAgencia(int codAgencia) throws Exception {
    for (Agencia agencia : Locadora.agencias) {
      if (agencia.getCodAgencia() == codAgencia) {
        return agencia;
      }
    }
    throw new Exception("Ag�ncia n�o encontrada!");
  }

  public static Automovel getAutomovel(String placa) throws Exception {
    for (Automovel automovel : Locadora.automoveis) {
      if (automovel.getNumeroDaPlaca() == placa) {
        return automovel;
      }
    }
    throw new Exception("Automovel n�o encontrado!");
  }

  public static Cliente getCliente(int cpf) throws Exception {
    for (Cliente cliente : Locadora.clientes) {
      if (cliente.getCpf() == cpf) {
        return cliente;
      }
    }
    throw new Exception("Cliente n�o encontrado!");
  }

  public static Locacao getLocacao(int idLocacao) throws Exception {
    for (Locacao locacao : Locadora.locacoes) {
      if (locacao.getIdLocacao() == idLocacao) {
        return locacao;
      }
    }
    throw new Exception("Loca��o n�o encontrada!");
  }

}
