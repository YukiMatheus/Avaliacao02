package model;

public class Produto implements Comparable<Produto>{
    private String prodcod;
    private String prodnome;
    private double prodvalor;
    private int prodqt;

    public Produto(String prodcod, String prodnome, double prodvalor, int prodqt){
        this.prodcod = prodcod;
        this.prodnome = prodnome;
        this.prodvalor = prodvalor;
        this.prodqt = prodqt;
    }

    public void removerQuant(int quant) {
        prodqt -= quant;
    }

    public String getProdcod(){
        return prodcod;
    }

    public void setProdcod(String prodcod){
        this.prodcod = prodcod;
    }

    public String getProdnome(){
        return prodnome;
    }

    public void setProdnome(String prodnome) {
        this.prodnome = prodnome;
    }

    public double getProdvalor(){
        return prodvalor;
    }

    public void setProdqt(Double prodvalor){
        this.prodvalor = prodvalor;
    }

    public int getProdqt(){
        return prodqt;
    }

    public void setProdqt(int prodqt) {
        this.prodqt = prodqt;
    }


    @Override
    public String toString() {
        return String.format("%s           %s          R$%.2f    %d", getProdcod(), getProdnome(), getProdvalor(), getProdqt());
    }

    @Override
    public int compareTo(Produto o) {
        return 0;
    }

}