package br.com.codar.inscricao.menus;

public class MenuListaCandidatos implements InterfaceMenu{

    public void mostrarMenu(){
        System.out.print("""
                ------------------------------------------
                |           LISTAR CANDIDATOS            |
                ------------------------------------------
                | [1] Candidatos Agrupados por Idade     |
                | [2] Número de Candidatos por Idade     |
                ------------------------------------------
                
                """);

    }
}
