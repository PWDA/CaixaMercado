package model;

import java.util.ArrayList;
import java.util.Date;

public class Produto {
    
    private int cod;
    private String nomeProduto;

    public Produto(int cod, String nomeProduto, String precoProduto, String quantidadeProduto) {
        this.cod = cod;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantidadeProduto = quantidadeProduto;
    }
    private String precoProduto;
    private String quantidadeProduto;
    private Date data = new Date();
    private ArrayList<Produto> lista = new ArrayList();

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(String precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(String quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = new Date();
    }

    public ArrayList<Produto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Produto> lista) {
        this.lista = lista;
    }

    

}
