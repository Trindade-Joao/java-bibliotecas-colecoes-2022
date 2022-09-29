package br.com.codar.inscricao.menus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuAdicionarPerguntasTest {
    private final ByteArrayOutputStream saida = new ByteArrayOutputStream();
    private MenuAdicionarPerguntas menuAdicionarPerguntas;

    @BeforeEach
    void beforeEach(){
        System.setOut(new PrintStream(saida));
        menuAdicionarPerguntas = new MenuAdicionarPerguntas();

    }

    @AfterEach
    void afterEach() throws IOException {
        saida.close();
    }

    @Test
    void deveriaImprimirNaTela(){
        menuAdicionarPerguntas.mostrarMenu();
        assertEquals("""
                ------------------------------------------
                |         ADICIONAR PERGUNTA             |
                ------------------------------------------
                
                Adicione uma nova Pergunta
                => """, saida.toString());
    }

}