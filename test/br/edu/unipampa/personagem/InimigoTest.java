package br.edu.unipampa.personagem;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Inimigo
 *
 * @author Alex Malmann Becker
 * @since 30/01/2013
 * @version 1.0
 *
 * Teste Classe Persoangem Inimigo
 */
public class InimigoTest {

    /**
     * Método Construtor Default
     */
    public InimigoTest() {
    }

    /**
     * Testando o método construtor com parâmetros
     *
     */
    @Test
    public void testInimigoComParametros() {
        System.out.println("Testando o método construtor com parâmetros da classe Inimigo");
        Inimigo instance = new Inimigo("Inimigo x", 30, 70, null, 40);
        assertEquals("Inimigo x", instance.getNome());
        assertEquals(30, instance.getForca());
        assertEquals(70, instance.getHp());
        assertEquals(40, instance.getDefesa());
    }
}
