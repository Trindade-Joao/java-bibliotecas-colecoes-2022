package br.com.codar.formulario.menus;

import br.com.codar.formulario.utilidades.CarregaListaParaValidacao;
import br.com.codar.formulario.utilidades.ValidacaoCadastro;

import java.util.List;
import java.util.Scanner;

public class MenuPequisarFormulariosCadastrados {

    List<ValidacaoCadastro> listaValidacao;
    String nomePesquisado;
    String emailPesquisado;

    public MenuPequisarFormulariosCadastrados() {

        CarregaListaParaValidacao carregaListaParaValidacao = new CarregaListaParaValidacao();
        this.listaValidacao = carregaListaParaValidacao.carregarListas();
        mostrarMenu();
        entradaDosDadosDaPesquisa();
        pesquisar();
    }

    private void entradaDosDadosDaPesquisa(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome que deseja pesquisar.");
        System.out.print("=> ");
        nomePesquisado = teclado.nextLine();
        System.out.println("Digite o email que deseja pesquisar.");
        System.out.print("=> ");
        emailPesquisado = teclado.nextLine();
    }

    private void mostrarMenu(){
        System.out.println("------------------------------------------");
        System.out.println("|   PESQUISAR FORMULARIOS CADASTRADOS    |");
        System.out.println("------------------------------------------");
        System.out.println();
    }
    private void pesquisar(){
        listaValidacao.forEach(cadastro ->{
            if(cadastro.getNomeInscrito().equals(this.nomePesquisado) && cadastro.getEmail().equals(this.emailPesquisado)){
                System.out.printf("%n%s",cadastro.getNomeFormulario().substring(34));
            } else{

            }
        });
    }

}
