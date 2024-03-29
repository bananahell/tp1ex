package ex1.part1;

import java.util.ArrayList;


public class _MainClass {

  public static ArrayList<Marca> marcas = new ArrayList<>();
  public static ArrayList<Modelo> modelos = new ArrayList<>();

  public static Marca chevrolet = new Marca(0, "Chevrolet", "A vida e assim");
  public static Modelo corsa =
      new Modelo(100, "Corsa", "Meu corsinha eu nao viro", 4, _MainClass.chevrolet);
  public static Modelo celta = new Modelo(101, "Celta", "o ceuta zul", 4, _MainClass.chevrolet);

  public static Marca fiat = new Marca(1, "Fiat", "Com tecnologia e personalidade");
  public static Modelo palioTurbo =
      new Modelo(102, "Palio Turbo", "PALIO TURBO", 4, _MainClass.fiat);
  public static Modelo palioFire =
      new Modelo(103, "Palio Fire", "meu palio ta pegando fogo", 4, _MainClass.fiat);

  public static Marca volkswagen = new Marca(2, "Volkswagen", "Das Auto");
  public static Modelo gol = new Modelo(104, "Gol", "#galvaoLivesMatter", 4, _MainClass.volkswagen);
  public static Modelo fox = new Modelo(105, "Fox", "nove rabas", 4, _MainClass.volkswagen);

  public static Marca ford = new Marca(3, "Ford", "Go Further");
  public static Modelo capri = new Modelo(106, "Capri", "sun", 4, _MainClass.ford);
  public static Modelo bronco = new Modelo(107, "Bronco", "carro racista", 4, _MainClass.ford);

  public static Marca hyundai =
      new Marca(4, "Hyundai", "Mais que cinco estrelas, 200 milhoes de coracoes");
  public static Modelo santaCruz =
      new Modelo(108, "Santa Cruz", "gloria a deux", 4, _MainClass.hyundai);
  public static Modelo elantra =
      new Modelo(109, "Elantra", "carro 2,718lantra", 4, _MainClass.hyundai);

  public static Marca toyota = new Marca(5, "Toyota", "Tradicao, qualidade, confianca");
  public static Modelo hilux = new Modelo(110, "Hilux", "oi, luz!", 4, _MainClass.toyota);
  public static Modelo corolla = new Modelo(111, "Corolla", "cor, olha!", 4, _MainClass.toyota);

  public static Marca renault = new Marca(6, "Renault", "Passion for life");
  public static Modelo clio = new Modelo(112, "Clio", "CLIO", 4, _MainClass.renault);
  public static Modelo megane = new Modelo(113, "Megane", "MEGAZINE LUIZA", 4, _MainClass.renault);

  public static Marca honda = new Marca(7, "Honda", "The power of dreams");
  public static Modelo civic = new Modelo(114, "Civic", "nao militar", 4, _MainClass.honda);
  public static Modelo fit = new Modelo(115, "Fit", "carro que nao e carro", 4, _MainClass.honda);

  public static Marca jeep = new Marca(8, "Jeep", "Liberdade e aventura desde 1941");
  public static Modelo cherokee = new Modelo(116, "Cherokee", "THUNDER HORSE", 4, _MainClass.jeep);
  public static Modelo renegade = new Modelo(117, "Renegade", "o king slayer", 4, _MainClass.jeep);

  public static Marca nissan = new Marca(9, "Nissan", "Picape forte de verdade");
  public static Modelo march = new Modelo(118, "March", "abril", 4, _MainClass.nissan);
  public static Modelo versa = new Modelo(119, "Versa", "proso", 4, _MainClass.nissan);

  public static int CPF_ADMIN = 123;

