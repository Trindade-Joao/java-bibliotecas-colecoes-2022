package br.com.codar.inscricao.formulario;

import br.com.codar.inscricao.io.EntradaTeclado;
import br.com.codar.inscricao.perguntas.ListarPerguntas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RespondeFormulario {
    private ListarPerguntas listarPerguntas;
    private EntradaTeclado teclado;

    public RespondeFormulario(){
        this.listarPerguntas = new ListarPerguntas();
        this.teclado = new EntradaTeclado();
    }

    public RespondeFormulario(ListarPerguntas listarPerguntas, EntradaTeclado teclado) {
        this.listarPerguntas = listarPerguntas;
        this.teclado = teclado;
    }

    public List<String> responder(){
        List<String> respostas = new ArrayList<>();
        listarPerguntas.getListaDePerguntas().forEach(pergunta -> {
            System.out.printf("%s%n=> ", pergunta);
            respostas.add(teclado.entradaAlfaNumerica());
        });
        return Collections.unmodifiableList(respostas);
    }




}
