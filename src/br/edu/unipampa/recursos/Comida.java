/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.recursos;

/**
 * Recursos
 *
 * @author Edison Jhonatan R. Moura
 * @since 27/01/2013
 * @version 1.0
 *
 * Classe Comida
 */
public class Comida extends Ambiente {
    
    private int hp;
    /**
     * Método construtor do objeto do tipo Comida
     * @param nome - Nome que será atribuido ao objeto do tipo Comida
     * @param hp - hp (pontos de vida) que será atribuido ao objeto do tipo Comida
     */
    public Comida(String nome, int hp){
        this.nome = nome;
        this.hp = hp;
    }
    /**
     * Método acessor Get do Hp atribuido ao objeto do tipo Comida
     * @return hp
     */
    public int getHp() {
        return hp;
    }
    
}
