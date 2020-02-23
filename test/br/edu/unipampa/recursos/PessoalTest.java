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
 * @author jhonatan
 */
public class PessoalTest {
    
    public PessoalTest() {
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
     * Test of getNome method, of class Pessoal.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Pessoal instance = new Pessoal();
        instance.setNome("Instance");
        
        String result = instance.getNome();
        assertEquals("Instance", instance.getNome());
        
        
    }

    /**
     * Test of setNome method, of class Pessoal.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        Pessoal instance = new Pessoal();
        instance.setNome("rp");
        assertEquals("rp", instance.getNome());
    }

    /**
     * Test of getForca method, of class Pessoal.
     */
    @Test
    public void testGetForca() {
        System.out.println("getForca");
        Pessoal instance = new Pessoal();
        int expResult = 0;
        int result = instance.getForca();
        assertEquals(expResult, result);
    }

    /**
     * Test of setForca method, of class Pessoal.
     */
    @Test
    public void testSetForca() {
        System.out.println("setForca");
        int forca = 0;
        Pessoal instance = new Pessoal();
        instance.setForca(10);
        assertEquals(10, instance.getForca());
    }
}
