package br.com.codar.inscricao.menus;

import br.com.codar.inscricao.utilidades.Continue;
import br.com.codar.inscricao.utilidades.ValidacaoEntradaNumerica;

public class SeletorMenu {

    private boolean funcionando = true;

    public void selecaoMenu() {

        switch (ValidacaoEntradaNumerica.digitarNumero()){
            case 1:
                MenuCadastro menuCadastro = new MenuCadastro();
                menuCadastro.mostrarMenuCadastro();
                menuCadastro.fazerPerguntas();
                Continue.continuar();
                System.out.printf("%n%n");
                break;

            case 2:
                MenuAdicionarPerguntas menuAdicionarPerguntas = new MenuAdicionarPerguntas();
//                menuAdicionarPerguntas.adicionarPergunta();
                Continue.continuar();
                System.out.printf("%n%n");
                break;

            case 3:
                MenuRemoverPerguntas menuRemoverPerguntas = new MenuRemoverPerguntas();
                menuRemoverPerguntas.removerPergunta();
                Continue.continuar();
                System.out.printf("%n%n");
                break;

            case 4:
                MenuListaCandidatos menuListaCandidatos = new MenuListaCandidatos();
                Continue.continuar();
                System.out.printf("%n%n");
                break;

            case 5:
                MenuPequisarFormulariosCadastrados menuPequisarFormulariosCadastrados = new MenuPequisarFormulariosCadastrados();
                Continue.continuar();
                System.out.printf("%n%n");
                break;

            case 6:
                MenuValidaFormularios menuValidaFormularios = new MenuValidaFormularios();
                menuValidaFormularios.compararCadastros();
                Continue.continuar();
                System.out.printf("%n%n");
                break;

            case 7:
                System.out.println("Saindo...");
                this.funcionando = false;
                break;

            default:
                System.out.println("Entrada inválida");

        }
    }

    public boolean isFuncionando() {
        return funcionando;
    }
}
