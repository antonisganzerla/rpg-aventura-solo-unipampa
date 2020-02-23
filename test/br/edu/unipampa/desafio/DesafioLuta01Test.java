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
public class DesafioLuta01Test {
    
    public DesafioLuta01Test() {
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
     * Test do método desafioLugar method, da classe DesafioLuta.
     */
    @Test
    public void testDesafioLugar() {
        System.out.println("desafioLugar");
        Mensageiro mensageiro = new Mensageiro(null);
        Inimigo inimigo = new Inimigo("teste", 10, 10, null, 10);
        mensageiro.setForca(100);
        mensageiro.setDefesa(100);
        mensageiro.setDano(100);
        inimigo.setDefesa(200);
        ArrayList recursos = new ArrayList();
        int n = 0;
        DesafioLuta instance = new DesafioLuta();
        String expResult = inimigo.getNome() + " bloqueou seu ataque";
        String result = instance.desafioLugar(mensageiro, inimigo, null, n);
        assertEquals(expResult, result);
        }

    @Test
    public void testDesafioLugar2() {
        System.out.println("Turno ataque mensageiro");
        Mensageiro mensageiro = new Mensageiro(null);
        Inimigo inimigo = new Inimigo("teste", 10, 10, null, 10);
        mensageiro.setForca(70);
        mensageiro.setDefesa(100);
        mensageiro.setDano(100);
        inimigo.setDefesa(30);
        ArrayList recursos = new ArrayList();
        int n = 0;
        DesafioLuta instance = new DesafioLuta();
        String expResult = "Você tirou 40 do seu inimigo... ";
        String result = instance.desafioLugar(mensageiro, inimigo, null, n);
        assertEquals(expResult, result);
        }

    /**
     * Test do método definirAtaque, da classe DesafioLuta.
     * Não é possível realizar, pois é um sorteio de qual numero será gerado.
     */
    @Test
    public void testDefinirAtaque() {
        System.out.println("definirAtaque");
        System.out.println("Não é possível realizar, pois é um sorteio de qual numero será gerado.");
        int forca = 0;
        DesafioLuta instance = new DesafioLuta();
        //int expResult = 0;
        //int result = instance.definirAtaque(forca);
        //assertEquals(expResult, result);
         }
}
