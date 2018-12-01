package br.com.senac.poo.model;

import java.io.Serializable;

public class Login implements Serializable{
    int id;
    int func;
    int autorizar;
    String login;
    String senha;
    String permissao;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFunc() {
        return func;
    }

    public void setFunc(int func) {
        this.func = func;
    }

    public int getAutorizar() {
        return autorizar;
    }

    public void setAutorizar(int autorizar) {
        this.autorizar = autorizar;
    }
    

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }    
        
}