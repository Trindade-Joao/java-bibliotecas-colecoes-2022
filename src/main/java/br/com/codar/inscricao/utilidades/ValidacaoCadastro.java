package br.com.codar.inscricao.utilidades;

import java.util.Objects;

public class ValidacaoCadastro {
    String nomeFormulario;
    String nomeInscrito;
    String email;

    public ValidacaoCadastro(String nomeFormulario, String nomeInscrito, String email) {
        this.nomeFormulario = nomeFormulario;
        this.nomeInscrito = nomeInscrito;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidacaoCadastro that = (ValidacaoCadastro) o;
        return Objects.equals(nomeInscrito, that.nomeInscrito) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeInscrito, email);
    }

    public String getNomeFormulario() {
        return nomeFormulario;
    }

    public String getNomeInscrito() {
        return nomeInscrito;
    }

    public String getEmail() {
        return email;
    }


}
