package br.com.senac.poo.model;

public class ItemVenda {
    
    private Integer codigoItemVenda;
    private Produto produto;
    private Integer quantidade;
    private double valorUnitario;
    private Integer codigoVenda;

    public ItemVenda(Integer codigoItemVenda, Produto produto, Integer quantidade, double valorUnitario, Integer codigoVenda) {
        this.codigoItemVenda = codigoItemVenda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.codigoVenda = codigoVenda;
    }

    public ItemVenda() {
    }        

    public ItemVenda(Produto produto) {
        this.produto = produto;
    }

    public Integer getCodigoItemVenda() {
        return codigoItemVenda;
    }

    public void setCodigoItemVenda(Integer codigoItemVenda) {
        this.codigoItemVenda = codigoItemVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(Integer codigoVenda) {
        this.codigoVenda = codigoVenda;
    }        
    
}
