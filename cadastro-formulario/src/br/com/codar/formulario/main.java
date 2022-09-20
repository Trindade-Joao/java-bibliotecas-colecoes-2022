package br.com.codar.formulario;

import br.com.codar.formulario.menus.MenuInicial;

public class main {
    public static void main(String[] args) {

        MenuInicial menuInicial = new MenuInicial();

        while(menuInicial.isFuncionando()){
            menuInicial.mostrarMenuInicial();
            menuInicial.selecaoMenu();
        }
    }
}
