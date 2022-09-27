package br.com.codar.inscricao.menus;

import br.com.codar.inscricao.utilidades.ValidacaoEntradaNumerica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuRemoverPerguntas {

    private Scanner leitorPerguntas;

    private final List<String> listaPerguntas;

    public MenuRemoverPerguntas(){
        try{
            this.leitorPerguntas = new Scanner(new File("formulario.txt"));
        }catch (FileNotFoundException exception){
            exception.printStackTrace();
        }

        this.listaPerguntas = new ArrayList<>();

        while(this.leitorPerguntas.hasNextLine()){
            this.listaPerguntas.add(this.leitorPerguntas.nextLine());
        }
        mostrarMenuRemocaoPerguntas();
    }

    private void mostrarMenuRemocaoPerguntas(){
        System.out.println("------------------------------------------");
        System.out.println("|             REMOVER PERGUNTA           |");
        System.out.println("------------------------------------------");
        System.out.println("Selecione através do número, qual pergunta deseja remover.");
        System.out.println("As perguntas de 1 a 4 são padrão e não podem ser removidas.");
        System.out.println();

        this.listaPerguntas.forEach(System.out::println);

        System.out.println();
    }

    public void removerPergunta(){
        int perguntaSelecionada = ValidacaoEntradaNumerica.digitarNumero();

        if (validarNumeroRemocao(perguntaSelecionada, this.listaPerguntas)){
            this.listaPerguntas.remove(perguntaSelecionada - 1);
            try {
                salvarFormulario();
                return;
            } catch (FileNotFoundException exception){
                exception.printStackTrace();
            }
        }
            System.out.println("Entrada Inválida");


    }

    private static boolean validarNumeroRemocao(int perguntaSelecionada, List<String> listaPerguntas){
        return perguntaSelecionada > 4 && perguntaSelecionada - 1 < listaPerguntas.size();
    }

    private void salvarFormulario() throws FileNotFoundException {

        PrintWriter gravadorPerguntas = new PrintWriter("formulario.txt");

        int contadorPergunta = 1;
        for(String pergunta : listaPerguntas){
            String indicePergunta = "P" + contadorPergunta + "|";
            gravadorPerguntas.println(indicePergunta + pergunta.substring(pergunta.indexOf("|") + 1));
            contadorPergunta++;
        }
        gravadorPerguntas.close();
    }
}
