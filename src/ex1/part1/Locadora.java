package ex1.part1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Locadora {

  private static ArrayList<Automovel> automoveis = new ArrayList<>();
  private static ArrayList<Cliente> clientes = new ArrayList<>();
  private static ArrayList<Locacao> locacoes = new ArrayList<>();
  private static ArrayList<Agencia> agencias = new ArrayList<>();

  private static Statement stmt = null;
  private static ResultSet rs = null;

  public static int getUltimaLocacao() {
    return (Locadora.locacoes.isEmpty()) ? 0
        : Locadora.locacoes.get(Locadora.locacoes.size() - 1).getIdLocacao();
  }

  public static Locacao getUltimaLocacaoNoCpfDoAutomovel(long cpf, String placa) throws Exception {
    for (int i = Locadora.locacoes.size() - 1; i > -1; i--) {
      if ((Locadora.locacoes.get(i).getCpf() == cpf) &&
          placa.equals(Locadora.locacoes.get(i).getPlaca()) &&
          (Locadora.locacoes.get(i).getDataHoraDevolvido() == null)) {
        return Locadora.locacoes.get(i);
      }
    }
    throw new Exception("O automóvel especificado não está sendo locado pelo cpf dado no momento!");
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

  public static void deleteCliente(long cpf) throws Exception {
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

  public static boolean existeAgencia(int codAgencia) {
    try {
      Locadora.getAgencia(codAgencia);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean existeAutomovel(String placa) {
    try {
      Locadora.getAutomovel(placa);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean existeCliente(long cpf) {
    try {
      Locadora.getCliente(cpf);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean existeLocacao(int idLocacao) {
    try {
      Locadora.getLocacao(idLocacao);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static Agencia getAgencia(int codAgencia) throws Exception {
    for (Agencia agencia : Locadora.agencias) {
      if (agencia.getCodAgencia() == codAgencia) {
        return agencia;
      }
    }
    throw new Exception("Agência não encontrada!");
  }

  public static Automovel getAutomovel(String placa) throws Exception {
    for (Automovel automovel : Locadora.automoveis) {
      if (automovel.getNumeroDaPlaca().equals(placa)) {
        return automovel;
      }
    }
    throw new Exception("Automovel não encontrado!");
  }

  public static Cliente getCliente(long cpfDado) throws Exception {
    for (Cliente cliente : Locadora.clientes) {
      if (cliente.getCpf() == cpfDado) {
        return cliente;
      }
    }
    throw new Exception("Cliente não encontrado!");
  }

  public static Locacao getLocacao(int idLocacao) throws Exception {
    for (Locacao locacao : Locadora.locacoes) {
      if (locacao.getIdLocacao() == idLocacao) {
        return locacao;
      }
    }
    throw new Exception("Locação não encontrada!");
  }

  public static String toStringAgencias() {
    try {
      boolean vazio = true;
      Locadora.stmt = _MainClass.conn.createStatement();
      Locadora.rs = Locadora.stmt.executeQuery("SELECT id, local FROM agencia");
      String toStringAgencias = "Agências:";
      while (Locadora.rs.next()) {
        vazio = false;
        toStringAgencias += "\nCódigo da agência: " + Locadora.rs.getInt(1) + "\nLocal: " +
            Locadora.rs.getString(2);
      }
      if (vazio == true) {
        return toStringAgencias + "vazio";
      }
      return toStringAgencias;
    } catch (SQLException e) {
      e.printStackTrace();
      return "erro";
    }
  }

}
