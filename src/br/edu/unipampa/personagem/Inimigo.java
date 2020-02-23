package br.edu.unipampa.personagem;

import br.edu.unipampa.cenario.Lugar;
import br.edu.unipampa.recursos.Recursos;

/**
 * Inimigo
 *
 * @author Alex Malmann Becker
 * @since 25/01/2013
 * @version 1.0
 *
 * Classe Persoangem Inimigo
 */
public class Inimigo extends Personagem {

    /**
     * Método Construtor passando os parametros do inimigo
     */
    public Inimigo(String nome, int forca, int hp, Recursos recurso, int defesa) {
        super.setNome(nome);
        super.setForca(forca);
        super.setHp(hp);
        super.setDefesa(defesa);
        super.getRecursos().add(recurso);
    }

    /**
     * Método Verificar Dica Lugar Errado
     *
     * @param Lugar - passa o lugar atual
     * @param Lugar - passa o ultimo lugar passado
     * @return Lugar - retorna o lugar errado
     */
    @Override
    protected Lugar verificarDicaLugar(Lugar lugarAtual, Lugar ultimoLugar) {
        Lugar lugar = null;
        for (int i = 0; i < lugarAtual.getVizinhos().size(); i++) {
            if (lugarAtual.getVizinhos().get(i).getDistancia() < 0) {
                lugar = lugarAtual.getVizinhos().get(i);
            }
        }
        if (lugar == null) {
            lugar = lugarAtual.getVizinhos().get(0);
            for (int i = 1; i < lugarAtual.getVizinhos().size(); i++) {
                if (lugarAtual.getVizinhos().get(i) != ultimoLugar) {
                    if (lugarAtual.getVizinhos().get(i).getDistancia() > lugar.getDistancia()) {
                        lugar = lugarAtual.getVizinhos().get(i);
                    }
                }
            }
        }
        return lugar;
    }
}
