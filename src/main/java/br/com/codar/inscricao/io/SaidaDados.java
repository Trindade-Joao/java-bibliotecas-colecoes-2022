package br.com.codar.inscricao.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SaidaDados {

    private PrintWriter gravador;


    public void iniciarGravador(String caminhoArquivo, String nomeArquivo){
        try {
            this.gravador = new PrintWriter(caminhoArquivo + nomeArquivo);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public PrintWriter gravador(){
        return this.gravador;
    }

    public void encerrarGravador(){
        this.gravador.close();
    }
}
