package br.com.codar.inscricao;

import br.com.codar.inscricao.menus.MenuInicial;
import br.com.codar.inscricao.menus.SeletorMenu;

public class main {
    public static void main(String[] args) {

        SeletorMenu seletor = new SeletorMenu();
        MenuInicial menuInicial = new MenuInicial();

        while(seletor.isFuncionando()){
            menuInicial.mostrarMenu();

        }
    }
}
