package br.com.codar.inscricao.utilidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveAcentosStringsTest {

    private RemoveAcentosStrings remove;

    @Test
    void deveriaRetornarTextoSemAcento(){
        remove = new RemoveAcentosStrings();
        String nomeSemAcento = remove.remover("Âéàõê üÃé");

        assertEquals("Aeaoe uAe", nomeSemAcento);
    }

}