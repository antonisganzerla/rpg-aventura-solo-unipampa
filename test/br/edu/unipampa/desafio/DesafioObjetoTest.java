/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.desafio;

import br.edu.unipampa.personagem.Inimigo;
import br.edu.unipampa.personagem.Mensageiro;
import br.edu.unipampa.recursos.Canoa;
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
 * @author Miguel
 */
public class DesafioObjetoTest {
    
    public DesafioObjetoTest() {
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
     * Test do desafioObjeto method, presente na classe DesafioObjeto.
     */
    @Test
     public void testDesafioLugar() {
        Mensageiro m = new Mensageiro(null);
        ArrayList<Recursos> recursos = new ArrayList<Recursos>();
        DesafioObjeto dh = new DesafioObjeto();
        Canoa c1 = new Canoa("Canoa");
        recursos.add(c1);
        m.setRecursos(recursos);
        String expResult = "Parabéns, você tem o recurso necessário para concluir o desafio!";
        String result = dh.verificar(m, recursos);
        assertEquals(expResult, dh.verificar(m, recursos));
        }
    /**
     * TestDois do desafioObjeto method, presente na classe DesafioObjeto.
     */
     public void testDois() {
        Mensageiro m = new Mensageiro(null);
        ArrayList<Recursos> recursos = new ArrayList<Recursos>();
        DesafioObjeto dh = new DesafioObjeto();
        m.setRecursos(recursos);
        String expResult = "Infelizmente você não tem o recurso necessário";
        String result = dh.verificar(m, recursos);
        assertEquals(expResult, dh.verificar(m, recursos));
        }
     /**
     * TestDesafioLugar3 do desafioObjeto method, presente na classe DesafioObjeto.
     */
     public void testDesafioLugar3() {
        Mensageiro m = new Mensageiro(null);
        ArrayList<Recursos> recursos = new ArrayList<Recursos>();
        ArrayList<Recursos> mensage = new ArrayList<Recursos>();
        DesafioObjeto dh = new DesafioObjeto();
        Canoa c1 = new Canoa("Canoa");
        Recursos cavalo = new Recursos("cavalo", 1);
        recursos.add(c1);
        mensage.add(c1);
        mensage.add(cavalo);
        String expResult = "Parabéns, você tem o recurso necessário para concluir o desafio!";
        String result = dh.verificar(m, recursos);
        assertEquals(expResult, dh.verificar(m, recursos));
        }
}
