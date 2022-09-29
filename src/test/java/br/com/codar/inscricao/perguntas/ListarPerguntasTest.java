package br.com.codar.inscricao.perguntas;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListarPerguntasTest {
    private ListarPerguntas listar;

    @BeforeEach
    void beforeEach(){
        this.listar = new ListarPerguntas();
    }

    @Test
    void deveRetornarUmaListaComAsPerguntas(){
        List<String> listaDePerguntas = listar.getListaDePerguntas();

        assertEquals("P1|Qual o seu nome completo?", listaDePerguntas.get(0));
        assertEquals("P2|Qual seu e-mail?", listaDePerguntas.get(1));
        assertEquals("P3|Qual sua idade?", listaDePerguntas.get(2));

    }

}