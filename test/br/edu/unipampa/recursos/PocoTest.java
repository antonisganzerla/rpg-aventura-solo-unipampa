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
public class PocoTest {
    
    public PocoTest() {
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
     * Test of passarPoco method, of class Poco.
     */
    @Test
    public void testPassarPoco() {
        System.out.println("passarPoco");
        Cantil c1 = new Cantil("c1",0);
        c1.setAgua(8);
        Poco instance = new Poco("p1");
        instance.passarPoco(c1);
        assertEquals(10, c1.getAgua());
    }
}
