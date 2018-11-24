package ex1.part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class _MainClass {

  // TODO aqui é decidido se a aplicação vai ser testada em
  // localhost ou se ela vai usar o servidor remoto
  // freemysqlhosting.net
  /*
   * static final String DATABASE_URL =
   * "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10264389";
   * static final String DBUSER = "sql10264389"; static final
   * String DBPASS = "FDNglsrZcA";
   */
  // localhost

  static final String DATABASE_URL = "jdbc:mysql://localhost/tp1";
  static final String DBUSER = "root";
  static final String DBPASS = "alucard114";

  public static ArrayList<Marca> marcas = new ArrayList<>();
  public static ArrayList<Modelo> modelos = new ArrayList<>();

  public static Marca chevrolet = new Marca(0, "Chevrolet", "A vida e assim");
  public static Modelo corsa =
      new Modelo(100, "Corsa", "Meu corsinha eu nao viro", 4, _MainClass.chevrolet);
  public static Modelo celta = new Modelo(101, "Celta", "o ceuta zul", 4, _MainClass.chevrolet);

  public static int CPF_ADMIN = 123;

  public static Connection conn = null;

  public static void main(String[] args) {

    try {
      Class.forName("com.mysql.jdbc.Driver");
      _MainClass.conn = DriverManager.getConnection(_MainClass.DATABASE_URL, _MainClass.DBUSER,
          _MainClass.DBPASS);
    } catch (SQLException e) {

      System.err.println("SQLException: " + e.getMessage());
      System.err.println("SQLState: " + e.getSQLState());
      System.err.println("VendorError: " + e.getErrorCode());
      e.printStackTrace();

    } catch (ClassNotFoundException e1) {
      System.err.println(e1.getMessage());
      e1.printStackTrace();
    }

    _MainClass.marcas.add(_MainClass.chevrolet);

    _MainClass.modelos.add(_MainClass.corsa);
    _MainClass.modelos.add(_MainClass.celta);

    try {

      // ADMIN
      Locadora.addCliente(new Cliente(_MainClass.CPF_ADMIN, "admin", "admin"));

      // automóveis
      Locadora.addAutomovel(new Automovel("XVC-4123", "Preto", 2010, "Gasolina", 0, 99028318047l,
          "aiuw8322o312o", 80, _MainClass.corsa));
      Locadora.addAutomovel(new Automovel("XPC-7547", "Branco", 2015, "Álcool", 10000, 99575345047l,
          "39r72f93uf2h3", 200, _MainClass.celta));

      // agências
      Locadora.addAgencia(new Agencia(1, "W3 norte"));
      Locadora.getAgencia(1).adicionaAutomovel("XVC-4123");

      Locadora.addAgencia(new Agencia(2, "L2 sul"));
      Locadora.getAgencia(2).adicionaAutomovel("XPC-7547");

    } catch (Exception e) {
      System.err.println("Erro na inicialização da main!!!");
    }

    View view = View.getInstancia();

    view.run();

    System.out.println("Bye! Have a good time!");

  }

}
