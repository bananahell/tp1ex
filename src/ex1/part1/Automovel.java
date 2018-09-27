package ex1.part1;

public class Automovel extends Modelo {

  private String numeroDaPlaca;
  private String cor;
  private int ano;
  private String tipoDeCombustivel;
  private int numeroDePortas;
  private double quilometragem;
  private int renavam;
  private String chassi;
  private double valorDeLocacao;

  public Automovel(String numeroDaPlaca) {
    super();
    this.numeroDaPlaca = numeroDaPlaca;
    this.cor = new String();
    this.ano = -1;
    this.tipoDeCombustivel = new String();
    this.numeroDePortas = -1;
    this.quilometragem = -1;
    this.renavam = -1;
    this.chassi = new String();
    this.valorDeLocacao = -1;
  }

  public Automovel(String numeroDaPlaca, String cor, int ano, String tipoDeCombustivel,
      int numeroDePortas, double quilometragem, int renavam, String chassi, double valorDeLocacao,
      Modelo modelo) {
    super(modelo.getIdModelo(), modelo.getDadosModelo(), modelo.getMarca());
    this.numeroDaPlaca = numeroDaPlaca;
    this.cor = cor;
    this.ano = ano;
    this.tipoDeCombustivel = tipoDeCombustivel;
    this.numeroDePortas = numeroDePortas;
    this.quilometragem = quilometragem;
    this.renavam = renavam;
    this.chassi = chassi;
    this.valorDeLocacao = valorDeLocacao;
  }

  public String getNumeroDaPlaca() {
    return this.numeroDaPlaca;
  }

  public void setNumeroDaPlaca(String numeroDaPlaca) {
    this.numeroDaPlaca = numeroDaPlaca;
  }

  public String getCor() {
    return this.cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public int getAno() {
    return this.ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public String getTipoDeCombustivel() {
    return this.tipoDeCombustivel;
  }

  public void setTipoDeCombustível(String tipoDeCombustivel) {
    this.tipoDeCombustivel = tipoDeCombustivel;
  }

  public int getNumeroDePortas() {
    return this.numeroDePortas;
  }

  public void setNumeroDePortas(int numeroDePortas) {
    this.numeroDePortas = numeroDePortas;
  }

  public double getQuilometragem() {
    return this.quilometragem;
  }

  public void setQuilometragem(double quilometragem) {
    this.quilometragem = quilometragem;
  }

  public int getRenavam() {
    return this.renavam;
  }

  public void setRenavam(int renavam) {
    this.renavam = renavam;
  }

  public String getChassi() {
    return this.chassi;
  }

  public void setChassi(String chassi) {
    this.chassi = chassi;
  }

  public double getValorDeLocacao() {
    return this.valorDeLocacao;
  }

  public void setValorDeLocacao(double valorDeLocacao) {
    this.valorDeLocacao = valorDeLocacao;
  }

  public Modelo getModelo() {
    return this;
  }

}
