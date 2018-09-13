package ex1.part1;

public class Automovel extends Modelo {

  private int idAutomovel;
  private String numeroDaPlaca;
  private String cor;
  private int ano;
  private String tipoDeCombustivel;
  private int numeroDePortas;
  private double quilometragem;
  private int renavam;
  private String chassi;
  private double valorDeLocacao;
  // TODO ETC?

  public Automovel() {
    this.idAutomovel = -1; // TODO procurar se id ta disponivel
    this.numeroDaPlaca = new String();
    this.cor = new String();
    this.ano = -1;
    this.tipoDeCombustivel = new String();
    this.numeroDePortas = -1;
    this.quilometragem = -1;
    this.renavam = -1;
    this.chassi = new String();
    this.valorDeLocacao = -1;
  }

  public Automovel(int idAutomovel, String numeroDaPlaca, String cor, int ano,
      String tipoDeCombustivel, int numeroDePortas, double quilometragem, int renavam,
      String chassi, double valorDeLocacao) {
    this.idAutomovel = idAutomovel; // TODO procurar se id ta disponivel
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

  public int getIdAutomovel() {
    return this.idAutomovel;
  }

  public void setIdAutomovel(int idAutomovel) {
    this.idAutomovel = idAutomovel; // TODO procurar se id ta disponivel
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

}
