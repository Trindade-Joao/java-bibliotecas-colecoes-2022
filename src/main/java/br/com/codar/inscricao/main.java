package br.com.codar.inscricao;

import br.com.codar.inscricao.io.EntradaTeclado;
import br.com.codar.inscricao.menus.MenuInicial;
import br.com.codar.inscricao.menus.SeletorMenu;

public class main {
    public static void main(String[] args) {

        EntradaTeclado teclado = new EntradaTeclado();
        SeletorMenu seletor = new SeletorMenu(teclado);
        MenuInicial menuInicial = new MenuInicial();

        while(seletor.isFuncionando()){
            menuInicial.mostrarMenu();
            seletor.selecaoMenu(teclado.entradaNumerica());
        }
        teclado.encerrarTeclado();
    }
}
