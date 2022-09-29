package br.com.codar.inscricao.formulario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscricoes {
    private String nomeFormulario;
    private List<String> respostas = new ArrayList<>();

    public Inscricoes(String nomeFormulario, List<String> respostas){
        this.nomeFormulario = nomeFormulario;
        this.respostas = respostas;
    }

    public String getNomeFormulario() {
        return nomeFormulario;
    }

    public List<String> getRespostas() {
        return Collections.unmodifiableList(respostas);
    }

    @Override
    public String toString() {
        return this.nomeFormulario;
    }
}
