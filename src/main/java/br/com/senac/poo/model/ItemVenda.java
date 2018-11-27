package br.com.senac.poo.model;

public class ItemVenda {
    
    private int codigoItemVenda;
    private Produto produto;         
    private double valorUnitario;
    private int codigoVenda;
    private int codigoProd;
    private int qtd;

    public ItemVenda(){        
        this.codigoItemVenda = 0;        
        this.valorUnitario = 0.0;
        this.codigoVenda = 0;
        this.codigoProd = 0;
    }

//    public ItemVenda(Produto produto) {
//        this.produto = produto;
//    }

    public int getCodigoItemVenda() {
        return codigoItemVenda;
    }

    public void setCodigoItemVenda(int codigoItemVenda) {
        this.codigoItemVenda = codigoItemVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }        

    public int getCodigoProd() {
        return codigoProd;
    }

    public void setCodigoProd(int codigoProd) {
        this.codigoProd = codigoProd;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
}
