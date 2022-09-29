package br.com.codar.inscricao.menus;

import br.com.codar.inscricao.utilidades.AgrupaCandidatosPorIdade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class SelecaoMenuListarCandidatosTest {
    private ByteArrayOutputStream saida;
    private SelecaoMenuListarCandidatos selecao;
    @Mock
    private AgrupaCandidatosPorIdade agrupaCandidatos;

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.openMocks(this);
        this.saida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saida));
        this.selecao = new SelecaoMenuListarCandidatos(agrupaCandidatos);
    }

    @AfterEach
    void afterEach() throws IOException {
        saida.close();
    }

    @Test
    void deveriaAcessarAgrupaCandidatoPorIdade(){
        selecao.selecaoMenu(1);
        verify(agrupaCandidatos, times(1)).agruparCandidatosPorIdade();
    }

    @Test
    void deveriaAcessarImprimirQuantidadeCandidatosPorIdade(){
        selecao.selecaoMenu(2);
        verify(agrupaCandidatos, times(1)).imprimirQuantidadeCandidatosPorIdade();
    }

    @Test
    void deveriaAcessarImprimirEntradaInvalida(){
        selecao.selecaoMenu(3);
        assertEquals("Entrada Inválida.\n", saida.toString());

    }


}