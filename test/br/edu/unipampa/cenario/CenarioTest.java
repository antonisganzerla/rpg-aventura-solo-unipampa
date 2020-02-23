/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.cenario;

import br.edu.unipampa.desafio.Desafio;
import br.edu.unipampa.desafio.DesafioLuta;
import br.edu.unipampa.desafio.DesafioObjeto;
import br.edu.unipampa.personagem.Inimigo;
import br.edu.unipampa.recursos.Arma;
import br.edu.unipampa.recursos.Recursos;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anton_000
 */
public class CenarioTest {

    public CenarioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInicio method, of class Cenario.
     */
    @Test
    public void testGetInicio() {
        System.out.println("getInicio");
        Desafio luta = new DesafioLuta();
        Arma escudo1 = new Arma("Escudo Imperial", 15, "defesa");
        Inimigo inimigo1 = new Inimigo("Espartano", 40, 45, escudo1, 35);
        Lugar inicio = new Lugar("Inicio da aventura", luta, inimigo1, null, null, 4);

        Cenario instance = new Cenario(inicio);
        Lugar expResult = inicio;
        Lugar result = instance.getInicio();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetInicio2() {
        System.out.println("getInicio");
        Desafio luta = new DesafioLuta();
        Arma machado = new Arma("Machado do Julgamento Final", 50,"ataque");
        Inimigo inimigoFim = new Inimigo("Picollo", 80, 70, machado,55);
        Lugar fim = new Lugar("Sede de Alegrete", luta, inimigoFim, null, null, 0);
        fim.setFim(true);
        Cenario instance = new Cenario(fim);
        Lugar expResult = fim;
        Lugar result = instance.getInicio();
        assertEquals(expResult, result);
    }
}
