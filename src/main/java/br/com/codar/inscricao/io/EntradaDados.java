package br.com.codar.inscricao.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EntradaDados {

    private Scanner leitor;



    public void iniciarLeitor(String caminhoArquivo, String nomeArquivo){
        try{
            this.leitor = new Scanner(new File(caminhoArquivo + nomeArquivo));
        } catch(FileNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public void iniciarLeitor(String nomeArquivo){
        try{
            this.leitor = new Scanner(new File(nomeArquivo));
        } catch(FileNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public Scanner getLeitor() {
        return leitor;
    }

    public void encerrarLeitor(){
        this.leitor.close();
    }
}
