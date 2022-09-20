package br.com.codar.formulario.menus;

import br.com.codar.formulario.utilidades.TratamentoNomeFormulario;
import br.com.codar.formulario.utilidades.ValidacaoIdade;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
            System.out.printf("=> ");
            respostas.add(resposta());
            System.out.println();
        }
        try{
            MenuCadastro.salvarRespostas(respostas);
        }catch (FileNotFoundException exception){
            exception.printStackTrace();
        }

        this.leitorPerguntas.close();
    }

    private static void salvarRespostas(List<String> respostas) throws FileNotFoundException {


        if (ValidacaoIdade.validarIdade(respostas)){
            PrintWriter formularioSalvo = new PrintWriter("./formularios/" + nomeDoFormulario(respostas));
            respostas.forEach(formularioSalvo::println);
            System.out.println("Salvando formulário");
            formularioSalvo.close();

        }else{
            System.out.println("Muito Obrigado pela sua participação!");
            System.out.println("Infelizmente a idade miníma para a participação é de 16 anos.");
            System.out.println("Tente se cadastrar novamente após atingir a idade permitida.");
        }


    }

    private String resposta() {
        return this.entradaTeclado.nextLine();
    }

    private static String nomeDoFormulario(List<String> respostas){
        String nome = TratamentoNomeFormulario.tratarNome(respostas.get(0));
        int numeroDoFormulario = TratamentoNomeFormulario.numeroFormulario() + 1;
        return numeroDoFormulario + "-" + nome;
    }

}
