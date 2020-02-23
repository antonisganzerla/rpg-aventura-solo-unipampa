/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.desafio;

import br.edu.unipampa.personagem.Inimigo;
import br.edu.unipampa.personagem.Mensageiro;
import java.util.ArrayList;

/**
 *  
 * @author Miguel
 */
public class DesafioCharada extends Desafio {

    /**
     * Método sobrescrito para executar charada
     *
     * Basicamente esse método recebe o numCharada do mensageiro no parâmetro, e apenas faz o teste do if.
     * @return saída
     */
    @Override
    public String desafioLugar(Mensageiro mensageiro, Inimigo inimigo, ArrayList recursos, int n) {
        super.numCharada = n;
        String saida = "";
        
        if (super.numCharada == 0) {
            saida = "Cidade onde se passa a história?";
        } else if (super.numCharada == 1) {
            saida = "Quanto é 2^8?";
        } else {
            saida = "Qual o estado mais bonito do Brasil?";
        }
        return saida;
    }

}
