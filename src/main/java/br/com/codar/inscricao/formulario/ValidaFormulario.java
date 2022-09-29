package br.com.codar.inscricao.formulario;

import java.util.ArrayList;
import java.util.List;

public class ValidaFormulario {
    private ComparacaoFormulario comparacaoFormulario;
    private ListarInscricoes listarInscricoes;

    private List<Inscricoes> listaDeFormularios;

    public ValidaFormulario() {
        this.listarInscricoes = new ListarInscricoes();
        this.comparacaoFormulario = new ComparacaoFormulario();
    }

    public ValidaFormulario(ListarInscricoes listarInscricoes) {
        this.listarInscricoes = listarInscricoes;
        this.comparacaoFormulario = new ComparacaoFormulario();
    }

    public List<String> validar(){
        List<String> listaDeFormulariosRepetidos = new ArrayList<>();
        listarInscricoes.carregarLista();
        this.listaDeFormularios = listarInscricoes.getLista();
        listaDeFormularios.forEach(formulario ->{
            String nome = formulario.getRespostas().get(0);
            String email = formulario.getRespostas().get(1);
            List<String> comparacao = comparacaoFormulario.comparar(listaDeFormularios,nome,email);
            if(comparacao.size() > 1){
                listaDeFormulariosRepetidos.add(formulario.getNomeFormulario());
            }
        });
        return listaDeFormulariosRepetidos;
    }

    public void imprimir(List<String> lista){
        System.out.println();
        lista.forEach(formulario -> System.out.println(formulario.substring(26)));
    }
}
