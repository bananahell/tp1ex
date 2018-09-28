package ex1.part1;

public class Automovel extends Modelo {

  private String numeroDaPlaca;
  private String cor;
  private int ano;
  private String tipoDeCombustivel;
  private double quilometragem;
  private int renavam;
  private String chassi;
  private double valorDeLocacao;
  private boolean locado;

  public Automovel(String numeroDaPlaca, String cor, int ano, String tipoDeCombustivel,
      double quilometragem, int renavam, String chassi, double valorDeLocacao, Modelo modelo) {
    super(modelo.getIdModelo(), modelo.getNomeModelo(), modelo.getDadosModelo(),
        modelo.getNumeroDePortas(), modelo.getMarca());
    this.numeroDaPlaca = numeroDaPlaca;
    this.cor = cor;
    this.ano = ano;
    this.tipoDeCombustivel = tipoDeCombustivel;
    this.quilometragem = quilometragem;
    this.renavam = renavam;
    this.chassi = chassi;
    this.valorDeLocacao = valorDeLocacao;
    this.setLocado(false);
  }

  @Override
  public String toString() {
    return "Placa: " + this.numeroDaPlaca + "\nCor: " + this.cor + "\nAno: " + this.ano +
        "\nTipo de combustível: " + this.tipoDeCombustivel + "\nQuilometragem: " +
        this.quilometragem + "\nRenavam: " + this.renavam + "\nChassi: " + this.chassi +
        "\nValor de locação: " + this.valorDeLocacao + "\nMarca: " + this.getNomeMarca() +
        "\nModelo: " + this.getNomeModelo() + "\nNúmero de portas: " + this.getNumeroDePortas();
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

  public void setTipoDeCombustÃ­vel(String tipoDeCombustivel) {
    this.tipoDeCombustivel = tipoDeCombustivel;
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

  public boolean isLocado() {
    return this.locado;
  }

  public void setLocado(boolean locado) {
    this.locado = locado;
  }

}
