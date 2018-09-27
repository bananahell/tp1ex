package ex1.part1;

import java.util.ArrayList;


public class Agencia {

  private int codAgencia;
  private String local;
  private ArrayList<Integer> automoveisPlacas;

  public Agencia(int codAgencia, String local) {
    this.codAgencia = codAgencia;
    this.local = local;
  }

  @Override
  public String toString() {
    String carros = "\nCarros presentes (por placa):";
    if (this.automoveisPlacas.isEmpty()) {
      carros += " vazio";
    } else {
      for (Integer placa : this.automoveisPlacas) {
        carros += "\n  ";
        carros += placa.toString();
      }
    }
    return "Código da agência: " + this.codAgencia + "\nLocal: " + this.local + carros;
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

  public ArrayList<Integer> getAutomoveisPlacas() {
    return this.automoveisPlacas;
  }

  public void setAutomoveis(ArrayList<Integer> automoveisPlacas) {
    this.automoveisPlacas = automoveisPlacas;
  }

}
