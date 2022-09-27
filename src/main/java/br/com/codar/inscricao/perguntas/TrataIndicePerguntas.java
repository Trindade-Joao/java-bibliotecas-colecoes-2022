package br.com.codar.inscricao.perguntas;

public class TrataIndicePerguntas {

    public static String adicionar(int numeroDaPergunta){
        return "P" + numeroDaPergunta + "|";
    }

    public static String remover(String perguntaComIndice){
        int posicaoDaBarra = perguntaComIndice.indexOf("|") + 1;
        return perguntaComIndice.substring(posicaoDaBarra);
    }

    public static String reorganizar(int numeroDaPergunta, String pergunta){
        String perguntaSemIndice = remover(pergunta);
        return adicionar(numeroDaPergunta + 1) + perguntaSemIndice;
    }


}
