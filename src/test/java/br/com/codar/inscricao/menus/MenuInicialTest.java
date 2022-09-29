package br.com.codar.inscricao.menus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuInicialTest {

    private MenuInicial menuInicial;
    private ByteArrayOutputStream saida;

    @BeforeEach
    void beforeEach(){
        this.saida = new ByteArrayOutputStream();
        this.menuInicial = new MenuInicial();
        System.setOut(new PrintStream(saida));
    }

    @AfterEach
    void afterEach() throws IOException {
        saida.close();
    }

    @Test
    void deveriaImprimirMenuNaTela(){
        menuInicial.mostrarMenu();
        assertEquals("""
                ------------------------------------------
                |              MENU INICIAL              |
                ------------------------------------------
                | [1] Candidatar-se                      |
                | [2] Adicionar Pergunta Ao Formulário   |
                | [3] Remover Pergunta do Formulário     |
                | [4] Lista de Formulários Cadastrados   |
                | [5] Pesquisar Formulários Cadastrados  |
                | [6] Validar Formulários                |
                | [7] Sair                               |
                ------------------------------------------                                
                """, saida.toString());
    }


}