package br.com.codar.inscricao.perguntas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TratamentoPerguntasTest {

    private TratamentoPerguntas tratamento;


    @Test
    void deveriaRetornarAPerguntaSemCaracteresEspeciaisSemEspacoEUpperCase(){
        tratamento = new TratamentoPerguntas();
        String perguntaTratada = tratamento.tratar("P1|Qual o seu nome completo?");

        assertEquals("QUALOSEUNOMECOMPLETO", perguntaTratada);
    }



}