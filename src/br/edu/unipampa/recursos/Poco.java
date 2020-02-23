/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.recursos;

import br.edu.unipampa.cenario.Lugar;

/**
 * Recursos
 *
 * @author Edison Jhonatan R. Moura
 * @since 27/01/2013
 * @version 1.0
 *
 * Classe Poco
 */
public class Poco extends Ambiente{
   
    /**
     * Método contrutor do objeto do tipo Poco
     * @param nome - Nome atribuido ao objeto do tipo Poco
     */
    public Poco(String nome){
        this.nome = nome;
    }
    /**
     * Método que enche um cantil após passar pelo "Poço"
     * @param cantil - Objeto do tipo Cantil que será preenchido
     */
    public void passarPoco(Cantil cantil){
        cantil.encherCantil(cantil);
    }
    
}
