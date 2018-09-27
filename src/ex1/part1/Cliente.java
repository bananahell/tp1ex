package ex1.part1;

import java.util.ArrayList;


public class Cliente {

  private int cpf;
  private String senha;
  private String nome;
  private ArrayList<String> telefones;

  public Cliente(int cpf, String senha, String nome, ArrayList<String> telefones) {
    this.cpf = cpf;
    this.senha = senha;
    this.nome = nome;
    this.telefones = telefones;
  }

  @Override
  public String toString() {
    String telefonesCliente = "\nTelefones do cliente:";
    if (this.telefones.isEmpty()) {
      telefonesCliente += " vazio";
    } else {
      for (String telefone : this.telefones) {
        telefonesCliente += "\n  ";
        telefonesCliente += telefone.toString();
      }
    }
    return "CPF: " + this.cpf + "\nNome: " + this.nome + telefonesCliente;
  }

  public int getCpf() {
    return this.cpf;
  }

  public void setCpf(int cpf) {
    this.cpf = cpf;
  }

  public String getSenha() {
    return this.senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public ArrayList<String> getTelefones() {
    return this.telefones;
  }

  public void setTelefones(ArrayList<String> telefones) {
    this.telefones = telefones;
  }

}
