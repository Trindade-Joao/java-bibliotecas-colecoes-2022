package br.com.codar.inscricao.menus;

public class MenuAdicionarPerguntas implements InterfaceMenu{

    public MenuAdicionarPerguntas() {

    }

    public void mostrarMenu(){
        System.out.print("""
                      ------------------------------------------
                      |         ADICIONAR PERGUNTA             |
                      ------------------------------------------
                      
                      Adicione uma nova Pergunta
                      => """
        );
    }
}
