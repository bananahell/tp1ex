package ex1.part1;

public class Cliente {

  private int cpf;
  private String senha;
  private String nome;

  public Cliente(int cpf, String senha, String nome) {
    this.cpf = cpf;
    this.senha = senha;
    this.nome = nome;
  }

  @Override
  public String toString() {
    /*
     * String telefonesCliente = "\nTelefones do cliente:"; if
     * (this.telefones.isEmpty()) { telefonesCliente +=
     * " vazio"; } else { for (String telefone : this.telefones)
     * { telefonesCliente += "\n  "; telefonesCliente +=
     * telefone.toString(); } }
     */
    return "CPF: " + this.cpf + "\nNome: " + this.nome;// + telefonesCliente;
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

}
