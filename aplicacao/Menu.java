package aplicacao;

import java.util.Scanner;

import model.Produto;
import repository.Repositorio;

public class Menu {
    private Repositorio rep = new Repositorio();
    private Scanner scan = new Scanner(System.in);
    private int opcao;

    public void loopPrincipal(){
        do {
            mostrarMenu();
            try {
                switch (opcao) {
                    case 1:
                        cadastrarProduto();
                        break;
    
                    case 2:
                        mostrarTodos();
                        break;
    
                    case 3:
                        BuscarProduto();
                        break;
    
                    case 4:
                        vendasPeriodo();
                        break;
    
                    case 5:
                        realizarVenda();
                        break;
                
                    default:
                        System.out.println("Opção inválida.");
                        voltarMenu();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                voltarMenu();
            }
        } while (opcao != 0);
    }
    
    public void mostrarMenu(){
        limpa();
        System.out.println("**** MENU ****");
        System.out.println("1- Cadastrar produto");
        System.out.println("2- Mostrar produtos cadastrados");
        System.out.println("3- Buscar por código");
        System.out.println("4- Vendas por periodo");
        System.out.println("5- Realizar venda");
        System.out.println("0- Sair");
        opcao = scan.nextInt(); scan.nextLine();
    }
    
    public void cadastrarProduto(){
        limpa();
        System.out.println("**** Tela de cadastro ****");
        System.out.println("Digite o código do produto: ");
        String codprod = scan.nextLine();
        System.out.println("Digite o nome do produto: ");
        String nomeprod = scan.nextLine();
        System.out.println("Digite o valor do produto: ");
        double valorprod = scan.nextDouble();
        System.out.println("Digite a quantidade do produto no estoque: ");
        int qtprod = scan.nextInt(); scan.nextLine();
        rep.adicionar(new Produto(codprod, nomeprod, valorprod, qtprod));
        System.out.println("Produto adicionada com sucesso.");
        voltarMenu();  
    }

    public void mostrarTodos(){
        limpa();
        System.out.println("**** Lista de produtos ****");
        System.out.println("Código  |   Nome Produto   |   Valor   | Quantidade |");
        rep.mostrarTodos();
        voltarMenu();
    }

    public void BuscarProduto(){
        limpa();
        System.out.println("**** Buscar por Código ****");
        System.out.println("Digite o código da produto que deseja buscar: ");
        String codigoBusca = scan.nextLine();
        Produto p = rep.buscarProduto(codigoBusca);
        System.out.println("Produto encontrada: " + p);
        voltarMenu();
    }

    public void vendasPeriodo(){
        rep.mostrarPeriodos();
        voltarMenu();
    }

    public void realizarVenda(){
        rep.fazerVen();
        voltarMenu();
    }
    public void voltarMenu(){
        System.out.println("Digite [ENTER] para voltar ao menu");
        scan.nextLine();
    }

    public void limpa(){
        System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
 
}
