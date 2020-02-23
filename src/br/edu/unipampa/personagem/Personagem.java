package br.edu.unipampa.personagem;

import br.edu.unipampa.cenario.Lugar;
import br.edu.unipampa.recursos.Comida;
import br.edu.unipampa.recursos.Recursos;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Personagem
 *
 * @author Alex Malmann Becker
 * @since 25/01/2013
 * @version 1.0
 *
 * Classe Personagem
 */
public class Personagem {

    private String nome;
    protected int forca;
    private int dano;
    protected ArrayList<Recursos> recursos;
    protected Lugar lugarAtual;
    protected int hp;
    private Stack<Lugar> lugaresPassados;
    protected int defesa;
    /**
     * Método Construtor Default
     */
    public Personagem() {
        this.recursos = new ArrayList<>();
        this.lugaresPassados = new Stack<>();      
    }

    /**
     * Método que retornará o Nome do Personagem.
     *
     * @return nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método que setará o nome do personagem.
     *
     * @param nome passa como parâmetro o nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que retornará a força do Personagem.
     *
     * @return forca
     */
    public int getForca() {
        return this.forca;
    }

    /**
     * Método que setará a força
     *
     * @param forca passa como parâmetro a força
     */
    public void setForca(int forca) {
        this.forca = forca;
    }

    /**
     * Método para ganharForca a força
     *
     * @param forca passa como parâmetro a força ganho
     */
    public void ganharForca(int forca) {
        if (getForca() + forca > 200) {
            this.forca = 200;
        } else {
            this.forca += forca;
        }
    }

    /**
     * Método para perder força
     *
     * @param forca passa como parâmetro a força perdida
     * @return boolean Retorna se personagem está vivo ou não
     */
    public boolean perderForca(int forca) {
        if (this.forca - forca <= 0) {
            this.forca = 0;
        } else {
            this.forca -= forca;
        }
        return perderHP(10);
    }

    /**
     * Método que retornará a lista de recursos do Personagem.
     *
     * @return recursos
     */
    public ArrayList<Recursos> getRecursos() {
        return this.recursos;
    }

    /**
     * Método que setará a lista de recursos do personagem.
     *
     * @param recursos passa como parâmetro a lista de recursos
     */
    public void setRecursos(ArrayList<Recursos> recursos) {
        this.recursos = recursos;
    }

    /**
     * Método que retornará a Dica.
     *
     * @return dica
     */
    public String mostrarDica(Lugar lugarAtual, Lugar ultimoLugar) {
        return "Siga pelo lugar: " + verificarDicaLugar(lugarAtual, ultimoLugar).getNome();
    }
    
    /**
     * Método Verificar Dica Lugar Certo ou Errado, cfe se for amigo ou inimigo
     *
     * @param Lugar - passa o lugar atual
     * @param Lugar - passa o ultimo lugar passado
     * @return Lugar - retorna o lugar certo ou errado
     */
    protected Lugar verificarDicaLugar(Lugar lugarAtual, Lugar ultimoLugar) {
        return null;
    }

    /**
     * Método que retornará o lugar atual do Personagem.
     *
     * @return lugarAtual
     */
    public Lugar getLugarAtual() {
        return this.lugarAtual;
    }

    /**
     * Método que retornará o HP do Personagem.
     *
     * @return hp
     */
    public int getHp() {
        return this.hp;
    }

    /**
     * Método para beber, retorna uma String.
     *
     * @return saida
     */
    public String beber() {
        String saida;
        if (recursos.get(1).getQuantidade()>0){
            ganharHP(10);
            recursos.get(1).setQuantidade(recursos.get(1).getQuantidade()-1);
            saida = "Você bebeu água do cantil e ganhou 10 de hp. Seus pontos de vida estão em: "+getHp();
        } else {
            saida = "Seu cantil está vazio.";
        }
        return saida;
    }

    /**
     * Método para comer
     *
     * @param comida passa como parametro a comida a ser comida
     */
    public void comer(Comida comida) {
        ganharHP(comida.getHp());
    }

    /**
     * Método para dormir
     *
     */
    public void dormir() {
        ganharHP(20);
    }

    /**
     * Método para ganhar pontos de vida
     *
     * @param hp passa como parâmetro os pontos de vida ganhos
     */
    public void ganharHP(int hp) {
        if (this.hp + hp > 100) {
            this.setHp(100);
        } else {
            this.setHp(this.hp + hp);
        }
    }

    /**
     * Método para perder pontos de vida
     *
     * @param hp passa como parâmetro os pontos de vida perdidos
     * @return boolean Retorna se personagem está vivo ou não
     */
    public boolean perderHP(int hp) {
        if (this.hp - hp <= 0) {
            this.setHp(0);
        } else {
            this.setHp(this.hp - hp);
        }
        return isAlive();
    }

    /**
     * Método para andar
     *
     * @param lugar passa como parâmetro o lugar que irá andar
     * @param boolean passa se vai andar com cavalo ou não
     * @return boolean - retorna se andou
     */
    public boolean andar(Lugar lugar, boolean comCavalo) {
        if (this.lugarAtual != null) {
            this.getLugaresPassados().push(this.lugarAtual);
            if (comCavalo) {
                return caminhar(lugar, false);
            } else {
                return caminhar(lugar, true);
            }
        } else {
            return caminhar(lugar, false);
        }

    }

    /**
     * Método para voltar
     *
     * @return boolean - retorna se voltou
     */
    public boolean voltar() {
        if (this.lugaresPassados.isEmpty()) {
            return false;
        } else {
            boolean caminhou = caminhar(getLugaresPassados().lastElement(), true);
            this.getLugaresPassados().pop();
            return caminhou;
        }
    }

    /**
     * Método privado apenas para setar o lugar e perderHP
     *
     * @param Lugar - passa o lugar que irá caminhar
     * @param boolean - passa se é para perder HP ou não
     * @return boolean - retorna se caminhou
     */
    private boolean caminhar(Lugar lugar, boolean perderHP) {
        if (lugar != null) {
            this.lugarAtual = lugar;
            if (perderHP) {
                perderHP(10);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para verificar se o mensageiro está vivo
     *
     * @return boolean - retorna se está vivo
     */
    public boolean isAlive() {
        if (getHp() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Método que retornará os lugares passados.
     *
     * @return Stack<Lugar>
     */
    public Stack<Lugar> getLugaresPassados() {
        return this.lugaresPassados;
    }

    /**
     * @return the defesa
     */
    public int getDefesa() {
        return defesa;
    }

    /**
     * @param defesa the defesa to set
     */
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    /**
     * @param hp the hp to set
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * @return the dano
     */
    public int getDano() {
        return dano;
    }

    /**
     * @param dano the dano to set
     */
    public void setDano(int dano) {
        this.dano = dano;
    }
}
