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
 * Classe Arma
 */
public class Arma extends Pessoal{
    
    private String categoria;
    /**
     * Metodo Construtor de objetos do tipo Arma
     *
     * @param nome - Nome atribuido ao objeto do tipo Arma
     * @param forca - Forca que será atribuida à arma (objeto)
     * @param categoria - Categoria atribuida à arma, "defesa" ou "ataque"
     */
    public Arma(String nome, int forca, String categoria){
        this.nome = nome;
        this.forca = forca;
        this.categoria = categoria;
    }

    /**
     * Método acessor get, para retonar o valor da categoria
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Método acessor set, para atribuir um valor à String categoria
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
