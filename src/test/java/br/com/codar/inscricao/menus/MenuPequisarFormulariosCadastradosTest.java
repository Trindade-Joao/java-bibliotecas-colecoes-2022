package br.com.codar.inscricao.menus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuPequisarFormulariosCadastradosTest {
    private final ByteArrayOutputStream saida = new ByteArrayOutputStream();
    private MenuPequisarFormulariosCadastrados menuPequisarFormulariosCadastrados;

    @BeforeEach
    void beforeEach(){
        System.setOut(new PrintStream(saida));
        menuPequisarFormulariosCadastrados = new MenuPequisarFormulariosCadastrados();

    }

    @AfterEach
    void afterEach() throws IOException {
        saida.close();
    }

    @Test
    void deveriaImprimirNaTela(){
        menuPequisarFormulariosCadastrados.mostrarMenu();
        assertEquals("""
                ------------------------------------------
                |   PESQUISAR FORMULARIOS CADASTRADOS    |
                ------------------------------------------

                """, saida.toString());
    }

}