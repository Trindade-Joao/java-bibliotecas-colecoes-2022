package br.com.codar.inscricao.formulario;

import br.com.codar.inscricao.io.SaidaDados;

import java.util.List;

public class SalvaFormulario {

    private SaidaDados saidaDados;
    private String caminhoArquivo = "./formularios-cadastrados/";

    private ValidaIdade validaIdade;

    public SalvaFormulario() {
        this.saidaDados = new SaidaDados();
        this.validaIdade = new ValidaIdade();
    }

    public SalvaFormulario(SaidaDados saidaDados, String caminhoArquivo) {
        this.saidaDados = saidaDados;
        this.caminhoArquivo = caminhoArquivo;

    }

    public void salvar(List<String> respostas){
        String nomeFormulario = NomeiaFormulario.nomear(respostas);
        if(validaIdade.validar(respostas.get(2))){
            saidaDados.iniciarGravador(caminhoArquivo, nomeFormulario);
            respostas.forEach(saidaDados.gravador()::println);
            saidaDados.encerrarGravador();
        }else {
            System.out.println("""
                              Muito Obrigado pela sua participação!
                    Infelizmente a idade mínima para a participação é de 16 anos.
                    Tente se cadastrar novamente após atingir a idade permitida.
                    """);
        }
    }

}
