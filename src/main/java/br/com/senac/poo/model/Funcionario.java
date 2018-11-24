package br.com.senac.poo.model;

import java.util.Date;

public class Funcionario extends Pessoa{
    
    private Integer registro;
    private String cargo;
    private Integer idLogin;

    public Funcionario(Integer registro, String cargo, Integer idLogin, Integer id, String nome, 
            int documento, int telefone, Date dataNascimento, String endereco, 
            String bairro, String cidade, String estado, int cep, String email, String sexo) {
        super(id, nome, documento, telefone, dataNascimento, endereco, bairro, 
                cidade, estado, cep, email, sexo);
        this.registro = registro;
        this.cargo = cargo;
        this.idLogin = idLogin;
    }

    public Funcionario() {
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
