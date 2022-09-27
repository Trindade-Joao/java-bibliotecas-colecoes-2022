package br.com.codar.inscricao.perguntas;

import br.com.codar.inscricao.io.EntradaTeclado;

import java.util.ArrayList;
import java.util.List;

public class AdicionaPergunta {

    private EntradaTeclado teclado;
    private ValidacaoPerguntasRepetidas validacaoPerguntasRepetidas;
    private ListaPerguntas listaPerguntas;
    private SalvaPerguntas salvaPerguntas;


    public AdicionaPergunta(){
        this.listaPerguntas = new ListaPerguntas();
        this.salvaPerguntas = new SalvaPerguntas();
    }

    public AdicionaPergunta(EntradaTeclado teclado, ValidacaoPerguntasRepetidas validacaoPerguntasRepetidas, ListaPerguntas listaPerguntas, SalvaPerguntas salvaPerguntas) {
        this.teclado = teclado;
        this.validacaoPerguntasRepetidas = validacaoPerguntasRepetidas;
        this.listaPerguntas = listaPerguntas;
        this.salvaPerguntas = salvaPerguntas;

    }

    private String entrarComPergunta() {
        System.out.printf("%nAdicione Uma Nova Pergunta.%n=> ");
        return teclado.entradaAlfaNumerica();
    }

    public void inserirPerguntaNoFormulario(){
        String pergunta = entrarComPergunta();
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
        List<String> listaDePerguntasAtualizada = new ArrayList<>(listaPerguntas.getListaDePerguntas());
        String indice = indicePergunta(listaDePerguntasAtualizada.size() + 1);
        listaDePerguntasAtualizada.add(indice + pergunta);
        salvaPerguntas.salvar(listaDePerguntasAtualizada);
    }
}
