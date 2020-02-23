/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.desafio;

import br.edu.unipampa.personagem.Inimigo;
import br.edu.unipampa.personagem.Mensageiro;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miguel
 */
public class DesafioCharadaTest {
    
    public DesafioCharadaTest() {
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
     * Test of desafioLugar method, of class DesafioCharada.
     */
    @Test
    public void testDesafioLugar() {
        System.out.println("desafio Charada");
        Mensageiro mensageiro = new Mensageiro(null);
        Inimigo inimigo = new Inimigo("teste", 10, 10, null, 10);
        ArrayList recursos = new ArrayList();
        int n = 0;
        DesafioCharada instance = new DesafioCharada();
        String expResult = "Quanto é 2^8?";
        String result = instance.desafioLugar(mensageiro, inimigo, recursos, 1);
        assertEquals(expResult, result);
         }
    @Test
    public void testDesafioLugar1() {
        System.out.println("desafio Charada");
        Mensageiro mensageiro = new Mensageiro(null);
        Inimigo inimigo = new Inimigo("teste", 10, 10, null, 10);
        ArrayList recursos = new ArrayList();
        int n = 0;
        DesafioCharada instance = new DesafioCharada();
        String expResult = "Cidade onde se passa a história?";
        String result = instance.desafioLugar(mensageiro, inimigo, recursos, 0);
        assertEquals(expResult, result);
         }
    @Test
    public void testDesafioLugar2() {
        System.out.println("desafio Charada");
        Mensageiro mensageiro = new Mensageiro(null);
        Inimigo inimigo = new Inimigo("teste", 10, 10, null, 10);
        ArrayList recursos = new ArrayList();
        int n = 0;
        DesafioCharada instance = new DesafioCharada();
        String expResult = "Qual o estado mais bonito do Brasil?";
        String result = instance.desafioLugar(mensageiro, inimigo, recursos, 2);
        assertEquals(expResult, result);
         }
}
