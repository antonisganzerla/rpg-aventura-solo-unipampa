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
public class CantilTest {
    
    public CantilTest() {
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
     * Test of encherCantil method, of class Cantil.
     */
    @Test
    public void testEncherCantil() {
        System.out.println("encherCantil");
        Cantil instance = new Cantil("cantil",10);
        instance.setAgua(5);
        instance.encherCantil(instance);
        assertEquals(10, instance.getAgua());
        
      }
    
    @Test
    public void testEncherCantil2() {
        System.out.println("encherCantil");
        Cantil instance2 = new Cantil("cantil",10);
        instance2.setAgua(10);
        instance2.encherCantil(instance2);
        assertEquals(10, instance2.getAgua());
        
      }
    
    

    /**
     * Test of descontaCantil method, of class Cantil.
     */
    @Test
    public void testDescontaCantil() {
        System.out.println("descontaCantil");
        Cantil instance = new Cantil("Cantil",10);
        instance.setAgua(5);
        instance.descontaCantil(instance);
        assertEquals(4, instance.getAgua());
        
    }
    
    @Test
    public void testDescontaCantil2() {
        
        Cantil instance2 = new Cantil("Cantil",10);
        instance2.setAgua(0);
        instance2.descontaCantil(instance2);
        assertEquals(0, instance2.getAgua());
    }
    
    /**
     * Test of getAgua method, of class Cantil.
     */
    @Test
    public void testGetAgua() {
        System.out.println("getAgua");
        Cantil instance = new Cantil("Cantil",10);
        instance.setAgua(5);
        int expResult = 5;
        int result = instance.getAgua();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAgua method, of class Cantil.
     */
    @Test
    public void testSetAgua() {
        System.out.println("setAgua");
        Cantil instance = new Cantil("Cantil", 10);
        instance.setAgua(5);
        assertEquals(5, instance.getAgua());
    }
}
