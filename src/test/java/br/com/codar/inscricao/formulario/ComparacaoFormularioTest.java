package br.com.codar.inscricao.formulario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComparacaoFormularioTest {


    private List<Inscricoes> listaDeInscricoes;
    private ComparacaoFormulario comparacaoFormulario;

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.openMocks(this);
        this.comparacaoFormulario = new ComparacaoFormulario();
        this.listaDeInscricoes = ListaFomulariosRespondidosTeste.criar();
    }

    @Test
    void deveriaRetornarUmaListaComOsFormulariosEncontrados(){
        String nomeInscrito = "Fulano da Silva";
        String emailInscrito = "fulano@gmail.com";
        List<String> listaEncontrada = comparacaoFormulario.comparar(listaDeInscricoes, nomeInscrito, emailInscrito);

        assertEquals(2, listaEncontrada.size());
        assertEquals("1-FULANODASILVA.txt", listaEncontrada.get(0));
        assertEquals("3-FULANODASILVA.txt", listaEncontrada.get(1));
    }

    @Test
    void deveriaRetornarUmaListaVaziaPoisONomeNaoSeEncontraCadastrado(){
        String nomeInscrito = "Fulano de Souza";
        String emailInscrito = "fulano@gmail.com";
        List<String> listaEncontrada = comparacaoFormulario.comparar(listaDeInscricoes, nomeInscrito, emailInscrito);

        assertEquals(0, listaEncontrada.size());
    }

    @Test
    void deveriaRetornarUmaListaVaziaPoisOEmailNaoSeEncontraCadastrado(){
        String nomeInscrito = "Fulano da Silva";
        String emailInscrito = "ciclano@gmail.com";

        List<String> listaEncontrada = comparacaoFormulario.comparar(listaDeInscricoes, nomeInscrito, emailInscrito);

        assertEquals(0, listaEncontrada.size());
    }

    @Test
    void deveriaRetornarUmaListaVaziaPoisNaoHaFormulariosCadastrados(){
        String nomeInscrito = "Fulano de Souza";
        String emailInscrito = "fulano@gmail.com";
        List<String> listaEncontrada = comparacaoFormulario.comparar(listaDeInscricoes, nomeInscrito, emailInscrito);

        assertEquals(0, listaEncontrada.size());
    }

}