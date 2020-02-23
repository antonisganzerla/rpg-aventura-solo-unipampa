package br.edu.unipampa.cenario;

import br.edu.unipampa.desafio.Desafio;
import br.edu.unipampa.personagem.Amigo;
import br.edu.unipampa.personagem.Inimigo;
import br.edu.unipampa.personagem.Mensageiro;
import br.edu.unipampa.recursos.Recursos;
import java.util.ArrayList;

/**
 * @author Antoni Sganzerla
 * @version 1.0
 */
public class Lugar {

    private String nome;
    private ArrayList<Recursos> listaDeRecursos;
    private Desafio desafio;
    private Inimigo inimigo;
    private Amigo amigo;
    private ArrayList<Lugar> vizinhos;
    private boolean fim;
    private int distancia;

    /**
     * Método construtor que inicializa o objeto com os seguintes atributos:
     * @param nome, designar um nome ao Lugar.
     * @param challenge, designar um desafio, caso não possua usar null.
     * @param inimigo, designar um inimigo, caso não possua usar null.
     * @param amigo, designar um amigo, caso não possua usar null.
     * @param recursos, designar uma lista de recursos para o lugar, caso este
     * não possua nenhum usar null.
     * @param distancia, designar qual a distância (quantos lugares a percorrer
     * até o fim) do ultimo Lugar.
     */
    public Lugar(String nome, Desafio challenge, Inimigo inimigo, Amigo amigo, ArrayList<Recursos> recursos, int distancia) {
        this.listaDeRecursos = recursos;
        this.inimigo = inimigo;
        this.amigo = amigo;
        this.nome = nome;
        this.desafio = challenge;
        this.vizinhos = new ArrayList<>();
        this.fim = false;
        this.distancia = distancia;
    }

    /**
     * Método que atribui quais os acessos de um determinado Lugar.
     *
     * @param direita, designar qual o lugar de acesso a direita
     * @param esquerda, designar qual o lugar de acesso a esquerda
     * @param acima, designar qual o lugar de acesso acima
     * @param abaixo, designar qual o lugar de acesso abaixo
     */
    public void atribuirVizinhos(Lugar direita, Lugar esquerda, Lugar acima, Lugar abaixo) {
        vizinhos.add(direita);
        vizinhos.add(esquerda);
        vizinhos.add(acima);
        vizinhos.add(abaixo);
    }

    /**
     * Método responsável por executar os eventos de um determinado local, sendo
     * que este é definido pela posição do mensageiro.
     *
     * @param mensageiro, deve receber um tipo de Mensageiro para acesso a seus
     * métodos e a posição
     * @param numCharada numero sorteado pelo random para compor a charada
     * @return retorna uma mensagem referente ao desafio executado
     */
    public String executarLugar(Mensageiro mensageiro, int numCharada) {
        String saida = desafio.desafioLugar(mensageiro, inimigo, listaDeRecursos, numCharada);
        return saida;
    }

    /**
     * Método de acesso a lista de recursos do Lugar
     * @return the listaDeRecursos
     */
    public ArrayList<Recursos> getListaDeRecursos() {
        return listaDeRecursos;
    }

    /**
     * Método de acesso ao nome do Lugar
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método de acesso ao desafio ao Lugar
     * @return the desafio
     */
    public Desafio getDesafio() {
        return desafio;
    }

    /**
     * Método de acesso a lista de vizinhos de cada Lugar
     * @return the vizinhos
     */
    public ArrayList<Lugar> getVizinhos() {
        return vizinhos;
    }

    /**
     * Método de acesso ao atributo fim do jogo
     * @return the fim
     */
    public boolean isFim() {
        return fim;
    }
    
    /**
     * Método atribuição ao boolean fim
     * @param fim true ou false
     */
    public void setFim(boolean fim) {
        this.fim = fim;
    }

    /**
     * Método de acessoa a distancia do Lugar até o Cenario final
     * @return the distancia
     */
    public int getDistancia() {
        return distancia;
    }

    /**
     * Método de acesso ao Inimigo do Lugar
     * @return the inimigo
     */
    public Inimigo getInimigo() {
        return inimigo;
    }

    /**
     * Método de acesso ao Amigo do Lugar
     * @return the amigo
     */
    public Amigo getAmigo() {
        return amigo;
    }
}
