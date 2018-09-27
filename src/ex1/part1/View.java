package ex1.part1;

import java.util.ArrayList;
import java.util.Scanner;


public class View {

  private static View instancia;
  private boolean aindaFuncionando;
  private int cpfAtivo;

  private View() {
    this.aindaFuncionando = true;
  }

  public static View getInstancia() {
    if (View.instancia == null) {
      View.instancia = new View();
    }
    return View.instancia;
  }

  public void run() {
    while (this.aindaFuncionando) {
      this.signUpLogIn();
      if (this.cpfAtivo == 123) {
        this.adminControle();
      }
    }
  }

  private void signUpLogIn() {
    Scanner scanner = new Scanner(System.in);
    boolean notLoggedIn = true;

    while (notLoggedIn && this.aindaFuncionando) {
      System.out.println("Sign up ou Log in?");
      System.out.println();
      System.out.println("1 - Sign up");
      System.out.println("2 - Log in");
      System.out.println("0 - Sair da aplicação");
      System.out.println();
      switch (scanner.nextLine()) {
        case "1":
          break;
        case "2":
          System.out.println("CPF: ");
          int cpfDado = Integer.valueOf(scanner.nextLine()).intValue();
          System.out.println("Senha: ");
          String senhaDada = scanner.nextLine();
          Cliente cliente;
          try {
            cliente = Locadora.getCliente(cpfDado);
            if (!cliente.getSenha().equals(senhaDada)) {
              System.err.println("Senha incorreta!");
            } else {
              this.cpfAtivo = cpfDado;
              notLoggedIn = false;
            }
          } catch (Exception e) {
            System.err.println(e.getMessage());
          }
          break;
        case "0":
          this.aindaFuncionando = false;
          break;
        default:
          System.out.println();
          System.out.println("Por favor, escolha 1, 2 ou 0.");
          System.out.println();
          break;
      }
    }

  }

  private void adminControle() {
    Scanner scanner2 = new Scanner(System.in);
    boolean aindaAdmin = true;
    while (aindaAdmin && this.aindaFuncionando) {
      System.out.println("Olá, admin!");
      System.out.println();
      System.out.println("Escolha com o que quer mexer agora:");
      System.out.println("1 - Clientes");
      System.out.println("2 - Automóveis");
      System.out.println("3 - Agências");
      System.out.println("4 - Locações");
      System.out.println("5 - Voltar para login");
      System.out.println("0 - Sair");
      System.out.println();
      switch (scanner2.nextLine()) {
        case "1":
          this.adminCliente();
          break;
        case "2":
          break;
        case "3":
          break;
        case "4":
          break;
        case "5":
          this.cpfAtivo = -1;
          aindaAdmin = false;
          break;
        case "0":
          this.aindaFuncionando = false;
          break;
        default:
          System.out.println("Por favor, escolha 1, 2, 3, 4, 5 ou 0.");
      }
    }
  }

  private void adminCliente() {
    Scanner scanner = new Scanner(System.in);
    boolean aindaCliente = true;

    while (aindaCliente) {
      System.out.println();
      System.out.println("1 - Procurar um cliente");
      System.out.println("2 - Adicionar um cliente");
      System.out.println("3 - Deletar um cliente");
      System.out.println("4 - Voltar para controle");
      System.out.println();
      switch (scanner.nextLine()) {
        case "1":
          try {
            System.out.println("Digite o CPF do cliente a ser procurado:");
            System.out.println();
            System.out.println(
                Locadora.getCliente(Integer.valueOf(scanner.nextLine()).intValue()).toString());
          } catch (Exception e) {
            System.err.println(e.getMessage());
          }
          break;
        case "2":
          int cpf;
          String nome;
          String senha;
          ArrayList<String> telefones = new ArrayList<>();
          boolean maisTelefone = true;
          System.out.println("Digite as informações do cliente");
          System.out.println("CPF (só números):");
          System.out.println();
          cpf = Integer.valueOf(scanner.nextLine()).intValue();
          System.out.println("Senha:");
          System.out.println();
          senha = scanner.nextLine();
          System.out.println("Nome:");
          System.out.println();
          nome = scanner.nextLine();
          System.out.println(
              "Telefones (mande quantos telefones quiser e aperte Enter com uma entrada vazia para terminar):");
          while (maisTelefone) {
            String telefone = scanner.nextLine();
            if (telefone.isEmpty()) {
              maisTelefone = false;
            } else {
              telefones.add(telefone);
            }
          }
          Cliente cliente = new Cliente(cpf, senha, nome, telefones);
          Locadora.addCliente(cliente);
          System.out.println("Cliente criado com sucesso!");
          System.out.println();
          break;
        case "3":
          int cpfDado;
          String resposta;
          boolean naoTerminouDelete = true;
          try {
            System.out.println("Digite o CPF do cliente a ser deletado:");
            System.out.println();
            cpfDado = Integer.valueOf(scanner.nextLine()).intValue();
            System.out.println("Você tem certeza de que você quer deletar:");
            System.out.println(Locadora.getCliente(cpfDado).toString());
            System.out.println("[S|N]");
            System.out.println();
            while (naoTerminouDelete) {
              resposta = scanner.nextLine();
              if ((resposta.equals("S")) || (resposta.equals("s"))) {
                Locadora.deleteCliente(cpfDado);
                System.out.println("Cliente deletado com sucesso!");
                System.out.println();
                naoTerminouDelete = false;
              } else if ((resposta.equals("N")) || (resposta.equals("n"))) {
                System.out.println("OK");
                System.out.println();
                naoTerminouDelete = false;
              } else {
                System.out.println("Escolha 'S' para sim ou 'N' para não:");
                System.out.println();
              }
            }
          } catch (Exception e) {
            System.err.println(e.getMessage());
          }
          break;
        case "4":
          aindaCliente = false;
          break;
        default:
          System.out.println("Por favor, escolha 1, 2, 3 ou 4.");

      }
    }

  }

}
