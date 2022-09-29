package br.com.codar.inscricao.menus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuCadastroTest {
    private final ByteArrayOutputStream saida = new ByteArrayOutputStream();
    private MenuCadastro menuCadastro;

    @BeforeEach
    void beforeEach(){
        System.setOut(new PrintStream(saida));
        menuCadastro = new MenuCadastro();

    }

    @AfterEach
    void afterEach() throws IOException {
        saida.close();
    }

    @Test
    void deveriaImprimirNaTela(){
        menuCadastro.mostrarMenu();
        assertEquals("""
                ------------------------------------------
                |    CADASTRO DE NOVOS PARTICIPANTES     |
                ------------------------------------------

                """, saida.toString());
    }
}