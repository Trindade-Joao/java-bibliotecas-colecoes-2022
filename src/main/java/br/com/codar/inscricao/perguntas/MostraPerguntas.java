package br.com.codar.inscricao.perguntas;

import java.util.ArrayList;
import java.util.List;

public class MostraPerguntas {

    private ListaPerguntas listaPerguntas;
    private List<String> listaDePerguntas;

    public MostraPerguntas(){
        this.listaPerguntas = new ListaPerguntas();
        this.listaDePerguntas = new ArrayList<>(listaPerguntas.getListaDePerguntas());
    }

    public void mostrarPerguntas(){
        listaDePerguntas.forEach(System.out::println);
    }

}
