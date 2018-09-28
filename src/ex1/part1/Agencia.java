package ex1.part1;

import java.util.ArrayList;


public class Agencia {

  private int codAgencia;
  private String local;
  private ArrayList<String> automoveisPlacas;

  public Agencia(int codAgencia, String local) {
    this.codAgencia = codAgencia;
    this.local = local;
    this.automoveisPlacas = new ArrayList<>();
  }

  @Override
  public String toString() {
    String carros = "\nCarros presentes (por placa):";
    if (this.automoveisPlacas.isEmpty()) {
      carros += " vazio";
    } else {
      for (String placa : this.automoveisPlacas) {
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

  public ArrayList<String> getAutomoveisPlacas() {
    return this.automoveisPlacas;
  }

  public void setAutomoveis(ArrayList<String> automoveisPlacas) {
    this.automoveisPlacas = automoveisPlacas;
  }

  public void adicionaAutomovel(String placa) {
    this.automoveisPlacas.add(placa);
  }

  public void tiraAutomovel(String placa) {
    for (String placaProcura : this.automoveisPlacas) {
      if (placa.equals(placaProcura)) {
        this.automoveisPlacas.remove(placaProcura);
        break;
      }
    }
  }

}
