package br.com.codar.inscricao.formulario;

import br.com.codar.inscricao.io.EntradaDados;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListarRespostas {

    private EntradaDados entradaDados;

    public ListarRespostas() {
        this.entradaDados = new EntradaDados();
    }

    public List<String> listar(File formulario){
        List<String> listaDeRespostas = new ArrayList<>();
        entradaDados.iniciarLeitor(formulario.toString());
        while (entradaDados.getLeitor().hasNextLine()){
            listaDeRespostas.add(entradaDados.getLeitor().nextLine());
        }
        entradaDados.encerrarLeitor();
        return Collections.unmodifiableList(listaDeRespostas);
    }
}
