package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Venda {
    

    private int quantVendida;
    private Produto produto;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate dataDeVenda;
    
    public Venda(int quantVendida, Produto produto, LocalDate dataDeVenda) {
        this.quantVendida = quantVendida;
        this.produto = produto;
        this.dataDeVenda = dataDeVenda;

    }

    
    
    public double Calcular() {
        return quantVendida * produto.getProdvalor();
    }
    
    public int getQuantVendida() {
        return quantVendida;
    }
    public void setQuantVendida(int quantVendida) {
        this.quantVendida = quantVendida;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public LocalDate getDataDeVenda() {
        return dataDeVenda;
    }
    public void setDataDeVenda(String dataDeVenda) {
        this.dataDeVenda =  LocalDate.parse(dataDeVenda, formatter);
    }
    public LocalDate setDataFinal() {
        return dataDeVenda;
    }
   
    @Override
    public String toString() {
        return "Venda [dataDeVenda=" + dataDeVenda + ", produto=" + produto + ", quantVendida=" + quantVendida + "]";
    } 
}
