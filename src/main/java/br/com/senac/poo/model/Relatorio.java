package br.com.senac.poo.model;

public class Relatorio {

    private String caixa;
    private int codigo;
    private String produto;
    private int qtdComprado;
    private float valorUnitario;
    private float valorTotal;
    private String dataCompra;
    private float totFaturado;

    public String getCaixa() {
        return caixa;
    }

    public void setCaixa(String caixa) {
        this.caixa = caixa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQtdComprado() {
        return qtdComprado;
    }

    public void setQtdComprado(int qtdComprado) {
        this.qtdComprado = qtdComprado;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public float getTotFaturado() {
        return totFaturado;
    }

    public void setTotFaturado(float totFaturado) {
        this.totFaturado = totFaturado;
    }
    
}
