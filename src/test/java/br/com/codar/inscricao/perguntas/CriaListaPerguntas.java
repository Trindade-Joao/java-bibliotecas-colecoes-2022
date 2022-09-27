package br.com.codar.inscricao.perguntas;

import java.util.ArrayList;
import java.util.List;

public class CriaListaPerguntas {

    public static List<String> listarPerguntasTeste(){
        List<String> listaPerguntas = new ArrayList<>();

        listaPerguntas.add("P1|Qual o seu nome completo?");
        listaPerguntas.add("P2|Qual seu e-mail?");
        listaPerguntas.add("P3|Qual sua idade?");
        listaPerguntas.add("P4|Qual seu whatsapp ou celular?");
        listaPerguntas.add("P5|Aqui era a pergunta 5?");
        listaPerguntas.add("P6|Aqui era a pergunta 6?");
        listaPerguntas.add("P7|Aqui era a pergunta 7?");

        return listaPerguntas;
    }
}
