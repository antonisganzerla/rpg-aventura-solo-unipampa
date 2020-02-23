/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.desafio;

import br.edu.unipampa.personagem.Inimigo;
import br.edu.unipampa.personagem.Mensageiro;
import br.edu.unipampa.personagem.Personagem;
import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class DesafioObjeto extends Desafio {
    
    /**
     * Método desafioLugar chama método verificar
     * 
     * @return verificar - retorna uma das opções, positiva ou negativa em relação ao método;
     */
    
     @Override
    public String desafioLugar(Mensageiro mensageiro, Inimigo inimigo, ArrayList recursos, int n) {
  
        return verificar(mensageiro, recursos);
    }

}
