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
 * Classe Pessoal
 */
public class Pessoal extends Recursos {
    protected int forca;
    /**
     * Método acessor Get ao atributo do tipo String nome
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * Método acessor Set da String nome
     * @param nome - Nome atribuido ao objeto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Método acessor Get ao atributo do tipo int forca
     * @return forca
     */
    public int getForca() {
        return forca;
    }
    /**
     * Método acessor Set do valor int forca
     * @param forca - Forca atribuida ao objeto
     */
    public void setForca(int forca) {
        this.forca = forca;
    }
    
    
}
