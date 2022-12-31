package repository;
import java.util.Scanner;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import model.Produto;
import model.Venda;

public class Repositorio{
    private Scanner scan = new Scanner(System.in);
    private List<Produto> produtos = new ArrayList<>();
    List<Venda> vendas = new ArrayList<>();
    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void adicionar(Produto produto){
        if (produtos.contains(produto)) {
            throw new InputMismatchException("Já existe uma produto cadastrada com esse código.");
        }
        produtos.add(produto);
        produtos.sort(null);
    }

    public void mostrarTodos(){
        verificarProdutosCadastradas(); 
        produtos.forEach(System.out::println);

    }
    public void mostrarPeriodos(){
        verificarVendasCadastradas();
                if (vendas.isEmpty()) {
                    System.out.println("\nAinda não foi realizada nenhuma venda.");
                }
                System.out.println("Data de inicio:");
                String dataInicial = scan.nextLine();
                System.out.println("Data final:");
                String dataFinal = scan.nextLine();

                List<Venda> filtrarVendas = vendas.stream().filter(p -> {
                    Venda v = (Venda)p;
                    return (v.getDataDeVenda().isEqual(LocalDate.parse(dataInicial, df)) || v.getDataDeVenda().isEqual(LocalDate.parse(dataFinal, df)))|| (v.getDataDeVenda().isBefore(LocalDate.parse(dataFinal, df)) && (v.getDataDeVenda().isAfter(LocalDate.parse(dataInicial, df))));
                }).collect(Collectors.toList());

                for (Venda f : filtrarVendas) {
                    System.out.printf("%-16.15s\t%-18.15s\t%-20.20s\t%-20.15s\t%-20.15s\n", "DATA", "NOME", "QUANTIDADE", "VALOR UNITARIO", "VALOR TOTAL");
                    System.out.println("----------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-16.15s\t%-18.15s\t%-20.20s\t%-20.15s\t%-20.15s\n", f.getDataDeVenda().format(df), f.getProduto().getProdnome(), f.getQuantVendida(), f.getProduto().getProdvalor(), f.Calcular());
                    System.out.println("----------------------------------------------------------------------------------------------------------------");
                    
                }
        }

    public Produto buscarProduto(String codigo){
        verificarProdutosCadastradas();
        for (Produto produto : produtos) {
            if (produto.getProdcod().equals(codigo)) {
                return produto;
            }
        } 
        throw new InputMismatchException("Não existe uma produto cadastrada com esse código.");
    }

    public void fazerVen(){
        for (Produto produto : produtos){
            System.out.println("Nome do produto:");
            String prod = scan.nextLine();
            if(produto.getProdnome().equals(prod)){
                System.out.println("Insira a data nesse formato - dd/mm/aaaa");
                String data = scan.nextLine();
                System.out.println("Quantidade:");
                int quantidade = scan.nextInt();
                scan.nextLine();
                if(produto.getProdqt() < quantidade){
                    System.out.println("Não há quantidade suficiente em estoque!");
                }else{
                    produto.removerQuant(quantidade);
                    vendas.add(new Venda(quantidade, produto, LocalDate.parse(data, df)));
                    System.out.println("----VENDA CONCLUIDA----");
                    continue;
                }
            }else{
                System.out.println("Não existe um produto cadastrado com esse nome!");
                continue;
            }
        }
    }

    private void verificarProdutosCadastradas(){
        if (produtos.isEmpty()) {
            throw new NullPointerException("Não contém nenhum produto cadastrado."); 
        }
    }
    private void verificarVendasCadastradas(){
        if (produtos.isEmpty()) {
            throw new NullPointerException("Não foi realizada nenhuma venda!"); 
        }
    }

}
