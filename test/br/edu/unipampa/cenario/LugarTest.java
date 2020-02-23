/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.cenario;

import br.edu.unipampa.desafio.Desafio;
import br.edu.unipampa.desafio.DesafioCharada;
import br.edu.unipampa.desafio.DesafioLuta;
import br.edu.unipampa.personagem.Amigo;
import br.edu.unipampa.personagem.Inimigo;
import br.edu.unipampa.personagem.Mensageiro;
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
 * @author Antoni Sganzerla
 * @version 2.0
 */
public class LugarTest {

    public LugarTest() {
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
     * Test of atribuirVizinhos method, of class Lugar.
     */
    @Test
    public void testAtribuirVizinhos() {
        System.out.println("atribuirVizinhos");
        Lugar direita = new Lugar("direita", null, null, null, null, 3);
        Lugar esquerda = null;
        Lugar acima = null;
        Lugar abaixo = new Lugar("abaixo", null, null, null, null, 1);
        Lugar instance = new Lugar("TESTE", null, null, null, null, 1);
        ArrayList<Lugar> listaDeVizinhos = new ArrayList<Lugar>();
        listaDeVizinhos.add(direita);
        listaDeVizinhos.add(esquerda);
        listaDeVizinhos.add(acima);
        listaDeVizinhos.add(abaixo);
        instance.atribuirVizinhos(direita, esquerda, acima, abaixo);
        assertEquals(listaDeVizinhos, instance.getVizinhos());
    }

    /**
     * Test of executarLugar method, of class Lugar.
     */
    @Test
    public void testExecutarLugar() {
        System.out.println("executarLugar");
        Desafio luta = new DesafioLuta();
        Arma escudo1 = new Arma("Escudo Imperial", 15, "defesa");
        Inimigo inimigo1 = new Inimigo("Espartano", 40, 45, escudo1,50);
        Lugar inicio = new Lugar("Inicio da aventura", luta, inimigo1, null, null, 4);
        Mensageiro mensageiro = new Mensageiro(inicio);
        String expResult = inimigo1.getNome() + " bloqueou seu ataque";
        String result = inicio.executarLugar(mensageiro, 0);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaDeRecursos method, of class Lugar.
     */
    @Test
    public void testGetListaDeRecursos() {
        System.out.println("getListaDeRecursos");
        ArrayList<Recursos> lista = new ArrayList<Recursos>();
        Arma lamina = new Arma("Lamina do Caos", 23, "arma");
        Recursos ouro = new Recursos();
        Arma tortoise  = new Arma("Tortoise Shield", 32, "escudo");
        lista.add(lamina);
        lista.add(ouro);
        lista.add(null);
        lista.add(tortoise);
        Lugar instance = new Lugar("Teste", null, null, null, lista, 2);
        ArrayList expResult = lista;
        ArrayList result = instance.getListaDeRecursos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNome method, of class Lugar.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Lugar instance = new Lugar("Arena", null, null, null, null, 4);
        String expResult = "Arena";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistancia method, of class Lugar.
     */
    @Test
    public void testGetDistancia() {
        System.out.println("getDistancia");
        Lugar instance = new Lugar("BBB", null, null, null, null, 2);
        int expResult = 2;
        int result = instance.getDistancia();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getDistancia2 method, of class Lugar.
     */
    @Test
    public void testGetDistancia2() {
        System.out.println("getDistancia");
        Lugar instance = new Lugar("BBB", null, null, null, null, -4);
        int expResult = -4;
        int result = instance.getDistancia();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getInimigo method, of class Lugar.
     */
    @Test
    public void testGetInimigo() {
        System.out.println("getInimigo");
        Inimigo joao = new Inimigo("Pedro", 20, 50, null, 15);
        Lugar instance = new Lugar("lalal", null,joao, null, null, 3);
        Inimigo expResult = joao;
        Inimigo result = instance.getInimigo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAmigo method, of class Lugar.
     */
    @Test
    public void testGetAmigo() {
        System.out.println("getAmigo");
        Amigo pedro = new Amigo("Joao", null);
        Lugar instance = new Lugar("teste", null, null, pedro, null, 2);
        Amigo expResult = pedro;
        Amigo result = instance.getAmigo();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getDesafio method, of class Lugar.
     */
    @Test
    public void testGetDesafio() {
        System.out.println("getDesafio");
        Desafio d = new DesafioLuta();
        Inimigo i = new Inimigo("Kratos", 15, 40, null, 10);

        Lugar instance = new Lugar("SEI LA", d, i, null, null, 2);
        Desafio expResult = d;
        Desafio result = instance.getDesafio();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVizinhos method, of class Lugar.
     */
    @Test
    public void testGetVizinhos() {
        System.out.println("getVizinhos");
        Desafio d = new DesafioLuta();
        Arma laminaDoCaos = new Arma("Lâmina do Caos", 45, "ataque");
        Inimigo i = new Inimigo("Kratos", 40, 45, laminaDoCaos, 30);
        Lugar instance = new Lugar("xega professora nao aguento mais", d, i, null, null, 3);
        Lugar direita = new Lugar("Diretia", d, i, null, null, 2);

        Desafio d2 = new DesafioCharada();
        Amigo a = new Amigo("Java", null);
        Lugar esquerda = new Lugar("Esquerda", d2, i, a, null, 2);

        Inimigo inimigo3 = new Inimigo("Soldado", 40, 45, laminaDoCaos, 30);
        Lugar acima = new Lugar("Acima", d, inimigo3, null, null, 1);

        Amigo amigo5 = new Amigo("Leandro Damião", null);
        Lugar abaixo = new Lugar("Abaixo", d2, null, amigo5, null, 2);

        ArrayList<Lugar> viz = new ArrayList<Lugar>();
        viz.add(direita);
        viz.add(esquerda);
        viz.add(acima);
        viz.add(abaixo);

        instance.atribuirVizinhos(direita, esquerda, acima, abaixo);

        ArrayList expResult = viz;
        ArrayList result = instance.getVizinhos();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFim method, of class Lugar.
     */
    @Test
    public void testIsFim() {
        System.out.println("isFim");
        Lugar instance = new Lugar(null, null, null, null, null, 3);
        instance.setFim(false);
        boolean expResult = false;
        boolean result = instance.isFim();
        assertEquals(expResult, result);

    }

    /**
     * Test of setFim method, of class Lugar.
     */
    @Test
    public void testSetFim() {
        System.out.println("setFim");
        boolean fim = false;
        Lugar instance = new Lugar(null, null, null, null, null, 0);
        instance.setFim(fim);
        assertEquals(false, instance.isFim());

    }
}
