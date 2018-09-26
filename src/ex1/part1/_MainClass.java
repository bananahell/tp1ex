package ex1.part1;

public class _MainClass {

  public static final int SEM_MARCA = -1;
  public static final int SEM_MODELO = -2;

  public static Marca chevrolet = new Marca(0, "A vida e assim");
  public static Modelo corsa = new Modelo(100, "Meu corsinha eu nao viro", _MainClass.chevrolet);
  public Modelo celta = new Modelo();

  public Marca fiat = new Marca();
  public Modelo palioTurbo = new Modelo();
  public Modelo palioFire = new Modelo();

  public Marca volkswagen = new Marca();
  public Modelo gol = new Modelo();
  public Modelo fox = new Modelo();

  public Marca ford = new Marca();
  public Modelo capri = new Modelo();
  public Modelo bronco = new Modelo();

  public Marca hyundai = new Marca();
  public Modelo santaCruz = new Modelo();
  public Modelo elantra = new Modelo();

  public Marca toyota = new Marca();
  public Modelo hilux = new Modelo();
  public Modelo corolla = new Modelo();

  public Marca renault = new Marca();
  public Modelo clio = new Modelo();
  public Modelo megane = new Modelo();

  public Marca honda = new Marca();
  public Modelo civic = new Modelo();
  public Modelo fit = new Modelo();

  public Marca jeep = new Marca();
  public Modelo cherokee = new Modelo();
  public Modelo renegade = new Modelo();

  public Marca nissan = new Marca();
  public Modelo march = new Modelo();
  public Modelo versa = new Modelo();

  public static void main(String[] args) {

    Automovel meuPrimeiroCarro = new Automovel("xoxo420", "cor de pele", 2018, "fogo do meu rabo",
        69, 0, 843957, "chaaaassiiiiii", 399, _MainClass.corsa);

    System.out.println("Placa: " + meuPrimeiroCarro.getNumeroDaPlaca() + "\nCor: " +
        meuPrimeiroCarro.getCor() + "\nAno: " + meuPrimeiroCarro.getAno() + "\nCombustível: " +
        meuPrimeiroCarro.getTipoDeCombustivel() + "\nPortas: " +
        meuPrimeiroCarro.getNumeroDePortas() + "\nQuilometragem: " +
        meuPrimeiroCarro.getQuilometragem() + "\nRenavam: " + meuPrimeiroCarro.getRenavam() +
        "\nChassi: " + meuPrimeiroCarro.getChassi() + "\nValor de" + " Locacao: " +
        meuPrimeiroCarro.getValorDeLocacao() + "\nID modelo: " + meuPrimeiroCarro.getIdModelo() +
        "\nDados modelo: " + meuPrimeiroCarro.getDadosModelo() + "\nID marca: " +
        meuPrimeiroCarro.getIdMarca() + "\nDados marca: " + meuPrimeiroCarro.getDadosMarca());

    System.out.println("hue");

  }

}
