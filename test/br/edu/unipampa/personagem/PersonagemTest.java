package br.edu.unipampa.personagem;

import br.edu.unipampa.cenario.Lugar;
import br.edu.unipampa.recursos.Canoa;
import br.edu.unipampa.recursos.Cantil;
import br.edu.unipampa.recursos.Comida;
import br.edu.unipampa.recursos.Recursos;
import java.util.ArrayList;
import java.util.Stack;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Personagem
 *
 * @author Alex Malmann Becker
 * @since 30/01/2013
 * @version 1.0
 *
 * Teste Classe Personagem
 */
public class PersonagemTest {

    /**
     * Método Construtor Default
     */
    public PersonagemTest() {
    }

    /**
     * Testando o método getNome
     *
     */
    @Test
    public void testGetNome() {
        System.out.println("Testando o método getNome da classe Personagem");
        Personagem instance = new Personagem();
        instance.setNome("Mensageiro");
        assertEquals("Mensageiro", instance.getNome());
    }

    /**
     * Testando o método setNome
     *
     */
    @Test
    public void testSetNome() {
        System.out.println("Testando o método setNome da classe Personagem");
        Personagem instance = new Personagem();
        instance.setNome("mensageiro");
        assertEquals("mensageiro", instance.getNome());
    }

    /**
     * Testando o método getForca
     *
     */
    @Test
    public void testGetForca() {
        System.out.println("Testando o método getForca da classe Personagem");
        Personagem instance = new Personagem();
        assertEquals(0, instance.getForca());
    }

    /**
     * Testando o método getForcaMenorQueCem
     *
     */
    @Test
    public void testGetForcaMenorQueCem() {
        System.out.println("Testando o método getForcaMenorQueCem da classe Personagem");
        Personagem instance = new Personagem();
        instance.ganharForca(10);
        assertEquals(10, instance.getForca());
    }

    /**
     * Testando o método getForcaMaiorQueDuzentos
     *
     */
    @Test
    public void testGetForcaMaiorQueDuzentos() {
        System.out.println("Testando o método getForcaMaiorQueDuzentos da classe Personagem");
        Personagem instance = new Personagem();
        instance.ganharForca(201);
        assertEquals(200, instance.getForca());
    }

    /**
     * Testando o método perderForcaIgualAZero
     *
     */
    @Test
    public void testPerderForcaIgualAZero() {
        System.out.println("Testando o método perderForcaIgualAZero da classe Personagem");
        Personagem instance = new Personagem();
        instance.ganharForca(200);
        instance.ganharHP(100);
        instance.perderForca(200);
        assertEquals(0, instance.getForca());
        assertEquals(90, instance.getHp());
    }

    /**
     * Testando o método perderForcaMaiorQueZero
     *
     */
    @Test
    public void testPerderForcaMaiorQueZero() {
        System.out.println("Testando o método perderForcaMaiorQueZero da classe Personagem");
        Personagem instance = new Personagem();
        instance.ganharForca(200);
        instance.ganharHP(100);
        instance.perderForca(199);
        assertEquals(1, instance.getForca());
        assertEquals(90, instance.getHp());
    }

    /**
     * Testando o método perderForcaMenorQueZero
     *
     */
    @Test
    public void testPerderForcaMenorQueZero() {
        System.out.println("Testando o método perderForcaMenorQueZero da classe Personagem");
        Personagem instance = new Personagem();
        instance.perderForca(201);
        assertEquals(0, instance.getForca());
        assertEquals(0, instance.getHp());
    }

    /**
     * Testando o método getRecursos
     *
     */
    @Test
    public void testGetRecursos() {
        System.out.println("Testando o método getRecursos da classe Personagem");
        Personagem instance = new Personagem();
        ArrayList<Recursos> recursos = new ArrayList<>();
        recursos.add(new Cantil("teste", 10));
        recursos.add(new Canoa("teste canoa"));
        instance.setRecursos(recursos);
        assertEquals(recursos, instance.getRecursos());
    }

