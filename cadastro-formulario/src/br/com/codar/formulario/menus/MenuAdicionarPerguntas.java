package br.com.codar.formulario.menus;

import br.com.codar.formulario.utilidades.TratamentoPerguntas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class MenuAdicionarPerguntas {

    private PrintWriter formularioSalvo;
    private Scanner lerFormularioPerguntas;
    public MenuAdicionarPerguntas() {

        try{
            this.formularioSalvo = new PrintWriter(new FileOutputStream(("formulario.txt"), true));
        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        }

        mostrarMenu();
        listarPerguntas();
    }

    private void mostrarMenu(){
        System.out.println("------------------------------------------");
        System.out.println("|         ADICIONAR PERGUNTA             |");
        System.out.println("------------------------------------------");
    }

    private void listarPerguntas(){
        iniciarScanner();
        while (this.lerFormularioPerguntas.hasNextLine()) {
            System.out.println(this.lerFormularioPerguntas.nextLine());
        }
        encerrarScanner();
    }

    public void adicionarPergunta() {
        Scanner entradaTeclado = new Scanner(System.in);

        System.out.printf("%nAdicione Uma Nova Pergunta.%n=> ");
        String pergunta = entradaTeclado.nextLine();

        int numeroDaPergunta = contadorPerguntas();
        String numeradorPergunta = "P" + numeroDaPergunta + "|";

        if (validacaoPergunta(pergunta)) {
            this.formularioSalvo.append(System.lineSeparator()).append(numeradorPergunta + pergunta);
            this.formularioSalvo.close();
            System.out.printf("%nSalvando pergunta.");
        }else{
            System.out.printf("%nEssa pergunta já se encontra no formulário.");
        }


    }

    private boolean validacaoPergunta(String pergunta){
        iniciarScanner();
        TratamentoPerguntas tratamentoPerguntas = new TratamentoPerguntas();

        int contador = 0;
        while (this.lerFormularioPerguntas.hasNextLine()) {
            String perguntaFormularioTratada = tratamentoPerguntas.tratarPergunta(this.lerFormularioPerguntas.nextLine());
            String perguntaEntradaTratada = tratamentoPerguntas.tratarPergunta(pergunta);

            if (perguntaFormularioTratada.equals(perguntaEntradaTratada)) {
                contador++;
            }
        }
        encerrarScanner();
        return contador == 0;
    }


    private int contadorPerguntas(){
        iniciarScanner();
        int contador = 1;
        while(this.lerFormularioPerguntas.hasNextLine()){
            String teste = this.lerFormularioPerguntas.nextLine();
            contador++;
        }
        encerrarScanner();
        return contador;
    }

    private void iniciarScanner(){
        try{
            this.lerFormularioPerguntas = new Scanner(new File("formulario.txt"));

        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
    }

    private void encerrarScanner(){
        this.lerFormularioPerguntas.close();
    }



}
