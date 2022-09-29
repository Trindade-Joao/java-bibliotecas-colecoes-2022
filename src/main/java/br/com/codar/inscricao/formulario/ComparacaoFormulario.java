package br.com.codar.inscricao.formulario;

import java.util.ArrayList;
import java.util.List;


public class ComparacaoFormulario {



    public ComparacaoFormulario() {

    }

    public List<String> comparar(List<Inscricoes> listaInscricoes, String dado1, String dado2){
        List<String> nomeDosFormulariosEncontrados = new ArrayList<>();
        listaInscricoes.forEach(inscricao ->{
            if(compararDados(inscricao.getRespostas(), dado1, dado2)){
                nomeDosFormulariosEncontrados.add(inscricao.getNomeFormulario());
            }
        });
        return nomeDosFormulariosEncontrados;
    }

    private boolean compararDados(List<String> respostas, String dado1, String dado2){
        return respostas.contains(dado1) && respostas.contains(dado2);
    }
}
