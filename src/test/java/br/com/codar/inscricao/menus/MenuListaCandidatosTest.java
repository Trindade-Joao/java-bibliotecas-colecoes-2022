package br.com.codar.inscricao.menus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuListaCandidatosTest {
    private final ByteArrayOutputStream saida = new ByteArrayOutputStream();
    private MenuListaCandidatos menuListaCandidatos;

    @BeforeEach
    void beforeEach(){
        System.setOut(new PrintStream(saida));
        menuListaCandidatos = new MenuListaCandidatos();

    }

    @AfterEach
    void afterEach() throws IOException {
        saida.close();
    }

    @Test
    void deveriaImprimirNaTela(){
        menuListaCandidatos.mostrarMenu();
        assertEquals("""
                ------------------------------------------
                |           LISTAR CANDIDATOS            |
                ------------------------------------------
                | [1] Candidatos Agrupados por Idade     |
                | [2] Número de Candidatos por Idade     |
                ------------------------------------------
                
                """, saida.toString());
    }
}