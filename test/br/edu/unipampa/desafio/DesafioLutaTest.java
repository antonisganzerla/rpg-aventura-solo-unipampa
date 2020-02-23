/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.desafio;

import br.edu.unipampa.personagem.Amigo;
import br.edu.unipampa.personagem.Inimigo;
import br.edu.unipampa.personagem.Mensageiro;
import br.edu.unipampa.personagem.Personagem;
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
public class DesafioLutaTest {

    public DesafioLutaTest() {
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
     * Test do método desafioLugar, da class DesafioLuta.
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

    /**
     * Test do método definirAtaque, da classe DesafioLuta. Não é possível
     * realizar, pois é um sorteio de qual numero será gerado.
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

    /**
     * Test do método turnoAtaqueMensageiro, da classe DesafioLuta.
     */
    @Test
    public void testTurnoAtaqueMensageiro() {
        System.out.println("turnoAtaqueMensageiro");
        Mensageiro mensageiro = new Mensageiro(null);
        mensageiro.setForca(70);
        mensageiro.setDano(mensageiro.getForca());
        Inimigo inimigo = new Inimigo("teste", 10, 70, null, 40);
        DesafioLuta instance = new DesafioLuta();
        int dano = mensageiro.getDano() - inimigo.getDefesa();

        String result = instance.turnoAtaqueMensageiro(mensageiro, inimigo);
        String expResult = "Você tirou " + dano + " do seu inimigo... "
                + inimigo.getNome() + " está com " + inimigo.getHp() + " de vida";
        assertEquals(expResult, result);
    }

    /**
     * Test do método turnoAtaqueInimigo, da classe DesafioLuta.
     */
    @Test
    public void testTurnoAtaqueInimigo() {
        System.out.println("turnoAtaqueInimigo");
        Mensageiro mensageiro = new Mensageiro(null);
        mensageiro.setHp(50);
        mensageiro.setDefesa(10);
        Inimigo inimigo = new Inimigo("teste", 10, 70, null, 40);
        inimigo.setDano(mensageiro.getForca());
        DesafioLuta instance = new DesafioLuta();
        int dano = inimigo.getDano() - mensageiro.getDefesa();
        String result = instance.turnoAtaqueInimigo(mensageiro, inimigo);
        String expResult = "Você perdeu " + dano + " de vida."
                + " Você está com " + mensageiro.getHp() + " de hp";;

        assertEquals(expResult, result);
    }
}
