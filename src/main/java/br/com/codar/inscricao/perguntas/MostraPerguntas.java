package br.com.codar.inscricao.perguntas;

public class MostraPerguntas {

      public static void mostrar(){
          ListarPerguntas listarPerguntas = new ListarPerguntas();
        listarPerguntas.getListaDePerguntas().forEach(System.out::println);
    }

}
