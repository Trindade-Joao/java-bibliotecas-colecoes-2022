package br.com.codar.inscricao.utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AgrupaCandidatosPorIdade {

    private Scanner leitorFormulario;
    private List<File> listaDeArquivos;

    private Set<Integer> idades;

    Map<Integer, List<String>> mapaCadastrosIdade;


    public AgrupaCandidatosPorIdade(){
        File arquivosNaPasta = new File("./cadastro-formulario/formularios");
        this.listaDeArquivos = new ArrayList<>(List.of(arquivosNaPasta.listFiles()));

        this.idades = new TreeSet<>();
        mapaCadastrosIdade = new TreeMap<>();

        pegarIdadeDosFormularios();
        agruparCandidatosPorIdade();
    }

    public void agruparCandidatosPorIdade(){
        idades.forEach(idade -> {
            List<String> nomes = new ArrayList<>();

            this.listaDeArquivos.forEach(arquivo ->{
                List<String> listaRespostas = new ArrayList<>();
                iniciarScanner(arquivo.toString());
                while(this.leitorFormulario.hasNextLine()){
                    listaRespostas.add(leitorFormulario.nextLine());
                }
                if(idade.equals(Integer.parseInt(listaRespostas.get(2)))){
                    nomes.add(listaRespostas.get(0));
                }
                this.leitorFormulario.close();
            });
            this.mapaCadastrosIdade.put(idade, nomes);
        });

    }

    private void pegarIdadeDosFormularios(){
        this.listaDeArquivos.forEach(arquivo -> {
            List<String> listaRespostas = new ArrayList<>();
            iniciarScanner(arquivo.toString());
            while(this.leitorFormulario.hasNextLine()){
                listaRespostas.add(leitorFormulario.nextLine());
            }
            idades.add(Integer.parseInt(listaRespostas.get(2)));
            this.leitorFormulario.close();
        });
    }

    private void iniciarScanner(String nomeDoArquivo){
        try{
            this.leitorFormulario = new Scanner(new File(nomeDoArquivo));
        }catch (FileNotFoundException exception){
            exception.printStackTrace();
        }

    }

    public void imprimirNomePorIdade(){
        mapaCadastrosIdade.forEach((idade, nome) ->{
            System.out.printf("%n%d anos%n-------------------------%n", idade);
            nome.forEach(System.out::println);
        });
    }

    public void imprimirQuantidadeCandidatosPorIdade(){
        mapaCadastrosIdade.forEach((idade, nome) ->{
            System.out.println(idade + " anos: " +nome.size() + " Candidato(s).");
        });
    }

}
