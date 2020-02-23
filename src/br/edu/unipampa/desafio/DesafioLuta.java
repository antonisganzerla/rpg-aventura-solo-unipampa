/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.desafio;

import br.edu.unipampa.personagem.Inimigo;
import br.edu.unipampa.personagem.Mensageiro;
import br.edu.unipampa.personagem.Personagem;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Miguel
 */
public class DesafioLuta extends Desafio {

    private boolean inimigoAtaca;

    /**
     * Método para realizar luta
     *
     * @param Inimigo passa como parâmetro um personagem do tipo inimigo;
     * @return String, alguma das opcções de acordo com a realização do combate
     */
    @Override
    public String desafioLugar(Mensageiro mensageiro, Inimigo inimigo, ArrayList recursos, int n) {
        String saida = "";
        mensageiro.setDano(definirAtaque(mensageiro.getForca()));
        inimigo.setDano(definirAtaque(inimigo.getForca()));
        if (inimigoAtaca == false) {
            saida = turnoAtaqueMensageiro(mensageiro, inimigo);
            inimigoAtaca = true;
        } else {
            saida = turnoAtaqueInimigo(mensageiro, inimigo);
            inimigoAtaca = false;
        }

        if (mensageiro.getHp() <= 0) {
            saida = saida + "\n*** Você acabou morrendo durante a batalha ***";
        }
        if (inimigo.getHp() <= 0) {
            saida = saida + "\n*** Parabéns, você venceu a batalha ***";
            inimigoAtaca = false;
        }
        return saida;
    }
     /**
     * Método para escolher um valor inteiro aleartório para representar a força de ataque da luta
     *
     * @param forca passa como parâmetro um inteiro que representa a força;
     * @return ataque, a quantidade de força sorteada
     */

    public int definirAtaque(int forca) {
        Random ataque = new Random();
        return ataque.nextInt(forca);
    }

    /**
     * Método para apresentar a mensagem de acordo com o turno do jogador.
     *
     * @param Mensageiro o passa como parâmetro o mensageiro;
     * @param Pensonagem inimigo passa como parâmetro inimigo;
     * @return retorno mensagem de acordo com a batalha.
     */
    public String turnoAtaqueMensageiro(Mensageiro mensageiro, Personagem inimigo) {
        String retorno = "";
        if (mensageiro.getHp() > 0) {
            if (mensageiro.getDano() > inimigo.getDefesa()) {
                int dano = mensageiro.getDano() - inimigo.getDefesa();
                inimigo.setHp(inimigo.getHp() - dano);
                if (inimigo.getHp() < 0) {
                    inimigo.setHp(0);
                }
                retorno = "Você tirou " + dano + " do seu inimigo... "
                        + inimigo.getNome() + " está com " + inimigo.getHp() + " de vida";
            } else {
                retorno = inimigo.getNome() + " bloqueou seu ataque";
            }
        }
        return retorno;
    }

    /**
     * Método para apresentar a mensagem de acordo com o turno do inimigo.
     *
     * @param Mensageiro o passa como parâmetro o mensageiro;
     * @param Pensonagem inimigo passa como parâmetro inimigo;
     * @return retorno mensagem de acordo com a batalha.
     */
    public String turnoAtaqueInimigo(Mensageiro mensageiro, Personagem inimigo) {
        String retorno = "";
        if (inimigo.getHp() > 0) {
            if (inimigo.getDano() > mensageiro.getDefesa()) {
                int dano = inimigo.getDano() - mensageiro.getDefesa();
                mensageiro.setHp(mensageiro.getHp() - dano);
                if (mensageiro.getHp() < 0) {
                    mensageiro.setHp(0);
                }
                retorno = "Você perdeu " + dano + " de vida."
                        + " Você está com " + mensageiro.getHp() + " de hp";
            } else {
                retorno = "Você bloqueou o ataque.";
            }
        }
        return retorno;
    }
}
