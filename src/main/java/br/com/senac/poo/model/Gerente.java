package br.com.senac.poo.model;

import java.util.Date;

public class Gerente extends Funcionario{
    private double salarioBonus;
    private Integer registro;
    private String cargo;
    private Integer idLogin;
    
//    public Gerente(double salarioBonus, int numeroRegistro, String nome, Date dataNascimento, int documento, String endereco, String bairro, int cep, String cidade, String estado, int telefone, char sexo) {
//        super(numeroRegistro, nome, dataNascimento, documento, endereco, bairro, cep, cidade, estado, telefone, sexo);
//    }

    public double getSalarioBonus() {
        return salarioBonus;
    }

    public void setSalarioBonus(double salarioBonus) {
        this.salarioBonus = salarioBonus;
    }

    public Integer getRegistro() {
        return registro;
    }

    public void setRegistro(Integer registro) {
        this.registro = registro;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }        
    
    public void abrirCaixa(){
        
    }
    
    public void reporCaixa(){
        
    }
    
    public void cancelarVenda(){
        
    }
    
    public void aplicarDesconto(){
        
    }
    
}
