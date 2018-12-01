package br.com.senac.poo.model;


public class CartaoDebito extends FormaPagamento{
    
    private double taxaJuros;
    
    public CartaoDebito(double valor, double taxaJuros) {
        super(valor);
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }
    
}
