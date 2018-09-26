package ex1.part1;

import java.util.ArrayList;


public class Locadora {

  private ArrayList<Automovel> automoveis = new ArrayList<>();
  private ArrayList<Cliente> clientes = new ArrayList<>();
  private ArrayList<Locacao> locacoes = new ArrayList<>();
  private ArrayList<Agencia> agencias = new ArrayList<>();

  public int getIndiceAutomovel(String placa) {

    for (int i = 0; i < this.automoveis.size(); i++) {
      if (this.automoveis.get(i).getNumeroDaPlaca() == placa) {
        return i;
      }
    }
    return -1;

  }

  public int getIndiceCliente(int cpf) {

    for (int i = 0; i < this.clientes.size(); i++) {
      if (this.clientes.get(i).getCpf() == cpf) {
        return i;
      }
    }
    return -1;

  }

  public int getIndiceLocacao(int idLocacao) {

    for (int i = 0; i < this.locacoes.size(); i++) {
      if (this.locacoes.get(i).getIdLocacao() == idLocacao) {
        return i;
      }
    }
    return -1;

  }

  public int getIndiceAgencia(int codAgencia) {

    for (int i = 0; i < this.agencias.size(); i++) {
      if (this.agencias.get(i).getCodAgencia() == codAgencia) {
        return i;
      }
    }
    return -1;

  }

}
