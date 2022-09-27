package br.com.codar.inscricao.utilidades;

import java.util.Scanner;

public class ValidacaoEntradaNumerica {

    public static int digitarNumero(){
        Scanner teclado = new Scanner(System.in);
        int numero;

        System.out.print("=> ");

        try {
            numero = Integer.parseInt(teclado.next());
        }catch (NumberFormatException exception){
            numero = 0;
        }
//        teclado.close();
        return numero;
    }


}
