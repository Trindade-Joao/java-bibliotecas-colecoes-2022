package br.com.codar.inscricao.formulario;

import br.com.codar.inscricao.io.EntradaDados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CriaListaInscricoes {
    EntradaDados entrada = new  EntradaDados();

    public  List<Inscricoes> criarComRepeticao(){
        entrada.iniciarLeitor("./gera-formularios-possui-repeticao.csv");
        List<Inscricoes> listaComRepeticao = criar();
        entrada.encerrarLeitor();
        return listaComRepeticao;
    }

    public List<Inscricoes> criarSemRepeticao(){
        entrada.iniciarLeitor("./gera-formulario-sem-repeticao.csv");
        List<Inscricoes> listaSemRepeticao = criar();
        entrada.encerrarLeitor();
        return listaSemRepeticao;
    }

    private List<Inscricoes> criar(){
        List<Inscricoes> listaFormularios = new ArrayList<>();
        while(entrada.getLeitor().hasNextLine()){
            String linha = entrada.getLeitor().nextLine();
            List<String> respostas = new ArrayList<>();
            Scanner separaDados = new Scanner(linha);
            separaDados.useDelimiter(",");
            String nomeFormulario = separaDados.next();
            for (int i = 0; i < 4; i++){
                respostas.add(separaDados.next());
            }
            listaFormularios.add(new Inscricoes(nomeFormulario, respostas));
        }
        return Collections.unmodifiableList(listaFormularios);
    }
}
