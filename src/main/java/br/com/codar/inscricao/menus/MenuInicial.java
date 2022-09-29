package br.com.codar.inscricao.menus;

public class MenuInicial implements InterfaceMenu {

    private final String[] itens = {
            "Candidatar-se",
            "Adicionar Pergunta Ao Formulário",
            "Remover Pergunta do Formulário",
            "Lista de Formulários Cadastrados",
            "Pesquisar Formulários Cadastrados",
            "Validar Formulários",
            "Sair"
    };

    public void mostrarMenu(){
        System.out.println("------------------------------------------");
        System.out.println("|              MENU INICIAL              |");
        System.out.println("------------------------------------------");
        for (int i = 0; i < itens.length; i++){
            System.out.printf("| [%d] %-35s|%n", i + 1, itens[i]);
        }
        System.out.println("------------------------------------------");

    }




}
