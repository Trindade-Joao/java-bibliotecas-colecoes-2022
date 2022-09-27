package br.com.codar.inscricao.perguntas;

import br.com.codar.inscricao.io.SaidaDados;

import java.util.List;

public class SalvaPerguntas {

    private String caminhoArquivo = "./";
    private String nomeArquivo = "formulario.txt";
    private SaidaDados saidaDados;

    public SalvaPerguntas(){
        this.saidaDados = new SaidaDados();
    }

    public void salvar(List<String> listaPerguntas){
        saidaDados.iniciarGravador(caminhoArquivo,nomeArquivo);
        listaPerguntas.forEach(saidaDados.gravador()::println);
        saidaDados.encerrarGravador();
    }
}