  public static void main(String[] args) {

    _MainClass.marcas.add(_MainClass.chevrolet);
    _MainClass.marcas.add(_MainClass.fiat);
    _MainClass.marcas.add(_MainClass.volkswagen);
    _MainClass.marcas.add(_MainClass.ford);
    _MainClass.marcas.add(_MainClass.hyundai);
    _MainClass.marcas.add(_MainClass.toyota);
    _MainClass.marcas.add(_MainClass.renault);
    _MainClass.marcas.add(_MainClass.honda);
    _MainClass.marcas.add(_MainClass.jeep);
    _MainClass.marcas.add(_MainClass.nissan);

    _MainClass.modelos.add(_MainClass.corsa);
    _MainClass.modelos.add(_MainClass.celta);
    _MainClass.modelos.add(_MainClass.palioTurbo);
    _MainClass.modelos.add(_MainClass.palioFire);
    _MainClass.modelos.add(_MainClass.gol);
    _MainClass.modelos.add(_MainClass.fox);
    _MainClass.modelos.add(_MainClass.capri);
    _MainClass.modelos.add(_MainClass.bronco);
    _MainClass.modelos.add(_MainClass.santaCruz);
    _MainClass.modelos.add(_MainClass.elantra);
    _MainClass.modelos.add(_MainClass.hilux);
    _MainClass.modelos.add(_MainClass.corolla);
    _MainClass.modelos.add(_MainClass.clio);
    _MainClass.modelos.add(_MainClass.megane);
    _MainClass.modelos.add(_MainClass.civic);
    _MainClass.modelos.add(_MainClass.fit);
    _MainClass.modelos.add(_MainClass.cherokee);
    _MainClass.modelos.add(_MainClass.renegade);
    _MainClass.modelos.add(_MainClass.march);
    _MainClass.modelos.add(_MainClass.versa);

    try {

      // ADMIN
      Locadora.addCliente(new Cliente(_MainClass.CPF_ADMIN, "admin", "admin", new ArrayList<>()));

      // autom�veis
      Locadora.addAutomovel(new Automovel("XVC-4123", "Preto", 2010, "Gasolina", 0, 99028318047l,
          "aiuw8322o312o", 80, _MainClass.fox));
      Locadora.addAutomovel(new Automovel("XPC-7547", "Branco", 2015, "�lcool", 10000, 99575345047l,
          "39r72f93uf2h3", 200, _MainClass.celta));
      Locadora.addAutomovel(new Automovel("OVN-3275", "Vermelho", 2015, "Gasolina", 5000,
          92575474047l, "12389329fff44", 190, _MainClass.capri));
      Locadora.addAutomovel(new Automovel("JGI-3572", "Vermelho", 2013, "Diesel", 7500,
          32895726606l, "208tewvnweo82", 50, _MainClass.fox));
      Locadora.addAutomovel(new Automovel("QWI-1393", "Branco", 2009, "Gasolina", 20000,
          21486378375l, "23894f23489f3", 70, _MainClass.bronco));
      Locadora.addAutomovel(new Automovel("VOS-5477", "Preto", 2016, "�lcool", 25000, 38985643678l,
          "2398thf2349f8", 300, _MainClass.elantra));
      Locadora.addAutomovel(new Automovel("WOF-5437", "Vermelho", 2003, "Diesel", 0, 39587593466l,
          "23930329r825f", 130, _MainClass.corolla));
      Locadora.addAutomovel(new Automovel("QPR-5255", "Branco", 2005, "Diesel", 9000, 23850578346l,
          "8rf3hf2378f23", 160, _MainClass.corolla));

      // ag�ncias
      Locadora.addAgencia(new Agencia(1, "W3 norte"));
      Locadora.getAgencia(1).adicionaAutomovel("XVC-4123");
      Locadora.getAgencia(1).adicionaAutomovel("XPC-7547");

      Locadora.addAgencia(new Agencia(2, "L2 sul"));
      Locadora.getAgencia(2).adicionaAutomovel("OVN-3275");

      Locadora.addAgencia(new Agencia(3, "Guar�"));
      Locadora.getAgencia(3).adicionaAutomovel("JGI-3572");
      Locadora.getAgencia(3).adicionaAutomovel("QWI-1393");
      Locadora.getAgencia(3).adicionaAutomovel("VOS-5477");

      Locadora.addAgencia(new Agencia(4, "Granja do Torto"));
      Locadora.getAgencia(4).adicionaAutomovel("WOF-5437");
      Locadora.getAgencia(4).adicionaAutomovel("QPR-5255");

    } catch (Exception e) {
      System.err.println("Erro na inicializa��o da main!!!");
    }

    View view = View.getInstancia();

    view.run();

    System.out.println("Bye! Have a good tiime!");

  }

}
