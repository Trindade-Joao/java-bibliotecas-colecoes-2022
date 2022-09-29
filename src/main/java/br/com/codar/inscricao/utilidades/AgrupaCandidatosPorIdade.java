package br.com.codar.inscricao.utilidades;

import br.com.codar.inscricao.formulario.Inscricoes;
import br.com.codar.inscricao.formulario.ListarInscricoes;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AgrupaCandidatosPorIdade {

    private Set<String> idades;
    private ListarInscricoes listarInscricoes;

    public AgrupaCandidatosPorIdade(){
        this.listarInscricoes = new ListarInscricoes();
        this.idades = new TreeSet<>();
    }

    public AgrupaCandidatosPorIdade(ListarInscricoes listarInscricoes) {
        this.listarInscricoes = listarInscricoes;
        this.idades = new TreeSet<>();
    }

    public void agruparCandidatosPorIdade(){
        listarInscricoes.carregarLista();
        pegarIdadeDosFormularios();
        idades.forEach(idade -> {
            System.out.printf("%n%s%n---------------------------------------%n",idade);
            listarInscricoes.getLista().forEach(formulario -> {
                if(formulario.getRespostas().contains(idade)){
                    System.out.println(formulario.getRespostas().get(0));
                }
            });
        });
    }

    private void pegarIdadeDosFormularios(){
        listarInscricoes.getLista().forEach(formulario -> idades.add(formulario.getRespostas().get(2)));
    }



    public void imprimirQuantidadeCandidatosPorIdade(){
        listarInscricoes.carregarLista();
        List<Inscricoes> listaDeFormularios = listarInscricoes.getLista();
        pegarIdadeDosFormularios();
        idades.forEach(idade -> {
            int quantidade = 0;
            for (Inscricoes formulario : listaDeFormularios) {
                if(formulario.getRespostas().contains(idade)) {
                    quantidade++;
                }
            }
            System.out.printf("%s anos -> %d inscrito(s)%n", idade, quantidade);
            quantidade = 0;
        });
    }

}
