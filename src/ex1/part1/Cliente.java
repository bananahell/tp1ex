package ex1.part1;

import java.util.ArrayList;


public class Cliente {

  private int cpf;
  private String nome;
  private ArrayList<Integer> telefone;

  public Cliente(int cpf) {
    this.cpf = cpf;
    this.nome = new String();
    this.telefone = new ArrayList<>();
  }

  public Cliente(int cpf, String nome, ArrayList<Integer> telefone) {
    this.cpf = cpf;
    this.nome = nome;
    this.telefone = telefone;
  }

  public int getCpf() {
    return this.cpf;
  }

  public void setCpf(int cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public ArrayList<Integer> getTelefone() {
    return this.telefone;
  }

  public void setTelefone(ArrayList<Integer> telefone) {
    this.telefone = telefone;
  }

}
