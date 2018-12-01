package br.com.senac.poo.model;

public class CartaoCredito extends FormaPagamento{
    
    private double taxaJuros;
    private int quantidadeParcelas;
    private double valorParcela;
    
    public CartaoCredito(double valor, double taxaJuros, int quantidadeParcelas, double valoParcelas) {
        super(valor);
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }
    
}
