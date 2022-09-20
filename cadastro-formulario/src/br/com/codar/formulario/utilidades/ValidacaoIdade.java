package br.com.codar.formulario.utilidades;

import java.util.List;

public class ValidacaoIdade {

    public static boolean validarIdade(List<String> respostas){
        int idade;
        try{
            idade = Integer.parseInt(respostas.get(2));
        }catch (NumberFormatException exception){
            System.out.println("Idade com entrada Inválida.");
            return false;
        }

        return idade >= 16;
    }
}
