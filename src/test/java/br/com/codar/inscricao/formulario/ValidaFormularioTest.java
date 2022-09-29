package br.com.codar.inscricao.formulario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ValidaFormularioTest {
    private ValidaFormulario validaFormulario;
    private CriaListaInscricoes criaLista;
    @Mock
    ListarInscricoes listarInscricoes;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.validaFormulario = new ValidaFormulario(listarInscricoes);
        this.criaLista = new CriaListaInscricoes();
    }

    @Test
    void deveriaRetornarUmaListaComTodosOsFormulariosRepetidos(){
        List<Inscricoes> formulariosComRepeticao = criaLista.criarComRepeticao();
        when(listarInscricoes.getLista()).thenReturn(formulariosComRepeticao);
        List<String> listaFormulariosRepetidos = validaFormulario.validar();

        assertEquals(4, listaFormulariosRepetidos.size());
    }

    @Test
    void deveriaRetornarUmaListaVaziaPorqueNaoTemRepeticao(){
        List<Inscricoes> formulariosSemRepeticao = criaLista.criarSemRepeticao();
        when(listarInscricoes.getLista()).thenReturn(formulariosSemRepeticao);
        List<String> listaFormulariosRepetidos = validaFormulario.validar();

        assertEquals(0, listaFormulariosRepetidos.size());

    }
}