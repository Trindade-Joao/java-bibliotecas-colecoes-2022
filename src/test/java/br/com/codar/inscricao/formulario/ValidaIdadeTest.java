package br.com.codar.inscricao.formulario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidaIdadeTest {

    private ValidaIdade validaIdade = new ValidaIdade();

    @Test
    void deveriaDarTruePorqueAIdadeEMaiorQue16(){
        assertTrue(validaIdade.validar("20"));
    }

    @Test
    void deveriaDarTruePorqueAIdadeEIgual16(){
        assertTrue(validaIdade.validar("16"));
    }

    @Test
    void deveriaDarFalsePorqueAIdadeEMenorQue16(){
        assertFalse(validaIdade.validar("15"));
    }

    @Test
    void deveriaDarFalsePorqueAIdadeFoiInseridaComoLetra(){
        assertFalse(validaIdade.validar("r"));
    }



}