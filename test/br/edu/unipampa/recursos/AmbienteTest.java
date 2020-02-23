/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.recursos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Owner
 */
public class AmbienteTest {
    
    public AmbienteTest() {
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
     * Test of getNome method, of class Ambiente.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Ambiente instance = new Ambiente();
        instance.setNome("teste");
        String result = instance.getNome();
        assertEquals("teste", instance.getNome());
    }

    /**
     * Test of setNome method, of class Ambiente.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        Ambiente instance = new Ambiente();
        instance.setNome("teste");
        assertEquals("teste", instance.getNome());
    }
}
