package model;
public class Dinheiro extends FormaPagamento {
    
    private double valorRecebido;
    
    public Dinheiro(int codVenda, double valor, double valorRecebido) {
        super(codVenda, valor);
    }

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }
    
}
