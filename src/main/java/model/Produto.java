package model;

import java.util.ArrayList;
import java.util.Date;

public class Produto {

    private int id;
    private String nomeProduto;
    private String precoProduto;
    private String quantidadeProduto;
    private Date data = new Date();
    private ArrayList<Produto> lista = new ArrayList();

    public Produto(int id, String nomeProduto, String precoProduto, String quantidadeProduto) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
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
    
    public ArrayList<Produto> cadastrarProduto(Produto produto){
        lista.add(produto);
        
        return lista;
    }

}
