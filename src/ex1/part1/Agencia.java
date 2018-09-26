package ex1.part1;

public class Agencia {

  private int codAgencia;
  private String local;

  public Agencia() {
    this.codAgencia = -1;
    this.local = new String();
  }

  public Agencia(int codAgencia, String local) {
    this.codAgencia = codAgencia;
    this.local = local;
  }

  public int getCodAgencia() {
    return this.codAgencia;
  }

  public void setCodAgencia(int codAgencia) {
    this.codAgencia = codAgencia;
  }

  public String getLocal() {
    return this.local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

}
