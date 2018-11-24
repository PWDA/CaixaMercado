package br.com.senac.poo.model;
public class FormaPagamento {
        
    private double valorTotal;
    
     public FormaPagamento(double valorTotal) {        
        this.valorTotal = valorTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void pagar(){
        
    }

}
