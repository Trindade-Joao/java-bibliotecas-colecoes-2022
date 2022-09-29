package br.com.codar.inscricao.formulario;

import br.com.codar.inscricao.io.EntradaTeclado;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PesquisaFormularioTest {

    private PesquisaFormulario pesquisaFormulario;

    @Mock
    private EntradaTeclado teclado;

    private ByteArrayOutputStream saida;

    private List<Inscricoes> listaDeInscricoes;
    private CriaListaInscricoes criaLista;

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.openMocks(this);
        this.criaLista = new CriaListaInscricoes();
        this.saida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saida));
        this.pesquisaFormulario = new PesquisaFormulario(teclado);
        this.listaDeInscricoes = criaLista.criarSemRepeticao();
    }

    @AfterEach
    void afterEach() throws IOException {
        saida.close();
    }

    @Test
    void deveriaRetornarONomeDosCadastrosPesquisados(){
        String nome = "Fulano da Silva";
        String email = "fulano@gmail.com";

        when(teclado.entradaAlfaNumerica()).thenReturn(nome, email);
        List<String> listaPesquisa = pesquisaFormulario.pesquisar(listaDeInscricoes);

        assertEquals(1, listaPesquisa.size());
        assertEquals("1-FULANODASILVA.txt", listaPesquisa.get(0));

    }

    @Test
    void naoDeveriaRetornarNadaPorqueONomeEstaIncorreto(){
        String nome = "Fulano de Souza";
        String email = "fulano@gmail.com";

        when(teclado.entradaAlfaNumerica()).thenReturn(nome, email);
        List<String> listaPesquisa = pesquisaFormulario.pesquisar(listaDeInscricoes);

        assertEquals(0, listaPesquisa.size());

    }

    @Test
    void naoDeveriaRetornarNadaPorqueOEmailEstaIncorreto(){
        String nome = "Fulano da Silva";
        String email = "fulano@gmail.com.br";

        when(teclado.entradaAlfaNumerica()).thenReturn(nome, email);
        List<String> listaPesquisa = pesquisaFormulario.pesquisar(listaDeInscricoes);

        assertEquals(0, listaPesquisa.size());

    }


}