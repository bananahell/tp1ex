package ex1.part1;

public class _MainClass {

  public static Marca chevrolet = new Marca(0, "A vida e assim");
  public static Modelo corsa = new Modelo(100, "Meu corsinha eu nao viro", 4, _MainClass.chevrolet);
  public static Modelo celta = new Modelo(101, "o ceuta zul", 4, _MainClass.chevrolet);

  public static Marca fiat = new Marca(1, "Com tecnologia e personalidade");
  public static Modelo palioTurbo = new Modelo(102, "PALIO TURBO", 4, _MainClass.fiat);
  public static Modelo palioFire = new Modelo(103, "meu palio ta pegando fogo", 4, _MainClass.fiat);

  public static Marca volkswagen = new Marca(2, "Das Auto");
  public static Modelo gol = new Modelo(104, "#galvaoLivesMatter", 4, _MainClass.volkswagen);
  public static Modelo fox = new Modelo(105, "nove rabas", 4, _MainClass.volkswagen);

  public static Marca ford = new Marca(3, "Go Further");
  public static Modelo capri = new Modelo(106, "sun", 4, _MainClass.ford);
  public static Modelo bronco = new Modelo(107, "carro racista", 4, _MainClass.ford);

  public static Marca hyundai = new Marca(4, "Mais que cinco estrelas, 200 milhoes de coracoes");
  public static Modelo santaCruz = new Modelo(108, "gloria a deux", 4, _MainClass.hyundai);
  public static Modelo elantra = new Modelo(109, "carro 2,718lantra", 4, _MainClass.hyundai);

  public static Marca toyota = new Marca(5, "Tradicao, qualidade, confianca");
  public static Modelo hilux = new Modelo(110, "oi, luz!", 4, _MainClass.toyota);
  public static Modelo corolla = new Modelo(111, "cor, olha!", 4, _MainClass.toyota);

  public static Marca renault = new Marca(6, "Passion for life");
  public static Modelo clio = new Modelo(112, "CLIO", 4, _MainClass.renault);
  public static Modelo megane = new Modelo(113, "MEGAZINE LUIZA", 4, _MainClass.renault);

  public static Marca honda = new Marca(7, "The power of dreams");
  public static Modelo civic = new Modelo(114, "nao militar", 4, _MainClass.honda);
  public static Modelo fit = new Modelo(115, "carro que nao e carro", 4, _MainClass.honda);

  public static Marca jeep = new Marca(8, "Liberdade e aventura desde 1941");
  public static Modelo cherokee = new Modelo(116, "THUNDER HORSE", 4, _MainClass.jeep);
  public static Modelo renegade = new Modelo(117, "o king slayer", 4, _MainClass.jeep);

  public static Marca nissan = new Marca(9, "Picape forte de verdade");
  public static Modelo march = new Modelo(118, "abril", 4, _MainClass.nissan);
  public static Modelo versa = new Modelo(119, "proso", 4, _MainClass.nissan);

  public static void main(String[] args) {

    Automovel meuPrimeiroCarro = new Automovel("xoxo420", "cor de pele", 2018, "fogo do meu rabo",
        0, 843957, "chaaaassiiiiii", 399, _MainClass.corsa);

    System.out.println("Placa: " + meuPrimeiroCarro.getNumeroDaPlaca() + "\nCor: " +
        meuPrimeiroCarro.getCor() + "\nAno: " + meuPrimeiroCarro.getAno() + "\nCombustível: " +
        meuPrimeiroCarro.getTipoDeCombustivel() + "\nPortas: " +
        meuPrimeiroCarro.getNumeroDePortas() + "\nQuilometragem: " +
        meuPrimeiroCarro.getQuilometragem() + "\nRenavam: " + meuPrimeiroCarro.getRenavam() +
        "\nChassi: " + meuPrimeiroCarro.getChassi() + "\nValor de" + " Locacao: " +
        meuPrimeiroCarro.getValorDeLocacao() + "\nID modelo: " + meuPrimeiroCarro.getIdModelo() +
        "\nDados modelo: " + meuPrimeiroCarro.getDadosModelo() + "\nID marca: " +
        meuPrimeiroCarro.getIdMarca() + "\nDados marca: " + meuPrimeiroCarro.getDadosMarca());

    System.out.println("ayyyy lmao");

  }

}
