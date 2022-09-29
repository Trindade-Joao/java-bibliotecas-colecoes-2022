package br.com.codar.inscricao.perguntas;

import br.com.codar.inscricao.io.EntradaTeclado;

import java.util.ArrayList;
import java.util.List;

public class AdicionaPergunta {

    private EntradaTeclado teclado;
    private ValidacaoPerguntasRepetidas validacaoPerguntasRepetidas;
    private ListarPerguntas listarPerguntas;
    private SalvaPerguntas salvaPerguntas;


    public AdicionaPergunta(EntradaTeclado teclado){
        this.salvaPerguntas = new SalvaPerguntas();
        this.listarPerguntas = new ListarPerguntas();
        this.validacaoPerguntasRepetidas = new ValidacaoPerguntasRepetidas(listarPerguntas);
        this.teclado = teclado;
    }

    public AdicionaPergunta(EntradaTeclado teclado, ValidacaoPerguntasRepetidas validacaoPerguntasRepetidas, ListarPerguntas listarPerguntas, SalvaPerguntas salvaPerguntas) {
        this.teclado = teclado;
        this.validacaoPerguntasRepetidas = validacaoPerguntasRepetidas;
        this.listarPerguntas = listarPerguntas;
        this.salvaPerguntas = salvaPerguntas;

    }

    public void inserirPerguntaNoFormulario(){

        String pergunta = teclado.entradaAlfaNumerica();
        if(validacaoPerguntasRepetidas.validarPergunta(pergunta)){
            atualizarListaPerguntas(pergunta);
        }else {
            System.out.println("Essa pergunta já se encontra no formulário.");
        }
    }

    private String indicePergunta(int numeroDaPergunta){
        return "P" + numeroDaPergunta + "|";
    }

    private void atualizarListaPerguntas(String pergunta){
        List<String> listaDePerguntasAtualizada = new ArrayList<>(listarPerguntas.getListaDePerguntas());
        String indice = indicePergunta(listaDePerguntasAtualizada.size() + 1);
        listaDePerguntasAtualizada.add(indice + pergunta);
        salvaPerguntas.salvar(listaDePerguntasAtualizada);
    }
}
