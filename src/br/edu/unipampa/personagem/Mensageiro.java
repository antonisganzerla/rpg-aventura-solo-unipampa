package br.edu.unipampa.personagem;

import br.edu.unipampa.cenario.Lugar;
import br.edu.unipampa.recursos.Arma;
import br.edu.unipampa.recursos.Cantil;

/**
 * Mensageiro
 *
 * @author Alex Malmann Becker
 * @since 25/01/2013
 * @version 1.0
 *
 * Classe Persoangem Mensageiro
 */
public class Mensageiro extends Personagem {

    private String mensagem;
    private String previsao;

    /**
     * Método Construtor Default
     */
    public Mensageiro(Lugar inicio) {
        this.forca = 45;
        this.hp = 100;
        this.defesa = 15;
        this.lugarAtual = inicio;
        this.previsao = "";
        super.recursos.add(new Arma("Adaga", 15, "ataque"));
        super.recursos.add(new Cantil("Cantil", 10));
    }

    /**
     * Método que retornará a Mensagem.
     *
     * @return mensagem
     */
    public String getMensagem() {
        return this.mensagem;
    }

    /**
     * Método que setará a Mensagem.
     *
     * @param mensagem passa como parâmetro a Mensagem
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * Método para prever o tempo
     *
     * @param umOuDois passa como parâmetro um randomico que gere 1 ou 2
     */
    public void preverTempo(int umOuDois) {
        if (umOuDois == 1) {
            this.previsao = "SOL";
        } else {
            if (umOuDois == 2) {
                this.previsao = "CHUVA";
            } else {
                this.previsao = "";
            }
        }
    }

    /**
     * Método que verifica o tempo previsto
     *
     * @return tempo {"SOL", "CHUVA", ""}
     */
    public String tempoPrevisto() {
        return this.previsao;
    }
}
