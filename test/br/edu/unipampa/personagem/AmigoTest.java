package br.edu.unipampa.personagem;

import br.edu.unipampa.recursos.Canoa;
import br.edu.unipampa.recursos.Recursos;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Amigo
 *
 * @author Alex Malmann Becker
 * @since 30/01/2013
 * @version 1.0
 *
 * Teste Classe Persoangem Amigo
 */
public class AmigoTest {

    /**
     * Método Construtor Default
     */
    public AmigoTest() {
    }

    /**
     * Testando o método construtor com parâmetros
     *
     */
    @Test
    public void testAmigoComParametros() {
        System.out.println("Testando o método construtor com parâmetros da classe Amigo");
        Canoa canoa = new Canoa("Canoa");
        ArrayList<Recursos> recursos = new ArrayList<>();
        recursos.add(canoa);
        Amigo instance = new Amigo("amigo", canoa);
        assertEquals("amigo", instance.getNome());
        assertEquals(recursos, instance.getRecursos());
    }
}
