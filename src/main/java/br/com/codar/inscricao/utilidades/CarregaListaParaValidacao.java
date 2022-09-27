package br.com.codar.inscricao.utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarregaListaParaValidacao {
    private List<File> listaFormularios;
    private List<ValidacaoCadastro> listaDeValidacao;

    public CarregaListaParaValidacao(){
        File formularios = new File("./cadastro-formulario/formularios");
        this.listaFormularios = new ArrayList<>(List.of(formularios.listFiles()));
        this.listaDeValidacao = new ArrayList<>();
    }

    public  List<ValidacaoCadastro> carregarListas(){
        listaFormularios.forEach(formulario -> {
            try{
                Scanner leitorFormulario = new Scanner(new File(formulario.toString()));
                String nomeFormulario = formulario.toString();
                String nomeInscrito = leitorFormulario.nextLine();
                String email = leitorFormulario.nextLine();
                listaDeValidacao.add(new ValidacaoCadastro(nomeFormulario, nomeInscrito, email));
                leitorFormulario.close();
            }catch (FileNotFoundException exception){
                exception.printStackTrace();
            }
        });

        return this.listaDeValidacao;
    }
}
