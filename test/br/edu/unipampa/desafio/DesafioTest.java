/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.desafio;

import br.edu.unipampa.personagem.Mensageiro;
import br.edu.unipampa.personagem.Personagem;
import br.edu.unipampa.recursos.Cantil;
import br.edu.unipampa.recursos.Recursos;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Miguel
 */
public class DesafioTest {
    
    public DesafioTest() {
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
     * Test do método verificar, que está localizado na clase Desafio.
     */
    @Test
    public void testVerificar() {
        Mensageiro mensageiro = new Mensageiro(null);
        ArrayList<Recursos> recursos =  new ArrayList<Recursos>();
        Desafio instance = new DesafioImpl();
        Recursos r1 = new Recursos();
        recursos.add(r1);
        mensageiro.setRecursos(recursos);
        String expResult = "Parabéns, você tem o recurso necessário para concluir o desafio!";
        String result = instance.verificar(mensageiro, recursos);
        assertEquals(expResult, result);
        }

    @Test
    public void testVerificar2() {
        Mensageiro mensageiro = new Mensageiro(null);
        ArrayList<Recursos> r = new ArrayList<Recursos>();
        ArrayList<Recursos> m = new ArrayList<Recursos>();
        Cantil c1 = new Cantil("nome", 10);
        Recursos r1 = new Recursos();
        Recursos r2 = new Recursos();
        r.add(c1);
        Desafio instance = new DesafioImpl();
        mensageiro.setRecursos(m);
        String expResult = "Infelizmente você não tem o recurso necessário";
        String result = instance.verificar(mensageiro, r);
        assertEquals(expResult, result);
        }
    
    @Test
    public void testVerificar3() {
        Mensageiro mensageiro = new Mensageiro(null);
        ArrayList<Recursos> r = new ArrayList<Recursos>();
        ArrayList<Recursos> m = new ArrayList<Recursos>();
        Recursos r1 = new Recursos();
        Recursos r2 = new Recursos();
        r.add(r1);
       Desafio instance = new DesafioImpl();
        mensageiro.setRecursos(m);
        String expResult = "Infelizmente você não tem o recurso necessário";
        String result = instance.verificar(mensageiro, r);
        assertEquals(expResult, result);
        }
    /**
     * 
     * 
     * Test do método getDescricao, que pertence á classe Desafio.
     */
    @Test
    
    public void testGetDescricao() {
        Desafio instance = new DesafioImpl();
        instance.setDescricao("Desafio teste 01");
        String expResult = "Desafio teste 01";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Test do método setDescricao, que pertence á classe Desafio.
     */
    @Test
    public void testSetDescricao() {
        
        Desafio instance = new DesafioImpl();
        String descricao = "Desafio Teste 01";
        instance.setDescricao(descricao);
        assertEquals(descricao, instance.getDescricao());
    }

    /**
     * Test do método desafioLugar, localizado na classe Desafio.
     */
   

    public class DesafioImpl extends Desafio {

        public String desafioLugar(Mensageiro mensageiro, Personagem inimigo, ArrayList recursos, int n) {
            return "";
        }
    }
}
