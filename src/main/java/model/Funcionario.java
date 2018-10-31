package model;

import java.util.Date;

public class Funcionario {
    
    private int numeroRegistro;
    private String nome;
    private Date dataNascimento;
    private int documento;
    private String endereco;
    private String bairro;
    private int cep;
    private String cidade;
    private String estado;
    private int telefone;
    private char sexo;
    
    public Funcionario(int numeroRegistro, String nome, Date dataNascimento, int documento, String endereco, String bairro, int cep, String cidade, String estado, int telefone, char sexo) {
        this.numeroRegistro = numeroRegistro;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.documento = documento;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.sexo = sexo;
    }
    
    
    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    public void realizarVenda(){
        
    }
    
    public void verificarTroco(){
        
    }
    
    public double consultarPreco(){
        
        double troco = 0;
        
        return troco;
    }
    
    public void fecharCaixa(){
        
    }
    
}
