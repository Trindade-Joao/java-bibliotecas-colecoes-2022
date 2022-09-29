package br.com.codar.inscricao.formulario;

import java.util.ArrayList;
import java.util.List;

public class ListaFomulariosRespondidosTeste {

    public static List<Inscricoes> criar(){
        List<Inscricoes> listaFormulariosRespondidos = new ArrayList<>();

        List<String> listaRespostas1 = new ArrayList<>();
        listaRespostas1.add("Fulano da Silva");
        listaRespostas1.add("fulano@gmail.com");
        listaRespostas1.add("18");
        listaRespostas1.add("111111111");

        Inscricoes formulario1 = new Inscricoes("1-FULANODASILVA.txt", listaRespostas1);

        listaFormulariosRespondidos.add(formulario1);


        List<String> listaRespostas2 = new ArrayList<>();
        listaRespostas2.add("Ciclano de Souza");
        listaRespostas2.add("ciclano@gmail.com");
        listaRespostas2.add("89");
        listaRespostas2.add("2222222222");

        Inscricoes formulario2 = new Inscricoes("2-CICLANODESOUZA.txt", listaRespostas2);

        listaFormulariosRespondidos.add(formulario2);

        Inscricoes formulario3 = new Inscricoes("3-FULANODASILVA.txt", listaRespostas1);

        Inscricoes formulario4 = new Inscricoes("4-FULANODASILVA.txt", listaRespostas2);

        listaFormulariosRespondidos.add(formulario3);
        listaFormulariosRespondidos.add(formulario4);

        return listaFormulariosRespondidos;
    }
}
