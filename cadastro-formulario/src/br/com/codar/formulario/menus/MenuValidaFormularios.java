package br.com.codar.formulario.menus;

import br.com.codar.formulario.utilidades.CarregaListaParaValidacao;
import br.com.codar.formulario.utilidades.ValidacaoCadastro;

import java.util.List;

public class MenuValidaFormularios {

    private List<ValidacaoCadastro> listaDeValidacao;



    public MenuValidaFormularios() {
        CarregaListaParaValidacao carregaListaParaValidacao = new CarregaListaParaValidacao();
        this.listaDeValidacao = carregaListaParaValidacao.carregarListas();
        mostrarMenu();
    }

    private void mostrarMenu(){
        System.out.println("------------------------------------------");
        System.out.println("|        VALIDAR FORMULÁRIOS             |");
        System.out.println("------------------------------------------");

    }

    public void compararCadastros(){

        for (int contador = 0; contador < listaDeValidacao.size(); contador++) {
            int cont = 0;
            for (int contador2 = 0; contador2 < listaDeValidacao.size(); contador2++) {
                if(listaDeValidacao.get(contador).equals(listaDeValidacao.get(contador2))){
                    cont++;
                }
            }
            if(cont > 1){
                System.out.println(listaDeValidacao.get(contador).getNomeFormulario().substring(14));
            }
            cont = 0;
        }
    }

    public List<ValidacaoCadastro> getListaDeValidacao() {
        return listaDeValidacao;
    }
}
