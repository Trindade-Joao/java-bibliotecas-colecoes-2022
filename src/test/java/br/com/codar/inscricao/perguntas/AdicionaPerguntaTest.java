package br.com.codar.inscricao.perguntas;

import br.com.codar.inscricao.io.EntradaTeclado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;



class AdicionaPerguntaTest {

    @Mock
    private EntradaTeclado teclado;
    @Mock
    private ValidacaoPerguntasRepetidas validacao;
    @Mock
    private ListaPerguntas listaPerguntas;
    @Mock
    SalvaPerguntas salvaPerguntas;

    @Captor
    private ArgumentCaptor<List<String>> captor;
    private AdicionaPergunta adicionaPergunta;

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.openMocks(this);

        this.adicionaPergunta = new AdicionaPergunta(teclado,validacao, listaPerguntas, salvaPerguntas);
    }

    @Test
    void inserirPerguntaNoFormulario() {
        String pergunta = "Pergunta Teste?";

        when(teclado.entradaAlfaNumerica()).thenReturn(pergunta);
        when(validacao.validarPergunta(pergunta)).thenReturn(true);
        when(listaPerguntas.getListaDePerguntas()).thenReturn(CriaListaPerguntas.listarPerguntasTeste());

        adicionaPergunta.inserirPerguntaNoFormulario();

        Mockito.verify(salvaPerguntas).salvar(captor.capture());
        List<String> listaSalva = captor.getValue();

        assertEquals("P8|"+ pergunta, listaSalva.get(7));

    }


}