package ex1.part1;

public class Cliente {

  private long cpf;
  private String senha;
  private String nome;

<<<<<<< HEAD
  public Cliente(long cpf, String senha, String nome, ArrayList<String> telefones) {
=======
  public Cliente(int cpf, String senha, String nome) {
>>>>>>> branch 'conectando' of https://github.com/bananahell/tp1ex
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

  public long getCpf() {
    return this.cpf;
  }

  public void setCpf(long cpf) {
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
