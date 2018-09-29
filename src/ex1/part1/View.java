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
      System.out.println("0 - Sair da aplica��o");
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
            System.err.println("Este usu�rio j� existe!");
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
    System.out.println("Ol�, " + this.clienteAtivo.getNome() + "!");
    System.out.println();
    while (aindaCliente && this.aindaFuncionando) {
      System.out.println("Escolha com o que quer mexer agora:");
      System.out.println("1 - Locar um autom�vel!");
      System.out.println("2 - Devolver um autom�vel");
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
      System.out.println("Escolha uma das ag�ncias pelo seu c�digo de ag�ncia:\n");
      System.out.println(Locadora.toStringAgencias());
      escolhaAgencia = Integer.valueOf(scanner.nextLine()).intValue();
      agencia = Locadora.getAgencia(escolhaAgencia);
      System.out.println("Escolha um dos carros dispon�veis na ag�ncia:");
      for (String placa : agencia.getAutomoveisPlacas()) {
        automovel = Locadora.getAutomovel(placa);
        System.out.println(
            "\nPlaca: " + automovel.getNumeroDaPlaca() + "\nModelo: " + automovel.getDadosModelo());
      }
      escolhaPlaca = scanner.nextLine();

      System.out.println("Escolha entre: ");
      System.out.println("1 - Loca��o por di�ria\n2 - Loca��o por tempo");

      switch (scanner.nextLine()) {
        case "1":
          int dias;
          int agenciaDevolvida;
          System.out.println("Insira quantos dias voc� deseja nessa di�ria:");
          dias = Integer.valueOf(scanner.nextLine()).intValue();
          System.out.println("D� o c�digo da ag�ncia em que voc� vai devolver o autom�vel:");
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
      System.out.println("Informe a placa do autom�vel a ser devolvido:");
      placa = scanner.nextLine();
      if (Locadora.getAutomovel(placa).isLocado()) {
        System.out.println("Informe o c�digo da ag�ncia para qual voc� vai devolver o autom�vel:");
        System.out.println(Locadora.toStringAgencias());
        agenciaDevolver = Integer.valueOf(scanner.nextLine()).intValue();
        if (!Locadora.existeAgencia(agenciaDevolver)) {
          System.err.println("Escolha uma das ag�ncias apresentadas!");
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
      System.out.println("1 - Ver informa��es do cadastro");
      System.out.println("2 - Editar informa��es");
      System.out.println("3 - Deletar cadastro");
      System.out.println("4 - Voltar para controle");
      System.out.println();
      switch (scanner.nextLine()) {
        case "1":
          System.out.println(this.clienteAtivo.toString());
          break;
        case "2": // TODO
          System.out.println("Em constru��o!");
          /*
           * int cpf; String nome; String senha; ArrayList<String>
           * telefones = new ArrayList<>(); boolean maisTelefone =
           * true;
           * System.out.println("Digite as informa��es do cliente");
           * System.out.println("CPF (s� n�meros):");
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
            System.out.println("Voc� tem certeza de que voc� quer deletar seu cadastro?");
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
                System.out.println("Escolha 'S' para sim ou 'N' para n�o:");
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
    System.out.println("Ol�, admin!");
    System.out.println();
    while (aindaAdmin && this.aindaFuncionando) {
      System.out.println("Escolha com o que quer mexer agora:");
      System.out.println("1 - Ag�ncias");
      System.out.println("2 - Autom�veis");
      System.out.println("3 - Clientes");
      System.out.println("4 - Loca��es");
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
      System.out.println("1 - Procurar uma ag�ncia");
      System.out.println("2 - Adicionar uma ag�ncia");
      System.out.println("3 - Deletar uma ag�ncia");
      System.out.println("4 - Voltar para controle");
      System.out.println();
      switch (scanner.nextLine()) {
        case "1":
          try {
            System.out.println("Digite o c�dido da ag�ncia a ser procurada:");
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
          System.out.println("Digite as informa��es da ag�ncia");
          System.out.println("C�digo �nico da ag�ncia (s� n�meros):");
          System.out.println();
          codAgencia = Integer.valueOf(scanner.nextLine()).intValue();
          if (Locadora.existeAgencia(codAgencia)) {
            System.err.println("J� existe ag�ncia com esse c�digo! Cada c�digo deve ser �nico.");
            break;
          }
          System.out.println("Local:");
          System.out.println();
          local = scanner.nextLine();
          Agencia agencia = new Agencia(codAgencia, local);
          Locadora.addAgencia(agencia);
          System.out.println("Ag�ncia criada com sucesso!");
          System.out.println();
          break;
        case "3":
          int codigoDado;
          String resposta;
          boolean naoTerminouDelete = true;
          try {
            System.out.println("Digite o c�digo da ag�ncia a ser deletada:");
            System.out.println();
            codigoDado = Integer.valueOf(scanner.nextLine()).intValue();
            System.out.println("Voc� tem certeza de que voc� quer deletar essa ag�ncia?");
            System.out.println(Locadora.getAgencia(codigoDado).toString());
            System.out.println("[S|N]");
            System.out.println();
            while (naoTerminouDelete) {
              resposta = scanner.nextLine();
              if ((resposta.equals("S")) || (resposta.equals("s"))) {
                Locadora.deleteAgencia(codigoDado);
                System.out.println("Ag�ncia deletada com sucesso!");
                System.out.println();
                naoTerminouDelete = false;
              } else if ((resposta.equals("N")) || (resposta.equals("n"))) {
                System.out.println("OK");
                System.out.println();
                naoTerminouDelete = false;
              } else {
                System.out.println("Escolha 'S' para sim ou 'N' para n�o:");
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
      System.out.println("1 - Procurar um autom�vel");
      System.out.println("2 - Adicionar um autom�vel");
      System.out.println("3 - Deletar um autom�vel");
      System.out.println("4 - Voltar para controle");
      System.out.println();
      switch (scanner.nextLine()) {
        case "1":
          try {
            System.out.println("Digite a placa do autom�vel a ser procurado:");
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
          System.out.println("Digite as informa��es do autom�vel");
          System.out.println("Placa:");
          System.out.println();
          numeroDaPlaca = scanner.nextLine();
          System.out.println("Cor:");
          System.out.println();
          cor = scanner.nextLine();
          System.out.println("Ano:");
          System.out.println();
          ano = Integer.valueOf(scanner.nextLine()).intValue();
          System.out.println("Tipo de combust�vel:");
          System.out.println();
          tipoDeCombustivel = scanner.nextLine();
          System.out.println("Quilometragem:");
          System.out.println();
          quilometragem = Double.valueOf(scanner.nextLine()).doubleValue();
          System.out.println("Renavam (s� n�meros):");
          System.out.println();
          renavam = Integer.valueOf(scanner.nextLine()).intValue();
          System.out.println("Chassi:");
          System.out.println();
          chassi = scanner.nextLine();
          System.out.println("Valor de loca��o:");
          System.out.println();
          valorDeLocacao = Double.valueOf(scanner.nextLine()).doubleValue();
          System.out.println("Escolha um dos modelos:");
          for (int i = 0; i < _MainClass.modelos.size(); i++) {
            System.out.println((i + 1) + "- " + _MainClass.modelos.get(i).getNomeModelo());
          }
          escolha = Integer.valueOf(scanner.nextLine()).intValue();
          if (((escolha - 1) < 0) || (escolha > _MainClass.modelos.size())) {
            System.err.println("Escolha um n�mero dos dispostos para modelos!");
            break;
          }
          Modelo modelo = _MainClass.modelos.get(escolha - 1);
          Automovel automovel = new Automovel(numeroDaPlaca, cor, ano, tipoDeCombustivel,
              quilometragem, renavam, chassi, valorDeLocacao, modelo);
          Locadora.addAutomovel(automovel);
          System.out.println("Autom�vel criado com sucesso!");
          System.out.println();
          break;
        case "3":
          String placaDada;
          String resposta;
          boolean naoTerminouDelete = true;
          try {
            System.out.println("Digite a placa do autom�vel a ser deletado:");
            System.out.println();
            placaDada = scanner.nextLine();
            System.out.println("Voc� tem certeza de que voc� quer deletar esse autom�vel?");
            System.out.println(Locadora.getAutomovel(placaDada).toString());
            System.out.println("[S|N]");
            System.out.println();
            while (naoTerminouDelete) {
              resposta = scanner.nextLine();
              if ((resposta.equals("S")) || (resposta.equals("s"))) {
                Locadora.deleteAutomovel(placaDada);
                System.out.println("Autom�vel deletado com sucesso!");
                System.out.println();
                naoTerminouDelete = false;
              } else if ((resposta.equals("N")) || (resposta.equals("n"))) {
                System.out.println("OK");
                System.out.println();
                naoTerminouDelete = false;
              } else {
                System.out.println("Escolha 'S' para sim ou 'N' para n�o:");
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
          System.out.println("Digite as informa��es do cliente");
          System.out.println("CPF (s� n�meros):");
          System.out.println();
          cpf = Integer.valueOf(scanner.nextLine()).intValue();
          if (Locadora.existeCliente(cpf)) {
            System.err.println("Cliente com esse cpf j� existe!");
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
              System.err.println("N�o apague o admin do sistema!!!");
              break;
            }
            System.out.println("Voc� tem certeza de que voc� quer deletar esse cliente?");
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
                System.out.println("Escolha 'S' para sim ou 'N' para n�o:");
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
      System.out.println("1 - Procurar uma loca��o");
      System.out.println("2 - Voltar para controle");
      System.out.println();
      switch (scanner.nextLine()) {
        case "1":
          try {
            System.out.println("Digite o ID da loca��o a ser procurada:");
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
