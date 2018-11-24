package br.com.senac.poo.model;

import br.com.senac.poo.model.ItemVenda;
import br.com.senac.poo.model.Funcionario;
import java.util.Date;
import java.util.List;

public class Venda {
    
    private int codigoVenda;
    private Integer idCaixa;
    private List<ItemVenda> itens;
    private String formaPagamento;
    private double valorTotal;
    private Date dataVenda;        
    private Funcionario operador;        
    private double taxaJuros;

    public Venda(int codigoVenda, Integer idCaixa, List<ItemVenda> itens, String formaPagamento, double valorTotal, Date dataVenda, Funcionario operador, Double taxaJuros) {
        this.codigoVenda = codigoVenda;
        this.idCaixa = idCaixa;
        this.itens = itens;
        this.formaPagamento = formaPagamento;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.operador = operador;
        this.taxaJuros = taxaJuros;
    }

    public Venda() {
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public Integer getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(Integer idCaixa) {
        this.idCaixa = idCaixa;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Funcionario getOperador() {
        return operador;
    }

    public void setOperador(Funcionario operador) {
        this.operador = operador;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }
        
}
