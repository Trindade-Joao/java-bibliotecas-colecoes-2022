package br.com.codar.inscricao.formulario;

import br.com.codar.inscricao.io.EntradaTeclado;

import java.util.List;

public class PesquisaFormulario {

    private EntradaTeclado teclado;
    private ComparacaoFormulario comparacaoFormulario;



    public PesquisaFormulario(){
        this.teclado = new EntradaTeclado();
        this.comparacaoFormulario = new ComparacaoFormulario();
    }

    public PesquisaFormulario(EntradaTeclado teclado) {
        this.teclado = teclado;

    }

    private String entradaNomePesquisado(){
        System.out.println("Digite o nome que deseja pesquisar.");
        System.out.print("=> ");
        return teclado.entradaAlfaNumerica();
    }

    private String entradaEmailPesquisado(){
        System.out.println("Digite o email que deseja pesquisar.");
        System.out.print("=> ");
        return teclado.entradaAlfaNumerica();
    }

    public List<String> pesquisar(List<Inscricoes> lista){
        comparacaoFormulario = new ComparacaoFormulario();
        String nome = entradaNomePesquisado();
        String email = entradaEmailPesquisado();
        List<String> listaEncontrada = comparacaoFormulario.comparar(lista, nome, email);

        return listaEncontrada;
    }

    public void imprimirLista(List<String> lista){
        if(lista.size() > 0) {
            System.out.println("""                    
                    
                    ------------------------------------------
                    |         FORMULÁRIOS ENCONTRADOS        |
                    ------------------------------------------           
                    """);
            lista.forEach(formulario -> System.out.printf("%s%n", formulario.substring(26)));
            System.out.println();
        }else{
            System.out.println("""
                    
                    
                    ------------------------------------------
                    |      NENHUM FORMULÁRIO ENCONTRADO      |
                    ------------------------------------------
                    
                    """);
        }
    }
}