    /**
     * Testando o método setRecursos
     *
     */
    @Test
    public void testSetRecursos() {
        System.out.println("Testando o método setRecursos da classe Personagem");
        Personagem instance = new Personagem();
        ArrayList<Recursos> recursos = new ArrayList<>();
        recursos.add(new Cantil("teste2", 10));
        recursos.add(new Canoa("teste2 canoa"));
        instance.setRecursos(recursos);
        assertEquals(recursos, instance.getRecursos());
    }

    /**
     * Testando o método getLugarAtual
     *
     */
    @Test
    public void testGetLugarAtual() {
        System.out.println("Testando o método getLugarAtual da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        Lugar lugar = new Lugar("lugar x", null, null, null, null, 0);
        instance.andar(lugar, false);
        assertEquals(lugar, instance.getLugarAtual());
    }

    /**
     * Testando o método beber
     *
     */
    @Test
    public void testBeber() {
        System.out.println("Testando o método beber da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        instance.perderHP(30);
        instance.beber();
        assertEquals(85, instance.getHp());
    }

    /**
     * Testando o método comerPorcoAssado
     *
     */
    @Test
    public void testComerPorcoAssado() {
        System.out.println("Testando o método comerPorcoAssado da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        instance.perderHP(30);
        Comida porcoAssado = new Comida("Porco Assado", 30);
        instance.comer(porcoAssado);
        assertEquals(100, instance.getHp());
    }

    /**
     * Testando o método comerMaca
     *
     */
    @Test
    public void testComerMaca() {
        System.out.println("Testando o método comerMaca da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        instance.perderHP(30);
        Comida maca = new Comida("Maça", 15);
        instance.comer(maca);
        assertEquals(85, instance.getHp());
    }

    /**
     * Testando o método dormir
     *
     */
    @Test
    public void testDormir() {
        System.out.println("Testando o método dormir da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        instance.perderHP(40);
        instance.dormir();
        assertEquals(80, instance.getHp());
    }

    /**
     * Testando o método getHp
     *
     */
    @Test
    public void testGetHp() {
        System.out.println("Testando o método getHp da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        assertEquals(100, instance.getHp());
    }

    /**
     * Testando o método ganharHpMenorQueCem
     *
     */
    @Test
    public void testGanharHpMenorQueCem() {
        System.out.println("Testando o método ganharHpMenorQueCem da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        instance.perderHP(30);
        instance.ganharHP(10);
        assertEquals(80, instance.getHp());
    }

    /**
     * Testando o método ganharHpMaiorQueCem
     *
     */
    @Test
    public void testGanharHpMaiorQueCem() {
        System.out.println("Testando o método ganharHpMaiorQueCem da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        instance.ganharHP(1);
        assertEquals(100, instance.getHp());
    }

    /**
     * Testando o método perderHpEMorrer
     *
     */
    @Test
    public void testPerderHpEMorrer() {
        System.out.println("Testando o método perderHpEMorrer da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        assertEquals(false, instance.perderHP(100));
    }

    /**
     * Testando o método perderHpEContinuarVivo
     *
     */
    @Test
    public void testPerderHpEContinuarVivo() {
        System.out.println("Testando o método perderHpEContinuarVivo da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        assertEquals(true, instance.perderHP(99));
    }

    /**
     * Testando o método andarInicio
     *
     */
    @Test
    public void testAndarInicio() {
        System.out.println("Testando o método andarInicio da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        Lugar lugar = new Lugar("lugar z", null, null, null, null, 0);
        assertEquals(true, instance.andar(lugar, false));
        assertEquals(lugar, instance.getLugarAtual());
        assertEquals(100, instance.getHp());
    }

    /**
     * Testando o método andarNoJogo
     *
     */
    @Test
    public void testAndarNoJogo() {
        System.out.println("Testando o método andarNoJogo da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        Lugar lugar = new Lugar("lugar z", null, null, null, null, 0);
        Lugar lugar2 = new Lugar("lugar x", null, null, null, null, 0);
        assertEquals(true, instance.andar(lugar, false));
        assertEquals(true, instance.andar(lugar2, false));
        assertEquals(lugar2, instance.getLugarAtual());
        assertEquals(90, instance.getHp());
    }

    /**
     * Testando o método andarNull
     *
     */
    @Test
    public void testAndarNull() {
        System.out.println("Testando o método andarNull da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        assertEquals(false, instance.andar(null, false));
        assertEquals(null, instance.getLugarAtual());
        assertEquals(100, instance.getHp());
    }

    /**
     * Testando o método andarComCavalo
     *
     */
    @Test
    public void testAndarComCavalo() {
        System.out.println("Testando o método andarComCavalo da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        Lugar lugar = new Lugar("lugar z", null, null, null, null, 0);
        Lugar lugar2 = new Lugar("lugar x", null, null, null, null, 0);
        assertEquals(true, instance.andar(lugar, false)); //andar inicio
        assertEquals(true, instance.andar(lugar2, true)); //com cavalo
        assertEquals(lugar2, instance.getLugarAtual());
        assertEquals(100, instance.getHp());
    }

    /**
     * Testando o método voltarInicio
     *
     */
    @Test
    public void testVoltarInicio() {
        System.out.println("Testando o método voltarInicio da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        Lugar lugar = new Lugar("lugar z", null, null, null, null, 0);
        assertEquals(false, instance.voltar());
        instance.andar(lugar, false);
        assertEquals(false, instance.voltar());
        assertEquals(100, instance.getHp());
    }

    /**
     * Testando o método voltarNoJogo
     *
     */
    @Test
    public void testVoltarNoJogo() {
        System.out.println("Testando o método voltarNoJogo da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        Lugar lugar = new Lugar("lugar z", null, null, null, null, 0);
        Lugar lugar2 = new Lugar("lugar x", null, null, null, null, 0);
        instance.andar(lugar, false);
        instance.andar(lugar2, false);
        assertEquals(true, instance.voltar());
        assertEquals(80, instance.getHp());
    }

    /**
     * Testando o método isAlive
     *
     */
    @Test
    public void testIsAlive() {
        System.out.println("Testando o método isAlive da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        Lugar lugar = new Lugar("lugar z", null, null, null, null, 0);
        Lugar lugar2 = new Lugar("lugar x", null, null, null, null, 0);
        instance.andar(lugar, false);
        instance.andar(lugar2, false);
        assertEquals(true, instance.isAlive());
    }

    /**
     * Testando o método notIsAlive
     *
     */
    @Test
    public void testNotIsAlive() {
        System.out.println("Testando o método notIsAlive da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        instance.andar(new Lugar("lugar x", null, null, null, null, 0), false);
        instance.andar(new Lugar("lugar a", null, null, null, null, 0), false);
        instance.andar(new Lugar("lugar b", null, null, null, null, 0), false);
        instance.andar(new Lugar("lugar c", null, null, null, null, 0), false);
        instance.andar(new Lugar("lugar d", null, null, null, null, 0), false);
        instance.voltar();
        instance.andar(new Lugar("lugar f", null,  null, null, null, 0), false);
        instance.andar(new Lugar("lugar r", null,  null, null, null, 0), false);
        instance.voltar();
        instance.andar(new Lugar("lugar t", null,  null, null, null, 0), false);
        instance.andar(new Lugar("lugar z", null,  null, null, null, 0), false);
        assertEquals(false, instance.isAlive());
    }

    /**
     * Testando o método getLugaresPassados
     *
     */
    @Test
    public void testGetLugaresPassados() {
        System.out.println("Testando o método getLugaresPassados da classe Personagem");
        Mensageiro instance = new Mensageiro(null);
        Stack<Lugar> lugaresPassados = new Stack<>();
        Lugar lugar = new Lugar("lugar z", null,  null, null, null, 0);
        Lugar lugar2 = new Lugar("lugar x", null,  null, null, null, 0);
        Lugar lugar3 = new Lugar("lugar y", null,  null, null, null, 0);
        instance.andar(lugar, false);
        instance.andar(lugar2, false);
        lugaresPassados.push(lugar);
        instance.andar(lugar3, false);
        lugaresPassados.push(lugar2);
        assertEquals(lugaresPassados, instance.getLugaresPassados());
        instance.voltar();
        lugaresPassados.pop();
        instance.voltar();
        lugaresPassados.pop();
        assertEquals(lugaresPassados, instance.getLugaresPassados());
        instance.voltar();
        assertEquals(lugaresPassados, instance.getLugaresPassados());
    }

    /**
     * Testando o método mostrarDicaAmigo
     *
     */
    @Test
    public void testMostrarDicaAmigo() {
        System.out.println("Testando o método mostrarDicaAmigo da classe Personagem");
        Mensageiro mensageiro = new Mensageiro(null);
        Lugar lugar = new Lugar("lugar z", null,  null, null, null, 4);
        Lugar lugar2 = new Lugar("lugar x", null,  null, null, null, 3);
        lugar2.atribuirVizinhos(new Lugar("Lugar 3", null, null, null, null, 2),
                lugar,
                new Lugar("Abismo 3", null, null, null, null, -1),
                new Lugar("Charco Norte", null, null, null, null, 3));
        mensageiro.andar(lugar, false);
        mensageiro.andar(lugar2, false);
        Amigo instance = new Amigo("amigo", null);
        assertEquals("Siga pelo lugar: Lugar 3", instance.mostrarDica(mensageiro.getLugarAtual(), mensageiro.getLugaresPassados().lastElement()));
    }
    
    /**
     * Testando o método mostrarDicaInimigoAbismo
     *
     */
    @Test
    public void testMostrarDicaInimigoAbismo() {
        System.out.println("Testando o método mostrarDicaInimigoAbismo da classe Personagem");
        Mensageiro mensageiro = new Mensageiro(null);
        Lugar lugar = new Lugar("lugar z", null,  null, null, null, 4);
        Lugar lugar2 = new Lugar("lugar x", null,  null, null, null, 3);
        lugar2.atribuirVizinhos(new Lugar("Lugar 3", null, null, null, null, 2),
                lugar,
                new Lugar("Abismo 3", null, null, null, null, -1),
                new Lugar("Charco Norte", null, null, null, null, 3));
        mensageiro.andar(lugar, false);
        mensageiro.andar(lugar2, false);
        Inimigo instance = new Inimigo("inimigo", 30, 10, null, 30);
        assertEquals("Siga pelo lugar: Abismo 3", instance.mostrarDica(mensageiro.getLugarAtual(), mensageiro.getLugaresPassados().lastElement()));
    }
    
    /**
     * Testando o método mostrarDicaInimigoDistancia
     *
     */
    @Test
    public void testMostrarDicaInimigoDistancia() {
        System.out.println("Testando o método mostrarDicaInimigoDistancia da classe Personagem");
        Mensageiro mensageiro = new Mensageiro(null);
        Lugar lugar = new Lugar("lugar z", null,  null, null, null, 4);
        Lugar lugar2 = new Lugar("lugar x", null,  null, null, null, 3);
        lugar2.atribuirVizinhos(new Lugar("Lugar 3", null, null, null, null, 2),
                lugar,
                new Lugar("Distância Maior", null, null, null, null, 5),
                new Lugar("Charco Norte", null, null, null, null, 3));
        mensageiro.andar(lugar, false);
        mensageiro.andar(lugar2, false);
        Inimigo instance = new Inimigo("inimigo", 30, 40, null, 35);
        assertEquals("Siga pelo lugar: Distância Maior", instance.mostrarDica(mensageiro.getLugarAtual(), mensageiro.getLugaresPassados().lastElement()));
    }
}
