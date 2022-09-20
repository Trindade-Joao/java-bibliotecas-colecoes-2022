package br.com.codar.formulario.utilidades;

import java.io.File;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class TratamentoNomeFormulario {

    public static String tratarNome(String nome) {
        String nomeNormalizado = Normalizer.normalize(nome, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String nomeSemAcento = pattern.matcher(nomeNormalizado).replaceAll("");
        return nomeSemAcento.replace(" ", "").toUpperCase() + ".txt";
    }

    public static int numeroFormulario(){
        File[] formularios = new File("./cadastro-formulario/formularios").listFiles();
        return formularios.length;
    }
}
