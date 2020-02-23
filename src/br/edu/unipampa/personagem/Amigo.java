package br.edu.unipampa.personagem;

import br.edu.unipampa.cenario.Lugar;
import br.edu.unipampa.recursos.Recursos;

/**
 * Amigo
 *
 * @author Alex Malmann Becker
 * @since 25/01/2013
 * @version 1.0
 *
 * Classe Persoangem Amigo
 */
public class Amigo extends Personagem {

    /**
     * Método Construtor Default
     */
    public Amigo() {
    }

    /**
     * Método Construtor passando os parametros do amigo
     */
    public Amigo(String nome, Recursos recurso) {
        super.setNome(nome);
        super.getRecursos().add(recurso);
    }

    /**
     * Método Verificar Dica Lugar Certo
     * 
     * @param Lugar - passa o lugar atual
     * @param Lugar - passa o ultimo lugar passado
     * @return Lugar - retorna o lugar certo
     */
    @Override
    protected Lugar verificarDicaLugar(Lugar lugarAtual, Lugar ultimoLugar) {
        Lugar lugar = null;
        
        for (int i = 0; i < lugarAtual.getVizinhos().size(); i++) {
            if (lugarAtual.getVizinhos().get(i).getDistancia() >= 0 && lugarAtual.getVizinhos().get(i) != ultimoLugar) {
                if (lugar == null) {
                    lugar = lugarAtual.getVizinhos().get(i);
                } else {
                    if (lugarAtual.getVizinhos().get(i).getDistancia() < lugar.getDistancia()) {
                        lugar = lugarAtual.getVizinhos().get(i);
                    }
                }
            }
        }      
        return lugar;
    }

}
