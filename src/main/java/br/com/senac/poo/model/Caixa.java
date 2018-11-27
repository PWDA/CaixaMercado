package br.com.senac.poo.model;

public class Caixa {
    
    private double valorCaixa;
    private double valorTroco;
    private double valorTotalVenda;
    
        public Caixa(double valorCaixa, double valorTroco, double valorTotalVenda) {
        this.valorCaixa = valorCaixa;
        this.valorTroco = valorTroco;
        this.valorTotalVenda = valorTotalVenda;
    }

    public double getValorCaixa() {
        return valorCaixa;
    }

    public void setValorCaixa(double valorCaixa) {
        this.valorCaixa = valorCaixa;
    }

    public double getValorTroco() {
        return valorTroco;
    }

    public void setValorTroco(double valorTroco) {
        this.valorTroco = valorTroco;
    }

    public double getValorTotalVenda() {
        return valorTotalVenda;
    }

    public void setValorTotalVenda(double valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }

    public boolean caixaCheio(){
            
        boolean cheio = false;
        return cheio;
    }
    
    public boolean caixaVazio(){
            
        boolean vazio = true;
        return vazio;
    }
    
    public void consultarValorTotal(){
        
    }
}
