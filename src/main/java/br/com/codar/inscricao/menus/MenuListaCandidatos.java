package br.com.codar.inscricao.menus;

import br.com.codar.inscricao.utilidades.AgrupaCandidatosPorIdade;
import br.com.codar.inscricao.utilidades.ValidacaoEntradaNumerica;

public class MenuListaCandidatos {
    private AgrupaCandidatosPorIdade agrupaCandidatosPorIdade;

    public MenuListaCandidatos(){
        this.agrupaCandidatosPorIdade = new AgrupaCandidatosPorIdade();
        mostrarMenuListarFormularios();
        selecaoMenu();
    }

    private void mostrarMenuListarFormularios(){
        System.out.println("------------------------------------------");
        System.out.println("|           LISTAR CANDIDATOS            |");
        System.out.println("------------------------------------------");
        System.out.println("| [1] Candidatos Agrupados por Idade     |");
        System.out.println("| [2] Número de Candidatos por Idade     |");
        System.out.println("------------------------------------------");

    }

    private void selecaoMenu(){

            switch (ValidacaoEntradaNumerica.digitarNumero()) {
                case 1:
                    this.agrupaCandidatosPorIdade.imprimirNomePorIdade();
                    break;
                case 2:
                    this.agrupaCandidatosPorIdade.imprimirQuantidadeCandidatosPorIdade();
                    break;
                default:
                    System.out.println("Entrada Inválida");
                    break;

            }

    }

}
