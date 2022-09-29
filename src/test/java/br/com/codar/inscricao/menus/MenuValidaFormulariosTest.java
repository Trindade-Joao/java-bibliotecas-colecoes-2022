package br.com.codar.inscricao.menus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuValidaFormulariosTest {
    private final ByteArrayOutputStream saida = new ByteArrayOutputStream();
    private MenuValidaFormularios menuValidaFormularios;

    @BeforeEach
    void beforeEach(){
        System.setOut(new PrintStream(saida));
        menuValidaFormularios = new MenuValidaFormularios();

    }

    @AfterEach
    void afterEach() throws IOException {
        saida.close();
    }

    @Test
    void deveriaImprimirNaTela(){
        menuValidaFormularios.mostrarMenu();
        assertEquals("""
                ------------------------------------------
                |        VALIDAR FORMULÁRIOS             |
                ------------------------------------------                
                """, saida.toString());
    }

}