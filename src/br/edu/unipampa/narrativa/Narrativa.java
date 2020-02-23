package br.edu.unipampa.narrativa;

import br.edu.unipampa.cenario.Cenario;
import br.edu.unipampa.cenario.Lugar;
import br.edu.unipampa.desafio.Desafio;
import br.edu.unipampa.desafio.DesafioCharada;
import br.edu.unipampa.desafio.DesafioLuta;
import br.edu.unipampa.interfacerpg.IInicio;
import br.edu.unipampa.interfacerpg.IJogo;
import br.edu.unipampa.personagem.Amigo;
import br.edu.unipampa.personagem.Inimigo;
import br.edu.unipampa.personagem.Mensageiro;
import br.edu.unipampa.recursos.*;
import java.util.ArrayList;

/**
 * Narrativa
 *
 * @author Alex Malmann Becker
 * @author Anderson Raugust
 * @author Antoni Sganzerla
 * @author Miguel J Zinelli
 * @author Edison Jhonatan R. Moura
 * @since 25/01/2013
 * @version 1.0
 *
 * Classe Narrativa
 */
public class Narrativa {

    private Mensageiro mensageiro;
    private Cenario cenario;

    /**
     * Método construtor default, criando todos os lugares, com seus amigo ou
     * inimigo, desafio e recursos
     */
    public Narrativa() {
        Desafio charadaDireta = new DesafioCharada();

        //lugar fim
        Desafio luta = new DesafioLuta();
        Arma machado = new Arma("Machado do Julgamento Final", 50,"ataque");
        Inimigo inimigoFim = new Inimigo("Picollo", 85, 90, machado, 65);
        Lugar fim = new Lugar("Sede de Alegrete", luta, inimigoFim, null, null, 0);
        fim.setFim(true);

        //lugar 8
        Amigo amigo8 = new Amigo("Simpson", new Arma("Espada", 30,"ataque"));
        Lugar lugar8 = new Lugar("Acampamento", charadaDireta, null, amigo8, null, 1);

        //lugar 7
        Arma pampaShield = new Arma("Pampa Shield", 45,"defesa");
        Inimigo inimigo7 = new Inimigo("Kapiroto", 65, 65, pampaShield,60);
        Lugar lugar7 = new Lugar("Charco Sul", luta, inimigo7, null, null, 2);

        //lugar 6
        Arma pa = new Arma("Pa",5,"ataque");
        Amigo amigo6 = new Amigo("Homer", pa);
        Lugar lugar6 = new Lugar("Deserto", charadaDireta, null, amigo6, null, 1);

        //lugar 5
        Arma escudo = new Arma("Escudo de Tabua", 5,"defesa");
        Inimigo inimigo5 = new Inimigo("Leandro Damião", 65, 45, escudo,45);
        Lugar lugar5 = new Lugar("Fazenda", luta, inimigo5, null, null, 2);

        //lugar 4
        Canoa canoa = new Canoa("Canoa");
        ArrayList<Recursos> recursos4 = new ArrayList<>();
        recursos4.add(canoa);
        Amigo amigo4 = new Amigo("Delofeu", new Arma("Foice do Ceifeiro", 25,"arma"));
        Lugar lugar4 = new Lugar("CTG", charadaDireta, null, amigo4, recursos4, 3);

        //lugar 3
        Recursos cavalo = new Recursos("Pé de pano", 1);
        ArrayList<Recursos> recursos3 = new ArrayList<>();
        recursos3.add(cavalo);
        Arma laminaDoCaos = new Arma("Lâmina do Caos", 45, "ataque");
        Inimigo inimigo3 = new Inimigo("Kratos", 60, 65, laminaDoCaos,40);
        Lugar lugar3 = new Lugar("Trilho", luta, inimigo3, null, recursos3, 2);

        //lugar 2
        ArrayList<Recursos> recursos2 = new ArrayList<>();
        Amigo amigo2 = new Amigo("Calica", new Arma("Facão Três Listras", 20,"ataque"));
        Lugar lugar2 = new Lugar("Ponte", charadaDireta, null, amigo2, recursos2, 3);

        //lugar inicio
        Arma escudo1 = new Arma("Escudo Imperial", 15, "defesa");
        Inimigo inimigo1 = new Inimigo("Espartano", 40, 45, escudo1,35);
        Lugar inicio = new Lugar("Inicio da aventura", luta, inimigo1, null, null, 4);

        // atribuição dos vizinhos de cada Lugar
        inicio.atribuirVizinhos(lugar2, new Lugar("Beira Rio", null, null, null, null, -1), new Lugar("Hogwarts", null, null, null, null, -1), lugar4);
        lugar2.atribuirVizinhos(lugar3, inicio, new Lugar("Narnia", null, null, null, null, -1), lugar5);
        lugar3.atribuirVizinhos(new Lugar("Mundo Mágico de Oz", null, null, null, null, -1), lugar2, new Lugar("Hollywood", null, null, null, null, -1), lugar6);
        lugar4.atribuirVizinhos(lugar5, new Lugar("País das Maravilhas", null, null, null, null, -1), inicio, lugar7);
        lugar5.atribuirVizinhos(lugar6, lugar4, lugar2, lugar8);
        lugar6.atribuirVizinhos(new Lugar("Passagem para BBB14", null, null, null, null, -1), lugar5, lugar3, fim);
        lugar7.atribuirVizinhos(lugar8, new Lugar("Estádio do Juventude", null, null, null, null, -1), lugar4, new Lugar("Paris", null, null, null, null, -1));
        lugar8.atribuirVizinhos(fim, lugar7, lugar5, new Lugar("Uruguaiana", null, null, null, null, -1));
        fim.atribuirVizinhos(new Lugar("Tomorrowland", null, null, null, null, -1), lugar8, lugar6, new Lugar("Londres", null, null, null, null, -1));

        //cria mensageiro e cenario
        cenario = new Cenario(inicio);
        mensageiro = new Mensageiro(cenario.getInicio());
    }

    /**
     * Método responsável em criar a interface do início do jogo
     */
    public void iniciarJogo() {
        new IInicio(this);
    }

    /**
     * Método responsável em criar a interface do jogo
     */
    public void abrirInterfaceJogo() {
        IJogo ijogo = new IJogo(this);
        ijogo.setVisible(true);
    }

    /**
     * Método que retorna o mensageiro
     * @return mensageiro - retorna o mensageiro
     */
    public Mensageiro getMensageiro() {
        return mensageiro;
    }

    /**
     * Método que retorna o cenário
     * @return cenario - retorna o cenário
     */
    public Cenario getCenario() {
        return cenario;
    }
}
