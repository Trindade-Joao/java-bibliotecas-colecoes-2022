package br.com.codar.inscricao.menus;

public class MenuRemoverPerguntas implements InterfaceMenu{

   public void mostrarMenu(){
        System.out.println("""
                    ------------------------------------------
                    |             REMOVER PERGUNTA           |
                    ------------------------------------------
                    Selecione através do número, qual pergunta 
                    deseja remover. As perguntas de 1 a 4 são 
                       padrão e não podem ser removidas.                       
                    """);

    }
}
