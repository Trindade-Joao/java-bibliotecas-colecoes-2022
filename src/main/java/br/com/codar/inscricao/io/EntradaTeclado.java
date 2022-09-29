package br.com.codar.inscricao.io;

import java.util.Scanner;

public class EntradaTeclado {
    private final Scanner teclado;

    public EntradaTeclado() {
        this.teclado = new Scanner(System.in);
    }


    public int entradaNumerica(){
        try {
            System.out.print("=> ");
            int numero = Integer.parseInt(this.teclado.next());
            teclado.nextLine();
            return numero;
        } catch (NumberFormatException e){
            teclado.nextLine();
            System.out.println("Entrada Inválida");
            entradaNumerica();
        }
        return 0;
    }

    public String entradaAlfaNumerica(){

        return this.teclado.nextLine();
    }

    public void continuar(){
        System.out.printf("%nPressione Enter para continuar");
            teclado.nextLine();

    }

    public void encerrarTeclado(){
        this.teclado.close();
    }
}
