/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.recursos;

import br.edu.unipampa.cenario.Cenario;
import br.edu.unipampa.cenario.Lugar;

/**
 * Recursos
 *
 * @author Edison Jhonatan R. Moura
 * @since 27/01/2013
 * @version 1.0
 *
 * Classe Ambiente
 */
public class Ambiente extends Recursos {

    /**
     * Método acessor Get do atributo String "nome"
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * Método acessor Set do atributo String "nome"
     * @param nome - Nome que será atribuido ao objeto
     */

    public void setNome(String nome) {
        this.nome = nome;
    }
}
