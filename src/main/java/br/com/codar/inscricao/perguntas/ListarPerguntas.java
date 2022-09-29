package br.com.codar.inscricao.perguntas;

import br.com.codar.inscricao.io.EntradaDados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListarPerguntas {

    private EntradaDados entrada;
    private String caminhoDoArquivo = "./";
    private String nomeDoArquivo = "formulario.txt";

    private List<String> listaDePerguntas;

    public ListarPerguntas() {
        this.entrada = new EntradaDados();
        this.listaDePerguntas = listar();
    }

    private List<String> listar(){
        entrada.iniciarLeitor(caminhoDoArquivo, nomeDoArquivo);
        List<String> listaPerguntas = new ArrayList<>();
        while (entrada.getLeitor().hasNextLine()) {
            listaPerguntas.add(entrada.getLeitor().nextLine());
        }
        entrada.encerrarLeitor();
        return listaPerguntas;
    }

    public List<String> getListaDePerguntas() {
        return Collections.unmodifiableList(listaDePerguntas);
    }
}
