package br.com.senac.poo.model;

import java.util.Date;

public class Gerente extends Funcionario{
    private double salarioBonus;
    
//    public Gerente(double salarioBonus, int numeroRegistro, String nome, Date dataNascimento, int documento, String endereco, String bairro, int cep, String cidade, String estado, int telefone, char sexo) {
//        super(numeroRegistro, nome, dataNascimento, documento, endereco, bairro, cep, cidade, estado, telefone, sexo);
//    }

    public double getSalarioBonus() {
        return salarioBonus;
    }

    public void setSalarioBonus(double salarioBonus) {
        this.salarioBonus = salarioBonus;
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
