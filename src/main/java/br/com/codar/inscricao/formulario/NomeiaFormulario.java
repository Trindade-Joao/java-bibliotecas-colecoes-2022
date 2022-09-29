package br.com.codar.inscricao.formulario;

import br.com.codar.inscricao.utilidades.RemoveAcentosStrings;

import java.util.List;

public class NomeiaFormulario {


    public static String nomear(List<String> respostas) {
        RemoveAcentosStrings remove = new RemoveAcentosStrings();
        String nomeSemAcento = remove.remover(respostas.get(0));
        return numeroFormulario() + "-" + nomeSemAcento.replace(" ", "").toUpperCase() + ".txt";
    }

    private static int numeroFormulario(){
        ListarInscricoes listarInscricoes = new ListarInscricoes();
        listarInscricoes.carregarLista();
        return listarInscricoes.getLista().size() + 1;
    }
}
