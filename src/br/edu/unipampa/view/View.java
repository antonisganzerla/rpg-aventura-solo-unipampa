package br.edu.unipampa.view;

import br.edu.unipampa.narrativa.Narrativa;

/**
 * View
 *
 * @author Alex
 * @author Antoni Sganzerla
 * @author Edison Moura
 * @author Miguel Zinelli
 * @since 25/01/2013
 * @version 1.0 Classe que contém o método Main
 */
public class View {

    public static void main(String[] args) {
        Narrativa narrativa = new Narrativa();
        narrativa.iniciarJogo();
    }
}
