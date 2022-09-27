package br.com.codar.inscricao.menus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuCadastro {

    private Scanner leitorPerguntas;
    private Scanner entradaTeclado;

    public MenuCadastro() {
        try{
            this.leitorPerguntas = new Scanner(new File("formulario.txt"));
        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        }

        this.entradaTeclado = new Scanner(System.in);
    }

    public void mostrarMenuCadastro(){
        System.out.println("------------------------------------------");
        System.out.println("|    CADASTRO DE NOVOS PARTICIPANTES     |");
        System.out.println("------------------------------------------");
        System.out.println();
    }

    public void fazerPerguntas(){


        List<String> respostas = new ArrayList<>();

        while(this.leitorPerguntas.hasNextLine()){
            String pergunta = this.leitorPerguntas.nextLine();
            System.out.println(pergunta);
            System.out.print("=> ");
            respostas.add(resposta());
            System.out.println();
        }
//        try{
//            MenuCadastro.salvarRespostas(respostas);
//        }catch (FileNotFoundException exception){
//            exception.printStackTrace();
//        }

        this.leitorPerguntas.close();
    }



    private String resposta() {
        return this.entradaTeclado.nextLine();
    }



}
