package br.edu.unipampa.personagem;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Mensageiro
 *
 * @author Alex Malmann Becker
 * @since 25/01/2013
 * @version 1.0
 *
 * Teste Classe Persoangem Mensageiro
 */
public class MensageiroTest {

    /**
     * Método Construtor Default
     */
    public MensageiroTest() {
    }

    /**
     * Testando o método getMensagem
     *
     */
    @Test
    public void testGetMensagem() {
        System.out.println("Testando o método getMensagem da classe Mensageiro");
        Mensageiro instance = new Mensageiro(null);
        instance.setMensagem("mensagem x");
        assertEquals("mensagem x", instance.getMensagem());
    }

    /**
     * Testando o método setMensagem
     *
     */
    @Test
    public void testSetMensagem() {
        System.out.println("Testando o método setMensagem da classe Mensageiro");
        Mensageiro instance = new Mensageiro(null);
        instance.setMensagem("mensagem y");
        assertEquals("mensagem y", instance.getMensagem());
    }

    /**
     * Testando o método preverTempoETempoPrevisto
     *
     */
    @Test
    public void testPreverTempoETempoPrevisto() {
        System.out.println("Testando o método preverTempoETempoPrevisto da classe Mensageiro");
        Mensageiro instance = new Mensageiro(null);
        instance.preverTempo(1);
        assertEquals("SOL", instance.tempoPrevisto());
        instance.preverTempo(2);
        assertEquals("CHUVA", instance.tempoPrevisto());
        instance.preverTempo(0);
        assertEquals("", instance.tempoPrevisto());
        instance.preverTempo(3);
        assertEquals("", instance.tempoPrevisto());
    }
}
