package br.com.senac.poo.validador;

import br.com.senac.poo.model.Login;

public class Comuns {
     private static Login usuarioLogado;

    public static Login getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Login usuarioLogado) {
        Comuns.usuarioLogado = usuarioLogado;
    }
     
     
}
