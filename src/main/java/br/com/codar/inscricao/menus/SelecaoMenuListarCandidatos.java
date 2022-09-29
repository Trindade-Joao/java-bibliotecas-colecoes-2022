package br.com.codar.inscricao.menus;

import br.com.codar.inscricao.utilidades.AgrupaCandidatosPorIdade;

public class SelecaoMenuListarCandidatos {
    private AgrupaCandidatosPorIdade agrupaCandidatos;

    public SelecaoMenuListarCandidatos() {
        this.agrupaCandidatos = new AgrupaCandidatosPorIdade();
    }

    public SelecaoMenuListarCandidatos(AgrupaCandidatosPorIdade agrupaCandidatos) {
        this.agrupaCandidatos = agrupaCandidatos;
    }

    public void selecaoMenu(int entrada){
        switch (entrada) {
            case 1:
                agrupaCandidatos.agruparCandidatosPorIdade();
                break;
            case 2:
                agrupaCandidatos.imprimirQuantidadeCandidatosPorIdade();
                break;
            default:
                System.out.println("Entrada Inválida.");
                break;

        }

    }
}
