package ex1.part1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class View {

  private static View instancia;
  private boolean aindaFuncionando;
  private boolean aindaCliente;
  private Cliente clienteAtivo;

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
      if (this.clienteAtivo != null && aindaFuncionando == true) {
        if (this.clienteAtivo.getCpf() == _MainClass.CPF_ADMIN) {
          this.adminControle();
        } else {
          this.clienteControle();
        }
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
      int cpfDado;
      String nomeDado;
      String senhaDada;
      ArrayList<String> telefonesDados = new ArrayList<>();
      Cliente cliente;
      switch (scanner.nextLine()) {
        case "1":
          boolean maisTelefone = true;
          System.out.println("CPF: ");
          cpfDado = Integer.valueOf(scanner.nextLine()).intValue();
          if (Locadora.existeCliente(cpfDado)) {
            System.err.println("Este usuário já existe!");
            break;
          }
          System.out.println("Senha: ");
          senhaDada = scanner.nextLine();
          System.out.println("Nome: ");
          nomeDado = scanner.nextLine();
          System.out.println(
              "Telefones (mande quantos telefones quiser e aperte Enter com uma entrada vazia para terminar):");
          while (maisTelefone) {
            String telefone = scanner.nextLine();
            if (telefone.isEmpty()) {
              maisTelefone = false;
            } else {
              telefonesDados.add(telefone);
            }
          }
          cliente = new Cliente(cpfDado, senhaDada, nomeDado, telefonesDados);
          Locadora.addCliente(cliente);
          this.clienteAtivo = cliente;
          notLoggedIn = false;
          break;
        case "2":
          System.out.println("CPF: ");
          cpfDado = Integer.valueOf(scanner.nextLine()).intValue();
          System.out.println("Senha: ");
          senhaDada = scanner.nextLine();
          try {
            cliente = Locadora.getCliente(cpfDado);
            if (!cliente.getSenha().equals(senhaDada)) {
              System.err.println("Senha incorreta!");
            } else {
              this.clienteAtivo = cliente;
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

  private void clienteControle() {
    Scanner scanner = new Scanner(System.in);
    aindaCliente = true;
    System.out.println("Olá, " + this.clienteAtivo.getNome() + "!");
    System.out.println();
    while (aindaCliente && this.aindaFuncionando) {
      System.out.println("Escolha com o que quer mexer agora:");
      System.out.println("1 - Locar um automóvel!");
      System.out.println("2 - Devolver um automóvel");
      System.out.println("3 - Mexer com o cadastro");
      System.out.println("4 - Voltar para login");
      System.out.println("0 - Sair");
      System.out.println();
      switch (scanner.nextLine()) {
        case "1":
          this.clienteLocacao();
          break;
        case "2":
          this.clienteDevolucao();
          break;
        case "3":
          this.clienteCadastro();
          break;
        case "4":
          this.clienteAtivo = null;
          aindaCliente = false;
          break;
        case "0":
          this.aindaFuncionando = false;
          break;
        default:
          System.out.println("Por favor, escolha 1, 2, 3, 4 ou 0.");
      }
    }
  }

  private void clienteLocacao() {

    Scanner scanner = new Scanner(System.in);
    int escolhaAgencia;
    String escolhaPlaca;
    Agencia agencia;
    Automovel automovel;
    Locacao locacao;
    try {
      System.out.println("Escolha uma das agências pelo seu código de agência:\n");
      System.out.println(Locadora.toStringAgencias());
      escolhaAgencia = Integer.valueOf(scanner.nextLine()).intValue();
      agencia = Locadora.getAgencia(escolhaAgencia);
      System.out.println("Escolha um dos carros disponíveis na agência:");
      for (String placa : agencia.getAutomoveisPlacas()) {
        automovel = Locadora.getAutomovel(placa);
        System.out.println(
            "\nPlaca: " + automovel.getNumeroDaPlaca() + "\nModelo: " + automovel.getDadosModelo());
      }
      escolhaPlaca = scanner.nextLine();

      System.out.println("Escolha entre: ");
      System.out.println("1 - Locação por diária\n2 - Locação por tempo");

      switch (scanner.nextLine()) {
        case "1":
          int dias;
          int agenciaDevolvida;
          System.out.println("Insira quantos dias você deseja nessa diária:");
          dias = Integer.valueOf(scanner.nextLine()).intValue();
          System.out.println("Dê o código da agência em que você vai devolver o automóvel:");
          agenciaDevolvida = Integer.valueOf(scanner.nextLine()).intValue();
          locacao = new Locacao(dias, escolhaAgencia, agenciaDevolvida, this.clienteAtivo.getCpf(),
              Locacao.LOCACAO_DIARIA, escolhaPlaca);
          Locadora.getAgencia(escolhaAgencia).tiraAutomovel(escolhaPlaca);
          Locadora.getAgencia(agenciaDevolvida).adicionaAutomovel(escolhaPlaca);
          Locadora.addLocacao(locacao);
          break;
        case "2":
          locacao = new Locacao(escolhaAgencia, this.clienteAtivo.getCpf(), Locacao.LOCACAO_TEMPO,
              escolhaPlaca);
          Locadora.getAutomovel(escolhaPlaca).setLocado(true);
          Locadora.getAgencia(escolhaAgencia).tiraAutomovel(escolhaPlaca);
          Locadora.addLocacao(locacao);
          break;
        default:
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  private void clienteDevolucao() {
    Scanner scanner = new Scanner(System.in);
    String placa;
    Locacao locacao;
    int agenciaDevolver;
    try {
      System.out.println("Informe a placa do automóvel a ser devolvido:");
      placa = scanner.nextLine();
      if (Locadora.getAutomovel(placa).isLocado()) {
        System.out.println("Informe o código da agência para qual você vai devolver o automóvel:");
        System.out.println(Locadora.toStringAgencias());
        agenciaDevolver = Integer.valueOf(scanner.nextLine()).intValue();
        if (!Locadora.existeAgencia(agenciaDevolver)) {
          System.err.println("Escolha uma das agências apresentadas!");
        } else {
          locacao = Locadora.getUltimaLocacaoNoCpfDoAutomovel(this.clienteAtivo.getCpf(), placa);
          locacao.setDataHoraDevolvido(LocalDateTime.now());
          Locadora.getAutomovel(placa).setLocado(false);
          locacao.setAgenciaDevolvida(agenciaDevolver);
        }
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  private void clienteCadastro() {

    Scanner scanner = new Scanner(System.in);
    boolean aindaCadastro = true;

    while (aindaCadastro) {
      System.out.println();
      System.out.println("1 - Ver informações do cadastro");
      System.out.println("2 - Editar informações");
      System.out.println("3 - Deletar cadastro");
      System.out.println("4 - Voltar para controle");
      System.out.println();
      switch (scanner.nextLine()) {
        case "1":
          System.out.println(this.clienteAtivo.toString());
          break;
        case "2": // TODO
          System.out.println("Em construção!");
          /*
           * int cpf; String nome; String senha; ArrayList<String>
           * telefones = new ArrayList<>(); boolean maisTelefone =
           * true;
           * System.out.println("Digite as informações do cliente");
           * System.out.println("CPF (só números):");
           * System.out.println(); cpf =
           * Integer.valueOf(scanner.nextLine()).intValue();
           * System.out.println("Senha:"); System.out.println(); senha
           * = scanner.nextLine(); System.out.println("Nome:");
           * System.out.println(); nome = scanner.nextLine();
           * System.out.println(
           * "Telefones (mande quantos telefones quiser e aperte Enter com uma entrada vazia para terminar):"
           * ); while (maisTelefone) { String telefone =
           * scanner.nextLine(); if (telefone.isEmpty()) {
           * maisTelefone = false; } else { telefones.add(telefone); }
           * } Cliente cliente = new Cliente(cpf, senha, nome,
           * telefones); Locadora.addCliente(cliente);
           * System.out.println("Cliente criado com sucesso!");
           * System.out.println();
           */
          break;
        case "3":
          String resposta;
          boolean naoTerminouDelete = true;
          try {
            System.out.println("Você tem certeza de que você quer deletar seu cadastro?");
            System.out.println(this.clienteAtivo.toString());
            System.out.println("[S|N]");
            System.out.println();
            while (naoTerminouDelete) {
              resposta = scanner.nextLine();
              if ((resposta.equals("S")) || (resposta.equals("s"))) {
                Locadora.deleteCliente(this.clienteAtivo.getCpf());
                System.out.println("Cliente deletado com sucesso!");
                System.out.println();
                naoTerminouDelete = false;
                aindaCadastro = false;
                aindaCliente = false;
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
          aindaCadastro = false;
          break;
        default:
          System.out.println("Por favor, escolha 1, 2, 3 ou 4.");

      }
    }
  }

  private void adminControle() {
    Scanner scanner = new Scanner(System.in);
    boolean aindaAdmin = true;
    System.out.println("Olá, admin!");
    System.out.println();
    while (aindaAdmin && this.aindaFuncionando) {
      System.out.println("Escolha com o que quer mexer agora:");
      System.out.println("1 - Agências");
      System.out.println("2 - Automóveis");
      System.out.println("3 - Clientes");
      System.out.println("4 - Locações");
      System.out.println("5 - Voltar para login");
      System.out.println("0 - Sair");
      System.out.println();
      switch (scanner.nextLine()) {
        case "1":
          this.adminAgencia();
          break;
        case "2":
          this.adminAutomovel();
          break;
        case "3":
          this.adminCliente();
          break;
        case "4":
          this.adminLocacao();
          break;
        case "5":
          this.clienteAtivo = null;
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

  private void adminAgencia() {
    Scanner scanner = new Scanner(System.in);
    boolean aindaAgencia = true;

    while (aindaAgencia) {
      System.out.println();
      System.out.println("1 - Procurar uma agência");
      System.out.println("2 - Adicionar uma agência");
      System.out.println("3 - Deletar uma agência");
      System.out.println("4 - Voltar para controle");
      System.out.println();
      switch (scanner.nextLine()) {
        case "1":
          try {
            System.out.println("Digite o códido da agência a ser procurada:");
            System.out.println();
            System.out.println(
                Locadora.getAgencia(Integer.valueOf(scanner.nextLine()).intValue()).toString());
          } catch (Exception e) {
            System.err.println(e.getMessage());
          }
          break;
        case "2":
          int codAgencia;
          String local;
          System.out.println("Digite as informações da agência");
          System.out.println("Código único da agência (só números):");
          System.out.println();
          codAgencia = Integer.valueOf(scanner.nextLine()).intValue();
          if (Locadora.existeAgencia(codAgencia)) {
            System.err.println("Já existe agência com esse código! Cada código deve ser único.");
            break;
          }
          System.out.println("Local:");
          System.out.println();
          local = scanner.nextLine();
          Agencia agencia = new Agencia(codAgencia, local);
          Locadora.addAgencia(agencia);
          System.out.println("Agência criada com sucesso!");
          System.out.println();
          break;
        case "3":
          int codigoDado;
          String resposta;
          boolean naoTerminouDelete = true;
          try {
            System.out.println("Digite o código da agência a ser deletada:");
            System.out.println();
            codigoDado = Integer.valueOf(scanner.nextLine()).intValue();
            System.out.println("Você tem certeza de que você quer deletar essa agência?");
            System.out.println(Locadora.getAgencia(codigoDado).toString());
            System.out.println("[S|N]");
            System.out.println();
            while (naoTerminouDelete) {
              resposta = scanner.nextLine();
              if ((resposta.equals("S")) || (resposta.equals("s"))) {
                Locadora.deleteAgencia(codigoDado);
                System.out.println("Agência deletada com sucesso!");
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
          aindaAgencia = false;
          break;
        default:
          System.out.println("Por favor, escolha 1, 2, 3 ou 4.");

      }
    }

  }

  private void adminAutomovel() {
    Scanner scanner = new Scanner(System.in);
    boolean aindaAutomovel = true;

    while (aindaAutomovel) {
      System.out.println();
      System.out.println("1 - Procurar um automóvel");
      System.out.println("2 - Adicionar um automóvel");
      System.out.println("3 - Deletar um automóvel");
      System.out.println("4 - Voltar para controle");
      System.out.println();
      switch (scanner.nextLine()) {
        case "1":
          try {
            System.out.println("Digite a placa do automóvel a ser procurado:");
            System.out.println();
            System.out.println(Locadora.getAutomovel(scanner.nextLine()).toString());
          } catch (Exception e) {
            System.err.println(e.getMessage());
          }
          break;
        case "2":
          int escolha;
          String numeroDaPlaca;
          String cor;
          int ano;
          String tipoDeCombustivel;
          double quilometragem;
          int renavam;
          String chassi;
          double valorDeLocacao;
          System.out.println("Digite as informações do automóvel");
          System.out.println("Placa:");
          System.out.println();
          numeroDaPlaca = scanner.nextLine();
          System.out.println("Cor:");
          System.out.println();
          cor = scanner.nextLine();
          System.out.println("Ano:");
          System.out.println();
          ano = Integer.valueOf(scanner.nextLine()).intValue();
          System.out.println("Tipo de combustível:");
          System.out.println();
          tipoDeCombustivel = scanner.nextLine();
          System.out.println("Quilometragem:");
          System.out.println();
          quilometragem = Double.valueOf(scanner.nextLine()).doubleValue();
          System.out.println("Renavam (só números):");
          System.out.println();
          renavam = Integer.valueOf(scanner.nextLine()).intValue();
          System.out.println("Chassi:");
          System.out.println();
          chassi = scanner.nextLine();
          System.out.println("Valor de locação:");
          System.out.println();
          valorDeLocacao = Double.valueOf(scanner.nextLine()).doubleValue();
          System.out.println("Escolha um dos modelos:");
          for (int i = 0; i < _MainClass.modelos.size(); i++) {
            System.out.println((i + 1) + "- " + _MainClass.modelos.get(i).getNomeModelo());
          }
          escolha = Integer.valueOf(scanner.nextLine()).intValue();
          if (((escolha - 1) < 0) || (escolha > _MainClass.modelos.size())) {
            System.err.println("Escolha um número dos dispostos para modelos!");
            break;
          }
          Modelo modelo = _MainClass.modelos.get(escolha - 1);
          Automovel automovel = new Automovel(numeroDaPlaca, cor, ano, tipoDeCombustivel,
              quilometragem, renavam, chassi, valorDeLocacao, modelo);
          Locadora.addAutomovel(automovel);
          System.out.println("Automóvel criado com sucesso!");
          System.out.println();
          break;
        case "3":
          String placaDada;
          String resposta;
          boolean naoTerminouDelete = true;
          try {
            System.out.println("Digite a placa do automóvel a ser deletado:");
            System.out.println();
            placaDada = scanner.nextLine();
            System.out.println("Você tem certeza de que você quer deletar esse automóvel?");
            System.out.println(Locadora.getAutomovel(placaDada).toString());
            System.out.println("[S|N]");
            System.out.println();
            while (naoTerminouDelete) {
              resposta = scanner.nextLine();
              if ((resposta.equals("S")) || (resposta.equals("s"))) {
                Locadora.deleteAutomovel(placaDada);
                System.out.println("Automóvel deletado com sucesso!");
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
          aindaAutomovel = false;
          break;
        default:
          System.out.println("Por favor, escolha 1, 2, 3 ou 4.");

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
          if (Locadora.existeCliente(cpf)) {
            System.err.println("Cliente com esse cpf já existe!");
            break;
          }
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
            if (cpfDado == _MainClass.CPF_ADMIN) {
              System.err.println("Não apague o admin do sistema!!!");
              break;
            }
            System.out.println("Você tem certeza de que você quer deletar esse cliente?");
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

  private void adminLocacao() {
    Scanner scanner = new Scanner(System.in);
    boolean aindaLocacao = true;

    while (aindaLocacao) {
      System.out.println();
      System.out.println("1 - Procurar uma locação");
      System.out.println("2 - Voltar para controle");
      System.out.println();
      switch (scanner.nextLine()) {
        case "1":
          try {
            System.out.println("Digite o ID da locação a ser procurada:");
            System.out.println();
            System.out.println(
                Locadora.getLocacao(Integer.valueOf(scanner.nextLine()).intValue()).toString());
          } catch (Exception e) {
            System.err.println(e.getMessage());
          }
          break;
        case "2":
          aindaLocacao = false;
          break;
        default:
          System.out.println("Por favor, escolha 1 ou 2.");

      }
    }

  }

}
