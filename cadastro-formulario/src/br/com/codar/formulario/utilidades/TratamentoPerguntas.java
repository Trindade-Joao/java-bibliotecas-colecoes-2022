package br.com.codar.formulario.utilidades;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class TratamentoPerguntas {

    public String tratarPergunta(String pergunta){
        String perguntaTratada = removerNumeroDaPergunta(pergunta);
        perguntaTratada = removerNumeroDaPergunta(perguntaTratada);
        perguntaTratada = removerCarateresEspeciaisPerguntas(perguntaTratada);

        return perguntaTratada.replace(" ", "").toUpperCase();
    }

    private static String removerNumeroDaPergunta(String pergunta){
        int posicaoDaBarra = pergunta.indexOf("|") + 1;
        return pergunta.substring(posicaoDaBarra);
    }

    private static String removerCarateresEspeciaisPerguntas(String pergunta){
        String perguntaNormalizada = Normalizer.normalize(pergunta, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String perguntaSemAcentos = pattern.matcher(perguntaNormalizada).replaceAll("");

        return perguntaSemAcentos.replaceAll("[^a-z A-Z]", "");
    }

}
