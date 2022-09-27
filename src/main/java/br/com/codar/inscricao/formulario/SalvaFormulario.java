package br.com.codar.inscricao.formulario;

import br.com.codar.inscricao.utilidades.ValidacaoIdade;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class SalvaFormulario {


    private static void salvarRespostas(List<String> respostas) throws FileNotFoundException {


        if (ValidacaoIdade.validarIdade(respostas)){
            PrintWriter formularioSalvo = new PrintWriter("./cadastro-formulario/formularios/");
            respostas.forEach(formularioSalvo::println);
            System.out.println("Salvando formulário");
            formularioSalvo.close();

        }else{
            System.out.println("Muito Obrigado pela sua participação!");
            System.out.println("Infelizmente a idade miníma para a participação é de 16 anos.");
            System.out.println("Tente se cadastrar novamente após atingir a idade permitida.");
        }


    }
}
