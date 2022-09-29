package br.com.codar.inscricao.perguntas;

import br.com.codar.inscricao.io.EntradaTeclado;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;



class AdicionaPerguntaTest {

    @Mock
    private EntradaTeclado teclado;
    @Mock
    private ValidacaoPerguntasRepetidas validacao;
    @Mock
    private ListarPerguntas listarPerguntas;
    @Mock
    private SalvaPerguntas salvaPerguntas;

    private List<String> listaDePerguntas;

    @Captor
    private ArgumentCaptor<List<String>> captor;
    private AdicionaPergunta adicionaPergunta;

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.openMocks(this);

        this.adicionaPergunta = new AdicionaPergunta(teclado,validacao, listarPerguntas, salvaPerguntas);
        this.listaDePerguntas = CriaListaPerguntas.listarPerguntasTeste();
    }

    @AfterEach
    void afterEach(){

    }

    @Test
    void deveriaInserirUmaPerguntaNaLista() {
        String pergunta = "Inseri Essa pergunta agora";

        when(teclado.entradaAlfaNumerica()).thenReturn(pergunta);
        when(validacao.validarPergunta(pergunta)).thenReturn(true);
        when(listarPerguntas.getListaDePerguntas()).thenReturn(listaDePerguntas);

        adicionaPergunta.inserirPerguntaNoFormulario();

        Mockito.verify(salvaPerguntas).salvar(captor.capture());
        List<String> listaSalva = captor.getValue();

        assertEquals(listaDePerguntas.size() + 1, listaSalva.size());


    }

    @Test
    void naoDeveriaInserirUmaPerguntaNoFormularioPorqueDeuFalse() {
        String pergunta = "Inseri Essa pergunta agora";

        when(teclado.entradaAlfaNumerica()).thenReturn(pergunta);
        when(validacao.validarPergunta(pergunta)).thenReturn(false);
        when(listarPerguntas.getListaDePerguntas()).thenReturn(listaDePerguntas);

        adicionaPergunta.inserirPerguntaNoFormulario();

        Mockito.verify(salvaPerguntas, times(0)).salvar(captor.capture());





    }


}