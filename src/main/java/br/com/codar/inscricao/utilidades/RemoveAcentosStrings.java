package br.com.codar.inscricao.utilidades;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class RemoveAcentosStrings {

    public String remover(String texto){
        String perguntaNormalizada = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(perguntaNormalizada).replaceAll("");
    }
}
