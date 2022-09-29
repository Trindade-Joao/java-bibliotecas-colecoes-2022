package br.com.codar.inscricao.utilidades;

import br.com.codar.inscricao.formulario.Inscricoes;
import br.com.codar.inscricao.formulario.ListaFomulariosRespondidosTeste;
import br.com.codar.inscricao.formulario.ListarInscricoes;
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


class AgrupaCandidatosPorIdadeTest {
    private AgrupaCandidatosPorIdade agrupa;
    @Mock
    private ListarInscricoes listarInscricoes;
    private ByteArrayOutputStream saida;
    private List<Inscricoes> listaDeFormulariosRespondidos;

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.openMocks(this);
        this.saida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saida));
        this.agrupa = new AgrupaCandidatosPorIdade(listarInscricoes);
        this.listaDeFormulariosRespondidos = ListaFomulariosRespondidosTeste.criar();
    }

    @AfterEach
    void afterEach() throws IOException {
        saida.close();
    }

    @Test
    void deveriaImprimirNoConsoleAListaDeInscritosSeparadosPorIdade(){
        when(listarInscricoes.getLista()).thenReturn(listaDeFormulariosRespondidos);
        agrupa.agruparCandidatosPorIdade();

        assertEquals("""
                                
                18
                ---------------------------------------
                Fulano da Silva
                Fulano da Silva
                                
                89
                ---------------------------------------
                Ciclano de Souza
                Ciclano de Souza                                
                """, saida.toString());
    }

    @Test
    void deveriaImprimirNoConsoleONumeroDeInscritosPorIdade(){
        when(listarInscricoes.getLista()).thenReturn(listaDeFormulariosRespondidos);
        agrupa.imprimirQuantidadeCandidatosPorIdade();

        assertEquals("""
                18 anos -> 2 inscrito(s)
                89 anos -> 2 inscrito(s)                                
                """, saida.toString());

    }

}