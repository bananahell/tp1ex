package ex1.part1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Agencia {

  private int codAgencia;
  private String local;

  Statement stmt = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  public Agencia(int codAgencia, String local) {
    this.codAgencia = codAgencia;
    this.local = local;
  }

  @Override
  public String toString() {/*
                             * String carros = "\nCarros presentes (por placa):"; if
                             * (this.automoveisPlacas.isEmpty()) { carros += " vazio"; }
                             * else { for (String placa : this.automoveisPlacas) {
                             * carros += "\n  "; carros += placa.toString(); } }
                             */
    return "Código da agência: " + this.codAgencia + "\nLocal: " + this.local;// + carros;
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

  public void adicionaAutomovel(String placa) {
    try {
      this.pstmt = _MainClass.conn
          .prepareStatement("UPDATE automovel SET locado = false, agencia = ? WHERE placa = ?");
      this.pstmt.setInt(1, this.codAgencia);
      this.pstmt.setString(2, placa);
      this.pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void tiraAutomovel(String placa) {
    try {
      this.pstmt =
          _MainClass.conn.prepareStatement("UPDATE automovel SET locado = true WHERE placa = ?");
      this.pstmt.setString(1, placa);
      this.pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
