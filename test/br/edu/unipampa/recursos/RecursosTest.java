/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.recursos;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 121150127
 */
public class RecursosTest {
    
    public RecursosTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getQuantidade method, of class Recursos.
     */
    @Test
    public void testGetQuantidade() {
        System.out.println("getQuantidade");
        Recursos instance = new Recursos();
        instance.setQuantidade(2);
        int expResult = 2;
        int result = instance.getQuantidade();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuantidade method, of class Recursos.
     */
    @Test
    public void testSetQuantidade() {
        System.out.println("setQuantidade");
        Recursos instance = new Recursos();
        instance.setQuantidade(1);
        assertEquals(1, instance.getQuantidade());
    }

    /**
     * Test of getNome method, of class Recursos.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Recursos instance = new Recursos();
        instance.setNome("nome");
        assertEquals("nome", instance.getNome());
    }

    /**
     * Test of setNome method, of class Recursos.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        Recursos instance = new Recursos();
        instance.setNome("nome");
        assertEquals("nome", instance.getNome());
    }
}
