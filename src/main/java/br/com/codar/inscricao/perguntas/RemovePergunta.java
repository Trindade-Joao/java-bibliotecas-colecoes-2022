package br.com.codar.inscricao.perguntas;

import br.com.codar.inscricao.io.EntradaTeclado;

import java.util.ArrayList;
import java.util.List;

public class RemovePergunta {
    private EntradaTeclado teclado;
    private ListaPerguntas listaPerguntas;
    private SalvaPerguntas salvaPerguntas;

    public RemovePergunta(EntradaTeclado teclado, ListaPerguntas listaPerguntas, SalvaPerguntas salvaPerguntas) {
        this.teclado = teclado;
        this.listaPerguntas = listaPerguntas;
        this.salvaPerguntas = salvaPerguntas;
    }

    public RemovePergunta(){
        this.teclado = new EntradaTeclado();
        this.listaPerguntas = new ListaPerguntas();
        this.salvaPerguntas = new SalvaPerguntas();
    }

    public void remover(){
        List<String> listaPerguntasCompleta = new ArrayList<>(listaPerguntas.getListaDePerguntas());
        int numeroPerguntaRetirada = teclado.entradaNumerica();
        if(numeroPerguntaRetirada <= listaPerguntasCompleta.size()){
            if(numeroPerguntaRetirada > 4){
                listaPerguntasCompleta.remove(numeroPerguntaRetirada - 1);
            }else{
                System.out.println("Essa é uma pergunta Padrão e não pode ser removida");
            }
        }else{
            System.out.println("Pergunta inexistente.");
        }
        atualizarLista(listaPerguntasCompleta);
    }

    private void atualizarLista(List<String> listaPerguntas){
        List<String> listaPerguntasAtualizadas = new ArrayList<>();
        for (int contador = 0; contador < listaPerguntas.size(); contador++) {
            listaPerguntasAtualizadas.add(
                    TrataIndicePerguntas.reorganizar(contador, listaPerguntas.get(contador)));
        }
        salvaPerguntas.salvar(listaPerguntasAtualizadas);
    }




}
