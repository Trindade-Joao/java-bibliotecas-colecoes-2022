package br.com.codar.inscricao.menus;

import br.com.codar.inscricao.formulario.*;
import br.com.codar.inscricao.io.EntradaTeclado;
import br.com.codar.inscricao.perguntas.AdicionaPergunta;
import br.com.codar.inscricao.perguntas.MostraPerguntas;
import br.com.codar.inscricao.perguntas.RemovePergunta;

import java.util.ArrayList;
import java.util.List;

public class SeletorMenu {
    private RespondeFormulario responde;
    private SalvaFormulario salvaFormulario;
    private EntradaTeclado teclado;

    private ListarInscricoes listarInscricoes;


    private boolean funcionando = true;


    public SeletorMenu(EntradaTeclado teclado) {
        this.teclado = teclado;
        this.responde = new RespondeFormulario();
        this.salvaFormulario = new SalvaFormulario();
        this.listarInscricoes = new ListarInscricoes();


    }

    public void selecaoMenu(int entrada) {
        listarInscricoes.carregarLista();



        switch (entrada){
            case 1:
                InterfaceMenu cadastro = new MenuCadastro();
                cadastro.mostrarMenu();
                salvaFormulario.salvar(responde.responder());
                teclado.continuar();

                break;

            case 2:
                AdicionaPergunta adicionaPergunta = new AdicionaPergunta(teclado);
                InterfaceMenu adicionarPergunta = new MenuAdicionarPerguntas();
                adicionarPergunta.mostrarMenu();
                adicionaPergunta.inserirPerguntaNoFormulario();
                teclado.continuar();

                break;

            case 3:
                RemovePergunta removePergunta = new RemovePergunta(teclado);
                InterfaceMenu removePerguntasMenu = new MenuRemoverPerguntas();
                removePerguntasMenu.mostrarMenu();
                MostraPerguntas.mostrar();
                removePergunta.remover();
                teclado.continuar();

                break;

            case 4:
                InterfaceMenu menuListaCandidatos = new MenuListaCandidatos();
                menuListaCandidatos.mostrarMenu();
                SelecaoMenuListarCandidatos selecao = new SelecaoMenuListarCandidatos();
                selecao.selecaoMenu(teclado.entradaNumerica());
                teclado.continuar();
                break;

            case 5:
                InterfaceMenu menuPesquisa = new MenuPequisarFormulariosCadastrados();
                menuPesquisa.mostrarMenu();
                PesquisaFormulario pesquisa = new PesquisaFormulario(teclado);
                List<Inscricoes> listaDeInscricoes = new ArrayList<>();
                listaDeInscricoes = listarInscricoes.getLista();

                pesquisa.imprimirLista(pesquisa.pesquisar(listaDeInscricoes));
                teclado.continuar();


                break;

            case 6:
                InterfaceMenu menuValidar = new MenuValidaFormularios();
                menuValidar.mostrarMenu();
                ValidaFormulario validaFormulario = new ValidaFormulario();
                validaFormulario.imprimir(validaFormulario.validar());
                teclado.continuar();

                break;

            case 7:
                this.funcionando = false;
                break;

            default:
                System.out.println("Entrada inválida");

        }
    }

    public boolean isFuncionando() {
        return funcionando;
    }
}
