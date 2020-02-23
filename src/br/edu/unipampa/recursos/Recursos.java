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
 * Classe Recursos
 */
public class Recursos {

    protected String nome;
    protected int quantidade;
    /*
     * Método construtor vazio
     */
    public Recursos(){
        
    }
    /**
     * Método construtor do objeto do tipo Recursos
     * @param nome - Nome atribuido ao objeto do tipo Recursos
     * @param quantidade - Número da quantidade de recursos do Objeto do tipo Recurso
     */
    public Recursos(String nome, int quantidade){
        this.nome=nome;
        this.quantidade=quantidade;
    }
    /**
     * Método acessor Get do atributo inteiro "quantidade"
     * @return quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }
    /**
     * Método acessor Set do atributo inteiro "quantidade"
     * @param quantidade - Número de recursos do Objeto disponivel
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    /**
     * Método acessor Get do atributo string "nome"
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * Método acessor Set do atributo string "quantidade"
     * @param nome - Nome do Objeto do tipo Recursos
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
