package br.com.codar.inscricao.perguntas;

import java.util.ArrayList;
import java.util.List;

public class ValidacaoPerguntasRepetidas {

    private ListarPerguntas listarPerguntas;

    public ValidacaoPerguntasRepetidas(ListarPerguntas listarPerguntas){
        this.listarPerguntas = listarPerguntas;
    }


    public boolean validarPergunta(String pergunta){
        List<String> listaDePerguntas = new ArrayList<>(listarPerguntas.getListaDePerguntas());
        List<String> listaDePerguntasTratadas = new ArrayList<>();
        TratamentoPerguntas tratamentoPerguntas = new TratamentoPerguntas();

        listaDePerguntas.forEach(p -> listaDePerguntasTratadas.add(tratamentoPerguntas.tratar(p)));

        return !listaDePerguntasTratadas.contains(tratamentoPerguntas.tratar(pergunta));
    }
}
