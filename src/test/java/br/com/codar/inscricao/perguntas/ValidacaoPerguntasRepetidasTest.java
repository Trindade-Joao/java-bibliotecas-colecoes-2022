package br.com.codar.inscricao.perguntas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class ValidacaoPerguntasRepetidasTest {

    @Mock
    ListaPerguntas listaPerguntas;
    private ValidacaoPerguntasRepetidas validacao;
    private List<String> listaDePerguntas;
    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.openMocks(this);
        this.validacao = new ValidacaoPerguntasRepetidas(listaPerguntas);
        this.listaDePerguntas = listaPerguntasTeste();
    }

    @Test
    void deveriaRetornarTruePerguntaEDiferenteDeTodasASPerguntasDaLista(){
        when(listaPerguntas.getListaDePerguntas()).thenReturn(listaDePerguntas);
        assertTrue(validacao.validarPergunta("Qual sua Stack favorita?"));
    }

    @Test
    void deveriaRetornarTruePerguntaEDiferenteDeTodasASPerguntasDaListaComIndiceIgual(){
        when(listaPerguntas.getListaDePerguntas()).thenReturn(listaDePerguntas);
        assertTrue(validacao.validarPergunta("P1|Qual sua Stack favorita?"));
    }

    @Test
    public void deveriaRetornarFalsePeguntaIgualAUmaPerguntaDaLista(){
        when(listaPerguntas.getListaDePerguntas()).thenReturn(listaDePerguntas);
        assertFalse(validacao.validarPergunta("Qual o seu nome completo?"));

    }

    @Test
    public void deveriaRetornarFalsePeguntaIgualAUmaPerguntaDaListaComIndiceDiferente(){
        when(listaPerguntas.getListaDePerguntas()).thenReturn(listaDePerguntas);
        assertFalse(validacao.validarPergunta("P5|Qual o seu nome completo?"));

    }









    private List<String> listaPerguntasTeste(){
        List<String> listaPerguntas = new ArrayList<>();

        listaPerguntas.add("P1|Qual o seu nome completo?");
        listaPerguntas.add("P2|Qual seu e-mail?");
        listaPerguntas.add("P3|Qual sua idade?");
        listaPerguntas.add("P4|Qual seu whatsapp ou celular?");

        return listaPerguntas;
    }

}