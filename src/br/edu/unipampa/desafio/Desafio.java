package br.edu.unipampa.desafio;

import br.edu.unipampa.personagem.Inimigo;
import br.edu.unipampa.personagem.Mensageiro;
import br.edu.unipampa.personagem.Personagem;
import java.util.ArrayList;
import java.util.Random;

/**
 * Desafio
 *
 * @author Miguel J Zinelli
 * @since 25/01/2013
 * @version 1.0
 *
 * Classe Desafio
 */
public class Desafio {

    private String descricao;
    protected int numCharada;
    private boolean completado;

    /**
     * Método que retorna uma mensagem positiva ou negativa, em relação ao
     * desafio.
     *
     * @param Mensageiro - Possui arraylist de recursos do mensageiro.
     * @param ArrayList recursos - arrayList que contém os recursos para comparação.
     * 
     * @return mensagem de acordo com a comparação.
     */
    public String verificar(Mensageiro mensageiro, ArrayList recursos) {
        if (mensageiro.getRecursos().containsAll(recursos)) {
            return "Parabéns, você tem o recurso necessário para concluir o desafio!";
        } else {

            return "Infelizmente você não tem o recurso necessário, e acabou de morrer.";
        }
    }

    /**
     * Método que retornará a descrição do desafio.
     *
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Método que setará a descrição para desafio.
     *
     * @param descricao passa como parâmetro a descricao;
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Método que contém um construtor default, para sobrescrever esse método.
     *
     * @param Mensageiro passa como parâmetro o mensageiro;
     * @param Inimigo passar como parâmetro um inimigo;
     * @param Arraylist passa como parâmetro um arrayList de recursos;
     * @param Int para como parâmetro um inteiro;
     */
    public String desafioLugar(Mensageiro mensageiro, Inimigo inimigo, ArrayList recursos, int n) {
        return "";
    }

    /**
     * @return o numero da charada
     */
    public int getNumCharada() {
        return numCharada;
    }

    /**
     * @return se o desafio foi completo
     */
    public boolean isCompletado() {
        return completado;
    }

    /**
     * @param completado para definir se está completo
     */
    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    /**
     * Método que serve para definir qual a charada vai ser feita.
     */
    public int sorteiaNumeroCharada() {
        Random p = new Random();
        int n = p.nextInt(3);
        return n;
    }
}
