package br.com.senac.poo.model;
public class FormaPagamento {
    
    private int codVenda;
    private double valor;
    
     public FormaPagamento(int codVenda, double valor) {
        this.codVenda = codVenda;
        this.valor = valor;
    }
     
    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void pagar(){
        
    }

}
