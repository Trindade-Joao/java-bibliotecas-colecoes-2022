package br.com.codar.inscricao.perguntas;

import br.com.codar.inscricao.io.EntradaTeclado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class RemovePerguntaTest {
    private List<String> listaDePerguntas;
    private RemovePergunta removePergunta;

    @Mock
    private EntradaTeclado teclado;
    @Mock
    private SalvaPerguntas salvaPerguntas;
    @Mock
    private ListaPerguntas listaPerguntas;

    @Captor
    private ArgumentCaptor<List<String>> captor;

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.openMocks(this);
        this.removePergunta = new RemovePergunta(teclado, listaPerguntas,salvaPerguntas);
        this.listaDePerguntas = CriaListaPerguntas.listarPerguntasTeste();
    }

    @Test
    void deveriaRemoverAPergunta5(){

        when(teclado.entradaNumerica()).thenReturn(5);
        when(listaPerguntas.getListaDePerguntas()).thenReturn(listaDePerguntas);

        removePergunta.remover();
        verify(salvaPerguntas).salvar(captor.capture());

        List<String> listaCapturada = captor.getValue();

        assertEquals(6, listaCapturada.size());
        assertEquals("P5|Aqui era a pergunta 6?", listaCapturada.get(4));

    }

    @Test
    void naoDeveriaRemoverNenhumaPergunta(){

        when(teclado.entradaNumerica()).thenReturn(4);
        when(listaPerguntas.getListaDePerguntas()).thenReturn(listaDePerguntas);

        removePergunta.remover();
        verify(salvaPerguntas).salvar(captor.capture());

        List<String> listaCapturada = captor.getValue();

        assertEquals(7, listaCapturada.size());
        assertEquals("P4|Qual seu whatsapp ou celular?", listaCapturada.get(3));
    }

    @Test
    void naoDeveriaRemoverNenhumaPerguntaPoisONumeroEMaiorQueALista(){

        when(teclado.entradaNumerica()).thenReturn(8);
        when(listaPerguntas.getListaDePerguntas()).thenReturn(listaDePerguntas);

        removePergunta.remover();
        verify(salvaPerguntas).salvar(captor.capture());

        List<String> listaCapturada = captor.getValue();

        assertEquals(7, listaCapturada.size());
        assertEquals("P7|Aqui era a pergunta 7?", listaCapturada.get(6));

    }




}