package br.com.senac.poo.model;


public class Dinheiro extends FormaPagamento {
    
    private double valorRecebido;
        
    public Dinheiro(double valor, double valorRecebido) {
        super(valor);
    }

    public Dinheiro(double valor) {
        super(valor);
    }        

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }
    
    public double carcularTroco (double valorRecebido, double valorTotal){
        double troco;
        troco = valorTotal - valorRecebido;
        
        if(troco >= 0){
            return troco;
        }
        return -1;
    }         
    
}
