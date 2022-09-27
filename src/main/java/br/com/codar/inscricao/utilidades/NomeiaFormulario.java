package br.com.codar.inscricao.utilidades;

import java.io.File;

public class NomeiaFormulario {

    private RemoveAcentosStrings remove;

    public NomeiaFormulario(){
        this.remove = new RemoveAcentosStrings();
    }

    public String nomear(String nome) {
        String nomeSemAcento = remove.remover(nome);
        return nomeSemAcento.replace(" ", "").toUpperCase() + ".txt";
    }

    public int numeroFormulario(){
        File[] formularios = new File("./cadastro-formulario/formularios").listFiles();
        return formularios.length;
    }
}
