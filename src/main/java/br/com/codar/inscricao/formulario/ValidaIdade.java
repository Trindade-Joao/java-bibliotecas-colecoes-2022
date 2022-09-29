package br.com.codar.inscricao.formulario;

public class ValidaIdade {

    public boolean validar(String resposta){
        int idade;
        try{
            idade = Integer.parseInt(resposta);
        }catch (NumberFormatException exception){
            System.out.println("Idade com entrada Inválida.");
            return false;
        }
        return idade >= 16;
    }
}
