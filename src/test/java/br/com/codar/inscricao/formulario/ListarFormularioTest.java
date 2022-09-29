package br.com.codar.inscricao.formulario;

public class ListarFormularioTest {
    public static void main(String[] args) {
        ListarInscricoes listarInscricoes = new ListarInscricoes();
        listarInscricoes.carregarLista();
        System.out.println(listarInscricoes.getLista());

    }
}
