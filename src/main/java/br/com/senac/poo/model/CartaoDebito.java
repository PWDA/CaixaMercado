package br.com.senac.poo.model;
public class CartaoDebito extends FormaPagamento{
    
    private double taxaJuros;
    
    public CartaoDebito(int codVenda, double valor, double taxaJuros) {
        super(codVenda, valor);
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }
    
}
