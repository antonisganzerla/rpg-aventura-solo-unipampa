/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.recursos;

import br.edu.unipampa.personagem.Mensageiro;

/**
 * Recursos
 *
 * @author Edison Jhonatan R. Moura
 * @since 27/01/2013
 * @version 1.0
 *
 * Classe Cantil
 */
public class Cantil extends Pessoal {

    private int agua;
    /**
     * Método construtor de objeto do tipo Cantil
     * @param nome - Armazena o nome dado ao objeto Canoa
     * @param agua - Quantidade inicial de agua dentro do cantil
     */

    public Cantil(String nome, int agua) {
        this.nome = nome;
        super.setQuantidade(agua);
    }
    /**
     * Método para encher o objeto do tipo Cantil
     * @param obj - Objeto do tipo Cantil que será preenchido com "agua"
     */

    public void encherCantil(Cantil obj) {
        for (agua = obj.getAgua(); agua < 10; agua++) {
            agua = agua;
        }

    }
    /**
     * Método para remover "agua" do objeto do tipo Cantil
     * @param obj - Objeto do tipo Cantil que será descontado a "agua"
     */

    public void descontaCantil(Cantil obj) {
        if (obj.getAgua() > 0) {
            obj.setAgua(obj.getAgua() - 1);
        }
    }

    /**
     * Método acessor Get do atributo inteiro Agua
     * @return agua
     */
    public int getAgua() {
        return agua;
    }

    /**
     * Método acessor Set do atributo inteiro Agua
     * @param agua - Valor inteiro que representa a àgua
     */
    public void setAgua(int agua) {
        this.agua = agua;
    }
}
