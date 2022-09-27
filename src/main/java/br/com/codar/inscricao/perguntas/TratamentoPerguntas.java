package br.com.codar.inscricao.perguntas;

import br.com.codar.inscricao.utilidades.RemoveAcentosStrings;

public class TratamentoPerguntas {

    private RemoveAcentosStrings removeAcentos;

    public TratamentoPerguntas(){
        this.removeAcentos = new RemoveAcentosStrings();
    }

    public String tratar(String pergunta){
        String perguntaTratada = TrataIndicePerguntas.remover(pergunta);
        perguntaTratada = removerCarateresEspeciais(perguntaTratada);

        return perguntaTratada.replace(" ", "").toUpperCase();
    }


    private String removerCarateresEspeciais(String pergunta){
        String perguntaSemAcento = removeAcentos.remover(pergunta);
        return perguntaSemAcento.replaceAll("[^a-z A-Z]", "");
    }

}
