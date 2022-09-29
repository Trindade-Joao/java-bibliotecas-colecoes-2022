package br.com.codar.inscricao.formulario;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListarInscricoes {

    private String caminhoArquivo = "./formularios-cadastrados";
    private File formularios;
    private List<File> listaDeFormularios;
    private List<Inscricoes> listaFormulariosRespondidos;
    private ListarRespostas listarRespostas;

    public ListarInscricoes() {
        this.formularios = new File(caminhoArquivo);
        this.listaDeFormularios = new ArrayList<>(List.of(formularios.listFiles()));

        this.listarRespostas = new ListarRespostas();
    }

    public void carregarLista(){
        listaFormulariosRespondidos = new ArrayList<>();
        listaDeFormularios.forEach(formulario ->{
            listaFormulariosRespondidos.add(new Inscricoes(formulario.toString(), listarRespostas.listar(formulario)));
        });
    }


    public List<Inscricoes> getLista() {
        return listaFormulariosRespondidos;
    }
}
