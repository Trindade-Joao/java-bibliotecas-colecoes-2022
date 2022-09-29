package br.com.codar.inscricao.formulario;

import br.com.codar.inscricao.io.EntradaTeclado;
import br.com.codar.inscricao.perguntas.CriaListaPerguntas;
import br.com.codar.inscricao.perguntas.ListarPerguntas;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
class RespondeFormularioTest {
    private final ByteArrayOutputStream saida = new ByteArrayOutputStream();

    private List<String> listaDePerguntas;
    @InjectMocks
    private RespondeFormulario respondeFormulario;

    @Mock
    private ListarPerguntas listarPerguntas;
    @Mock
    private EntradaTeclado teclado;

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.openMocks(this);
        System.setOut(new PrintStream(saida));

        this.respondeFormulario = new RespondeFormulario(listarPerguntas, teclado);
        this.listaDePerguntas = CriaListaPerguntas.listarPerguntasTeste();
    }

    @AfterEach
    void afterEach() throws IOException {
        saida.close();
    }

    @Test
    void responder(){
        when(listarPerguntas.getListaDePerguntas()).thenReturn(listaDePerguntas);
        when(teclado.entradaAlfaNumerica()).thenReturn("teste");

        List<String> respostas = respondeFormulario.responder();


        assertEquals(listaDePerguntas.size(), respostas.size());
        assertEquals("teste", respostas.get(0));

    }


}