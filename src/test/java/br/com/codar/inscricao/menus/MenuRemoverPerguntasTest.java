package br.com.codar.inscricao.menus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuRemoverPerguntasTest {
    private final ByteArrayOutputStream saida = new ByteArrayOutputStream();
    private MenuRemoverPerguntas menuRemoverPerguntas;

    @BeforeEach
    void beforeEach(){
        System.setOut(new PrintStream(saida));
        menuRemoverPerguntas = new MenuRemoverPerguntas();

    }

    @AfterEach
    void afterEach() throws IOException {
        saida.close();
    }

    @Test
    void deveriaImprimirNaTela(){
        menuRemoverPerguntas.mostrarMenu();
        assertEquals("""
                ------------------------------------------
                |             REMOVER PERGUNTA           |
                ------------------------------------------
                Selecione através do número, qual pergunta 
                deseja remover. As perguntas de 1 a 4 são 
                   padrão e não podem ser removidas.
                        
                """, saida.toString());
    }

}