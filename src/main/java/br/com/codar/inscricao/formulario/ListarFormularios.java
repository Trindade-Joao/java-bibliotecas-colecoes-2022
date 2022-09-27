package br.com.codar.inscricao.formulario;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListarFormularios {

    private String caminhoArquivo = "./formularios-cadastrados";
    private File formularios;
    private List<File> listaDeFormularios;

    public ListarFormularios() {
        this.formularios = new File(caminhoArquivo);
        this.listaDeFormularios = new ArrayList<>(List.of(formularios.listFiles()));
    }

    public List<File> getListaDeFormularios(){
        return Collections.unmodifiableList(listaDeFormularios);
    }
}
