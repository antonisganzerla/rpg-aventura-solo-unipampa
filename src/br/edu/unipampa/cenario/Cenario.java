
package br.edu.unipampa.cenario;

/**
 *
 * @author Antoni Sganzerla
 * @since 26/01/2013
 * @version 1.0
 */

public class Cenario {
    
   
    
    private Lugar inicio;
    /**
     * Método construtor do Cenario
     * @param comeco designar o lugar inicial, por meio deste pode-se acessar os demais
     */
     public Cenario(Lugar comeco){
        inicio = comeco;
    }

    /**
     * Método de acesso ao Lugar Inicial
     * @return the inicio
     */
    public Lugar getInicio() {
        return inicio;
    }    
}
