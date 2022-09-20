package br.com.codar.formulario.menus;

import br.com.codar.formulario.utilidades.Continue;
import br.com.codar.formulario.utilidades.ValidacaoEntradaNumerica;

public class MenuInicial {

    private boolean funcionando = true;



    private final String[] itens = {
            "Candidatar-se",
            "Adicionar Pergunta Ao Formulário",
            "Remover Pergunta do Formulário",
            "Lista de Formulários Cadastrados",
            "Pesquisar Formulários Cadastrados",
            "Validar Formulários",
            "Sair"
    };

    public void mostrarMenuInicial(){
        System.out.println("------------------------------------------");
        System.out.println("|              MENU INICIAL              |");
        System.out.println("------------------------------------------");
        for (int i = 0; i < itens.length; i++){
            System.out.printf("| [%d] %-35s|%n", i + 1, itens[i]);
        }
        System.out.println("------------------------------------------");

    }

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
                menuAdicionarPerguntas.adicionarPergunta();
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
