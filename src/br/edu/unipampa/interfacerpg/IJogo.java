package br.edu.unipampa.interfacerpg;

import br.edu.unipampa.desafio.DesafioLuta;
import br.edu.unipampa.narrativa.Narrativa;
import br.edu.unipampa.recursos.Arma;
import br.edu.unipampa.recursos.Recursos;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * IJogo
 *
 * @author Alex Malmann Becker
 * @author Anderson Raugust
 * @author Antoni Sganzerla
 * @author Miguel J Zinelli
 * @author Edison Jhonatan R. Moura
 * @since 25/01/2013
 * @version 1.0
 *
 * Interface IJogo
 */
public class IJogo extends JFrame {

    private Narrativa narrativa;
    private BorderLayout layout;
    private JPanel panelEast, panelEastNorth, panelEastSouth;
    private JPanel panelCenter, panelCenterSouth, panelWest, panelWestNorth, panelWestSouth;
    private JLabel labelImagemHistoriaInicial;
    private JPanel painelDoAndar, painelDoComer;
    private JTextArea textSaidaDeDados;
    private JScrollPane scrollSaidaDeDados;
    private JLabel texto, espaco;
    private JLabel lugarInicial, ponte, trilho, ctg, fazenda, deserto, corredeira, acampamento, sedeAlegrete;
    private JLabel mochila, textComer;
    private JFrame frameAndar, janelaDesafioCharada, frameComer;
    private JButton respostasCharada[];
    private JLabel descricaoDesafioCharada;
    private JButton botaoVerifica, botaoUsar;
    private JLabel hp, posicao, mostraPosicao, forca, defesa, arma, escudo;
    private JProgressBar HPBar;
    private JButton andar, comer, beber, dormir;
    private JButton BPorco, BMaca, BPinhao;
    private JLabel jLabelAndar;
    private JButton BNorte, BSul, BLeste, BOeste;
    private JComboBox comboR;
    private JLabel inimigo, imagemInimigo, hpInimigo;
    private JButton botaoAtacarOuCharada, botaoDefenderOuVerDica;
    private TrataBotoes tratador;
    private boolean flagCharada, flagBatalha, flagDica, flagSorteioCharada;

    /**
     * Método construtor responsável por levantar a estrutura da interface
     * criando a janela de interações e os paines de que iram compor a janela...
     *
     * @param narrativa Objeto do tipo narrativa para acesso ao personagem,
     * cenario, recurso e desafios do jogo.
     */
    public IJogo(Narrativa narrativa) {
        super.setTitle("Rpg Aventura Solo");
        tratador = new TrataBotoes();
        layout = new BorderLayout(0, 0);
        setLayout(layout);
        this.narrativa = narrativa;

        criarEstruturaInicialPaineis();
        criarPainelMensageiro();
        criarFrameAndar();
        criarFrameComer();
        criarFrameDesafios();
        criarPainelMapa();
        criarPainelRecursos();
        criarImagemInfoMissao();
        criarPainelSaidaDeDados();
        vincularPaineisContainer();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * Método que cria a estrutura inicial dos paineis
     */
    private void criarEstruturaInicialPaineis() {
        //add panel centro
        panelCenter = new JPanel();
        panelCenter.setBackground(Color.black);
        
        panelCenterSouth = new JPanel();
        panelCenterSouth.setBackground(Color.black);
        panelCenterSouth.setPreferredSize(new Dimension(400, 350));
        
        //add panel leste
        panelEast = new JPanel();
        panelEast.setBackground(Color.black);
        panelEast.setPreferredSize(new Dimension(250, 700));
        
        panelEastNorth = new JPanel();
        panelEastNorth.setBackground(Color.black);
        panelEastNorth.setPreferredSize(new Dimension(250, 350));
        
        panelEastSouth = new JPanel();
        panelEastSouth.setBackground(Color.black);
        panelEastSouth.setPreferredSize(new Dimension(250, 350));
        panelEastSouth.setLayout(null);

        //add panel oeste
        panelWest = new JPanel();
        panelWest.setBackground(Color.black);
        panelWest.setPreferredSize(new Dimension(250, 700));
        
        panelWestNorth = new JPanel();
        panelWestNorth.setPreferredSize(new Dimension(250, 350));
        panelWestNorth.setBackground(Color.black);
        
        panelWestSouth = new JPanel();
        panelWestSouth.setBackground(Color.black);
        panelWestSouth.setPreferredSize(new Dimension(250, 350));
    }

    /**
     * Painel designado a representação da Missão.. Localizado na parte superior
     * central da tela. Para essa representação foi adicionada apenas um JLabel
     * com uma imagem..
     */
    private void criarImagemInfoMissao() {
        ImageIcon imageHistoriaInicial = new ImageIcon("src\\br\\edu\\unipampa\\images\\imagemCentroJogoHistoriaInicial.jpg");
        labelImagemHistoriaInicial = new JLabel(imageHistoriaInicial);
    }

    /**
     * Método que cria o painel do mensageiro, contendo as informações dele, 
     * e os botões de ação que poderá executar no jogo
     */
    private void criarPainelMensageiro() {
        texto = new JLabel("              " + narrativa.getMensageiro().getNome() + "               ");
        texto.setFont(new Font("Monospaced", 1, 24));
        texto.setForeground(Color.white);
        panelEastNorth.add(texto);
        hp = new JLabel("Pontos de vida: ");
        hp.setFont(new Font("Monospaced", 1, 18));
        hp.setForeground(Color.white);
        panelEastNorth.add(hp);
        HPBar = new JProgressBar();
        HPBar.setValue(narrativa.getMensageiro().getHp());
        panelEastNorth.add(HPBar);
        posicao = new JLabel("Posicao: ");
        posicao.setFont(new Font("Monospaced", 1, 18));
        posicao.setForeground(Color.white);
        panelEastNorth.add(posicao);
        mostraPosicao = new JLabel("" + narrativa.getMensageiro().getLugarAtual().getNome());
        mostraPosicao.setFont(new Font("Monospaced", 1, 18));
        mostraPosicao.setForeground(Color.white);
        panelEastNorth.add(mostraPosicao);

        forca = new JLabel("Força de Ataque: " + narrativa.getMensageiro().getForca());
        forca.setFont(new Font("Monospaced", 1, 18));
        forca.setForeground(Color.white);
        panelEastNorth.add(forca);

        defesa = new JLabel("Defesa: " + narrativa.getMensageiro().getDefesa() + "  ");
        defesa.setFont(new Font("Monospaced", 1, 18));
        defesa.setForeground(Color.white);
        panelEastNorth.add(defesa);

        arma = new JLabel("Arma: --- ");
        arma.setFont(new Font("Monospaced", 1, 18));
        arma.setForeground(Color.white);
        panelEastNorth.add(arma);

        escudo = new JLabel("Escudo: ---     ");
        escudo.setFont(new Font("Monospaced", 1, 18));
        escudo.setForeground(Color.white);
        panelEastNorth.add(escudo);

        comer = new JButton("Comer");
        comer.addActionListener(tratador);
        beber = new JButton("Beber");
        beber.addActionListener(tratador);
        dormir = new JButton("Dormir");
        dormir.addActionListener(tratador);
        panelEastNorth.add(comer);
        panelEastNorth.add(beber);
        panelEastNorth.add(dormir);
        andar = new JButton("Andar");
        andar.setEnabled(false);
        andar.addActionListener(tratador);
        panelEastNorth.add(andar);
    }

    /**
     * Método que cria o form de andar, com os quatro caminhos possiveis
     */
    private void criarFrameAndar() {
        frameAndar = new JFrame();
        frameAndar.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frameAndar.setVisible(false);
        frameAndar.setTitle("Andar");
        frameAndar.setSize(280, 200);
        frameAndar.setLocationRelativeTo(null);
        frameAndar.setResizable(false);
        frameAndar.setBackground(Color.WHITE);
        painelDoAndar = new JPanel(new FlowLayout());
        frameAndar.add(painelDoAndar);
        jLabelAndar = new JLabel();
        jLabelAndar.setText("************** Escolha um caminho **************");
        painelDoAndar.add(jLabelAndar);
        BNorte = new JButton(narrativa.getMensageiro().getLugarAtual().getVizinhos().get(2).getNome());
        BNorte.addActionListener(tratador);
        BSul = new JButton(narrativa.getMensageiro().getLugarAtual().getVizinhos().get(3).getNome());
        BSul.addActionListener(tratador);
        BLeste = new JButton(narrativa.getMensageiro().getLugarAtual().getVizinhos().get(0).getNome());
        BLeste.addActionListener(tratador);
        BOeste = new JButton(narrativa.getMensageiro().getLugarAtual().getVizinhos().get(1).getNome());
        BOeste.addActionListener(tratador);

        painelDoAndar.add(BSul);
        painelDoAndar.add(BLeste);
        painelDoAndar.add(BOeste);
        painelDoAndar.add(BNorte);
    }

    /**
     * Método que cria o form para comer, com três tipos de comida
     */
    private void criarFrameComer() {
        frameComer = new JFrame();
        frameComer.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frameComer.setVisible(false);
        frameComer.setTitle("Comer");
        frameComer.setSize(280, 100);
        frameComer.setLocationRelativeTo(null);
        frameComer.setResizable(false);
        frameComer.setBackground(Color.WHITE);
        painelDoComer = new JPanel(new FlowLayout());
        frameComer.add(painelDoComer);
        BPorco = new JButton("Porco Assado");
        BPorco.addActionListener(tratador);
        BMaca = new JButton("Maçã");
        BMaca.addActionListener(tratador);
        BPinhao = new JButton("Pinhão");
        BPinhao.addActionListener(tratador);
        textComer = new JLabel("*********** Escolha o que comer! **********");
        painelDoComer.add(textComer);
        painelDoComer.add(BPorco);
        painelDoComer.add(BMaca);
        painelDoComer.add(BPinhao);
    }

    /**
     * Painel designado inicialmente para representação do Desafio, sendo que
     * esta pode ser preenchida com um Amigo ou Inimigo.. Localizado na parte
     * inferior direita da tela do usuário. Para essa representação foram
     * criados objetos JLabel para formar representações, sendo elas imagens ou
     * textos para cada situação no decorrer do jogo.
     */
    private void criarFrameDesafios() {
        botaoAtacarOuCharada = new JButton();
        botaoDefenderOuVerDica = new JButton();
        imagemInimigo = new JLabel(new javax.swing.ImageIcon());
        hpInimigo = new JLabel();
        inimigo = new JLabel();

        janelaDesafioCharada = new JFrame("Desafio Charada");
        janelaDesafioCharada.setLocationRelativeTo(null);
        janelaDesafioCharada.setResizable(false);
        janelaDesafioCharada.setBackground(Color.WHITE);
        janelaDesafioCharada.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        janelaDesafioCharada.setLocationRelativeTo(null);
        descricaoDesafioCharada = new JLabel();
        respostasCharada = new JButton[3];
        respostasCharada[0] = new JButton();
        respostasCharada[0].addActionListener(tratador);
        respostasCharada[1] = new JButton();
        respostasCharada[1].addActionListener(tratador);
        respostasCharada[2] = new JButton();
        respostasCharada[2].addActionListener(tratador);
        configurarPainelDesafio();
    }

    /**
     * Painel designado a representação do Mapa.. Localizado na parte superior
     * esquerda da tela. Para essa representação foram criados 9 objetos JLabel
     * para formar icones de cada lugar do jogo. Também foi criado um Label com
     * o texto "Mapa" para identificação.
     */
    private void criarPainelMapa() {
        texto = new JLabel("                                 MAPA                                 ");
        texto.setFont(new Font("Monospaced", 1, 24));
        texto.setForeground(Color.white);
        panelWestNorth.add(texto);
        espaco = new JLabel("                                                                      ");
        panelWestNorth.add(espaco);
        lugarInicial = new JLabel(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\Inicio.jpg"));
        panelWestNorth.add(lugarInicial);
        ponte = new JLabel(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\ponte.jpg"));
        panelWestNorth.add(ponte);
        trilho = new JLabel(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\trilho.jpg"));
        panelWestNorth.add(trilho);
        ctg = new JLabel(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\ctg.jpg"));
        panelWestNorth.add(ctg);
        fazenda = new JLabel(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\fazenda.jpg"));
        panelWestNorth.add(fazenda);
        deserto = new JLabel(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\deserto.jpg"));
        panelWestNorth.add(deserto);
        corredeira = new JLabel(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\charcoSul.jpg"));
        panelWestNorth.add(corredeira);
        acampamento = new JLabel(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\acampamento.jpg"));
        panelWestNorth.add(acampamento);
        sedeAlegrete = new JLabel(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\sedeAlegrete.jpg"));
        panelWestNorth.add(sedeAlegrete);
    }

    /**
     * Painel designado a representação dos Recursos.. Localizado na parte
     * inferior esquerda da tela. Para essa representação foi adicionada uma
     * imagem que representa a mochila do personagem. Foi tambem adicionado um
     * JComboBox para mostrar os recursos disponiveis na mochila do personagem e
     * um JButton "EQUIPAR" para que ele possa ativar instantaneamente o recurso
     * para ser utilizado.
     */
    private void criarPainelRecursos() {
        texto = new JLabel("RECURSOS");
        texto.setFont(new Font("Monospaced", 1, 18));
        texto.setForeground(Color.white);
        panelWestSouth.add(texto);
        botaoVerifica = new JButton();
        botaoVerifica.addActionListener(tratador);
        botaoUsar = new JButton("Equipar");
        mochila = new JLabel(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\bag.jpg"));
        panelWestSouth.add(mochila);
        comboR = new JComboBox();
        botaoUsar.addActionListener(tratador);
        panelWestSouth.add(botaoUsar);
        panelWestSouth.add(comboR);
        comboR.addItem(narrativa.getMensageiro().getRecursos().get(0).getNome());
    }

    /**
     * Painel designado a representação da Saida de Dados.. Localizado na parte
     * inferior central da tela. Para essa representação foi adicionada uma
     * JTextArea e um JScrollPane ou barra de rolagem para que o usuário possa
     * acompanhar o histórico de suas ações em cada Lugar no jogo...
     */
    private void criarPainelSaidaDeDados() {
        textSaidaDeDados = new JTextArea();
        textSaidaDeDados.setEditable(false);
        textSaidaDeDados.setColumns(46);
        textSaidaDeDados.setFont(new Font("Monospaced", 1, 14));
        textSaidaDeDados.setForeground(new Color(204, 0, 0));
        textSaidaDeDados.setLineWrap(true);
        textSaidaDeDados.setRows(15);
        textSaidaDeDados.setText("*********** INÍCIO DA AVENTURA ***********");
        textSaidaDeDados.setRequestFocusEnabled(false);
        scrollSaidaDeDados = new JScrollPane(textSaidaDeDados);
    }

    /**
     * Método para fazer o vinculos dos painéis aos seus containers
     */
    private void vincularPaineisContainer() {
        add(panelEast, BorderLayout.EAST);
        panelEast.add(panelEastNorth, BorderLayout.NORTH);
        panelEast.add(panelEastSouth, BorderLayout.SOUTH);
        add(panelCenter, BorderLayout.CENTER);
        panelCenter.add(labelImagemHistoriaInicial, BorderLayout.NORTH);
        panelCenter.add(panelCenterSouth, BorderLayout.SOUTH);
        panelCenterSouth.add(scrollSaidaDeDados);
        add(panelWest, BorderLayout.WEST);
        panelWest.add(panelWestNorth, BorderLayout.NORTH);
        panelWest.add(panelWestSouth, BorderLayout.SOUTH);
    }

    /**
     * Método responsável por ajustar o nome do quem irá compor o painel do
     * desafio
     */
    private void ajustarNomeDoInimigoOuAmigo() {

        if (narrativa.getMensageiro().getLugarAtual().getInimigo() != null) {
            inimigo.setText(narrativa.getMensageiro().getLugarAtual().getInimigo().getNome());
        } else {
            inimigo.setText(narrativa.getMensageiro().getLugarAtual().getAmigo().getNome());
        }
        inimigo.setFont(new Font("Monospaced", 1, 24));
        inimigo.setForeground(Color.white);
    }

    /**
     * Método que finaliza o jogo quando o usuário morrer, acontecerá em duas
     * possibilidades: Quando o usuario escolher andar para um Lugar inexistente
     * ou Abismo; ou Quando sua vida cheegar a zero.
     */
    private void encerrarJogo() {
        if (narrativa.getMensageiro().getLugarAtual().getAmigo() == null
                && narrativa.getMensageiro().getLugarAtual().getInimigo() == null) {
            if (narrativa.getMensageiro().getLugarAtual().getDesafio() == null) {
                JOptionPane.showMessageDialog(null, "VocÊ caiu no Abismo!!!");
                System.exit(0);
            }
        }
        if (narrativa.getMensageiro().getHp() <= 0) {
            JOptionPane.showMessageDialog(null, "VOCÊ MORREU!!!");
            System.exit(0);
        }
    }

    /**
     * Método responsavel por atualizar alguns booleans para impedir que o um
     * evento seja executado mais de uma vez este foi um dos problemas
     * encontrados durante nosso contato com a interface. A maneira que
     * encontramos de resolver o problema foi usando variaveis booleanas.
     */
    private void configurarFlags() {
        flagSorteioCharada = false;
        flagBatalha = false;
        flagCharada = false;
        flagDica = false;
    }

    /**
     * Método que altera as imagens do Mapa, conforme o usuário se movimenta de
     * um Lugar para outro.. Estou ciente que esta cheio de if's, mas tentei
     * usar switch case mas tive problemas...
     */
    private void modificaImagemLugarPassado() {
        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("Ponte")) {
            ponte.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\ponte(2).jpg"));
        }

        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("Trilho")) {
            trilho.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\trilho(3).jpg"));
        }

        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("CTG")) {
            ctg.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\ctg(4).jpg"));
        }
        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("Fazenda")) {
            fazenda.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\fazenda(5).jpg"));
        }
        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("Deserto")) {
            deserto.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\deserto(6).jpg"));
        }
        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("Charco Sul")) {
            corredeira.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\charcoSul(7).jpg"));
        }

        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("Acampamento")) {
            acampamento.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\acapamento(8).jpg"));
        }
        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("Sede de Alegrete")) {
            sedeAlegrete.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\sedeAlegrete(9).jpg"));
        }
    }

    /**
     * Método que altera as imagens do Mapa conforme o usuário decide voltar de
     * um Lugar para outro durante o jogo...
     */
    private void modificaImagemLugaresAnteriores() {
        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("Ponte")) {
            ponte.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\ponte.jpg"));
        }

        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("Trilho")) {
            trilho.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\trilho.jpg"));
        }

        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("CTG")) {
            ctg.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\ctg.jpg"));
        }
        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("Fazenda")) {
            fazenda.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\fazenda.jpg"));
        }
        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("Deserto")) {
            deserto.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\deserto.jpg"));
        }
        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("Charco Sul")) {
            corredeira.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\charcoSul.jpg"));
        }

        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("Acampamento")) {
            acampamento.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\acampamento.jpg"));
        }
        if (narrativa.getMensageiro().getLugarAtual().getNome().equals("Sede de Alegrete")) {
            sedeAlegrete.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\sedeAlegrete.jpg"));
        }
    }

    /**
     * Método que informa na Saida de Dados em qual lugar o usuário se encontra
     * no jogo, utilizado para manter o histórico de lugares.
     */
    private void mostraNomeLugar() {
        textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n************* "
                + narrativa.getMensageiro().getLugarAtual().getNome() + " *************");
    }

    /**
     * Método que configura a batalha para o desafio Luta
     *
     * @param quemAtaca nome de quem irá atacar no turno
     * @param quemMorreu nome de quem sofre o dano no turno.
     */
    private void configuraBatalha(String quemAtaca, String quemMorreu) {
        if ((narrativa.getMensageiro().getHp() > 0) || (narrativa.getMensageiro().getLugarAtual().getInimigo().getHp() > 0)) {
            textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n--------- " + quemAtaca + " está atacando ---------");
            String x = narrativa.getMensageiro().getLugarAtual().executarLugar(narrativa.getMensageiro(), narrativa.getMensageiro().getLugarAtual().getDesafio().sorteiaNumeroCharada());
            textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n" + x);
            HPBar.setValue(narrativa.getMensageiro().getHp());
        } else {
            textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n+" + quemMorreu + "morreu durante a batalha =/");
        }
    }

    /**
     * Método que configura qual será a charada sorteada para o desafio
     * Charada...
     */
    private void configuraCharada() {
        janelaDesafioCharada.setLayout(new FlowLayout());
        janelaDesafioCharada.setSize(250, 150);
        janelaDesafioCharada.setVisible(true);
        String texto = narrativa.getMensageiro().getLugarAtual().executarLugar(narrativa.getMensageiro(), narrativa.getMensageiro().getLugarAtual().getDesafio().sorteiaNumeroCharada());
        descricaoDesafioCharada.setText(texto);
        textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n ------- Charada -------\n" + texto);
        int teste = narrativa.getMensageiro().getLugarAtual().getDesafio().getNumCharada();
        janelaDesafioCharada.add(descricaoDesafioCharada);
        if (teste == 0) {
            respostasCharada[0].setText("Uruguaina");
            respostasCharada[1].setText("Alegrete");
            respostasCharada[2].setText("Caxias do Sul");
        } else if (teste == 1) {
            respostasCharada[0].setText("16");
            respostasCharada[1].setText("256");
            respostasCharada[2].setText("128");
        } else {
            respostasCharada[0].setText("RJ");
            respostasCharada[1].setText("RS");
            respostasCharada[2].setText("SP");
        }
        janelaDesafioCharada.add(respostasCharada[0]);
        janelaDesafioCharada.add(respostasCharada[1]);
        janelaDesafioCharada.add(respostasCharada[2]);
    }

    /**
     * Método responsável por configurar o painel do desafio, sendo que este
     * pode ser preenchido com um Amigo ou Inimigo, dependendo de qual Lugar o
     * usuário se encontra e qual o desafio deve ser realizado...
     */
    private void configurarPainelDesafio() {
        if (narrativa.getMensageiro().getLugarAtual().getDesafio() instanceof DesafioLuta) {
            ajustarNomeDoInimigoOuAmigo();
            inimigo.setForeground(new Color(204, 0, 0));
            inimigo.setBounds(SwingConstants.BOTTOM, 30, 200, 50);
            imagemInimigo.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\kratos.jpg"));
            imagemInimigo.setBounds(SwingConstants.BOTTOM, 100, 100, 100);
            hpInimigo.setText("HP: " + narrativa.getMensageiro().getLugarAtual().getInimigo().getHp());
            hpInimigo.setForeground(new Color(204, 0, 0));
            hpInimigo.setBounds(SwingConstants.BOTTOM, 60, 200, 50);
            hpInimigo.setVisible(true);
            panelEastSouth.add(inimigo);
            panelEastSouth.add(hpInimigo);
            panelEastSouth.add(imagemInimigo);

            botaoAtacarOuCharada.setText("Atacar");
            botaoDefenderOuVerDica.setText("Defender");
            botaoAtacarOuCharada.setBounds(20, 250, 90, 40);
            botaoDefenderOuVerDica.setBounds(120, 250, 90, 40);

            panelEastSouth.add(botaoAtacarOuCharada);
            panelEastSouth.add(botaoDefenderOuVerDica);
            botaoAtacarOuCharada.addActionListener(tratador);
            botaoDefenderOuVerDica.addActionListener(tratador);
            botaoDefenderOuVerDica.setEnabled(false);
        } else {
            ajustarNomeDoInimigoOuAmigo();
            hpInimigo.setVisible(false);
            inimigo.setText(narrativa.getMensageiro().getLugarAtual().getAmigo().getNome());
            inimigo.setForeground(new Color(204, 0, 0));
            inimigo.setBounds(SwingConstants.BOTTOM, 30, 200, 50);
            imagemInimigo.setIcon(new javax.swing.ImageIcon("src\\br\\edu\\unipampa\\images\\homer.jpg"));
            imagemInimigo.setBounds(SwingConstants.BOTTOM, 100, 100, 100);
            panelEastSouth.add(inimigo);
            panelEastSouth.add(hpInimigo);
            panelEastSouth.add(imagemInimigo);

            botaoAtacarOuCharada.setText("Charada");
            botaoDefenderOuVerDica.setText("Ver Dica");
            botaoAtacarOuCharada.setBounds(20, 250, 90, 40);
            botaoDefenderOuVerDica.setBounds(120, 250, 90, 40);

            panelEastSouth.add(botaoDefenderOuVerDica);
            panelEastSouth.add(botaoAtacarOuCharada);
            botaoAtacarOuCharada.addActionListener(tratador);
            botaoDefenderOuVerDica.addActionListener(tratador);
            botaoDefenderOuVerDica.setEnabled(true);
        }
    }

    private class TrataBotoes implements ActionListener {

        /**
         * Método que foi criado afim de tratar os eventos, sejam eles de um
         * botão ou não.
         *
         * @param Mensageiro - Possui arraylist de recursos do mensageiro
         * @param ArrayList recursos - arrayList que contém os recursos para
         * @return nome
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == botaoUsar) {

                String objetoSelecionado = (String) comboR.getSelectedItem();

                int i = 0;
                for (i = 0; i < narrativa.getMensageiro().getRecursos().size(); i++) {
                    if (objetoSelecionado.equals(narrativa.getMensageiro().getRecursos().get(i).getNome())) {
                        break;
                    }
                }
                Arma armaSelecionada = (Arma) narrativa.getMensageiro().getRecursos().get(i);
                if (armaSelecionada.getCategoria().equals("defesa")) {
                    JOptionPane.showMessageDialog(null, "Você foi equipado com " + armaSelecionada.getNome());
                    narrativa.getMensageiro().setDefesa(15 + armaSelecionada.getForca());
                    defesa.setText("Força da Defesa: " + narrativa.getMensageiro().getDefesa());
                    escudo.setText("Escudo: " + armaSelecionada.getNome());
                    textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n=== Você foi equipado com " + armaSelecionada.getNome() 
                            + ". Sua força de defesa está em: "+narrativa.getMensageiro().getDefesa()+" ===");
                } else {
                    JOptionPane.showMessageDialog(null, "Você foi equipado com " + armaSelecionada.getNome());
                    narrativa.getMensageiro().setForca(45 + armaSelecionada.getForca());
                    forca.setText("Força de Ataque: " + narrativa.getMensageiro().getForca());
                    arma.setText("Arma: " + armaSelecionada.getNome());
                    textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n=== Você foi equipado com " + armaSelecionada.getNome() 
                            + ". Sua força de Ataque está em: "+narrativa.getMensageiro().getForca()+" ===");
                }
            }

            if (e.getSource() == andar) {
                botaoAtacarOuCharada.setEnabled(true);
                frameAndar.setVisible(true);
                andar.setEnabled(false);
            }

            if (e.getSource() == BNorte) {
                frameAndar.setVisible(false);
                if (BNorte.getText().equals("Voltar")) {
                    modificaImagemLugaresAnteriores();
                    narrativa.getMensageiro().voltar();
                    if (narrativa.getMensageiro().getLugarAtual().getDesafio() instanceof DesafioLuta) {
                        narrativa.getMensageiro().getLugarAtual().getInimigo().setHp(50);
                    }
                } else {
                    narrativa.getMensageiro().andar(narrativa.getMensageiro().getLugarAtual().getVizinhos().get(2), false);
                    modificaImagemLugarPassado();
                }
                mostraPosicao.setText("" + narrativa.getMensageiro().getLugarAtual().getNome());
                mostraNomeLugar();
                encerrarJogo();
                setaBotoes();
                configurarFlags();
                configurarPainelDesafio();
            }

            if (e.getSource() == BSul) {
                frameAndar.setVisible(false);
                if (BSul.getText().equals("Voltar")) {
                    modificaImagemLugaresAnteriores();
                    narrativa.getMensageiro().voltar();
                    if (narrativa.getMensageiro().getLugarAtual().getDesafio() instanceof DesafioLuta) {
                        narrativa.getMensageiro().getLugarAtual().getInimigo().setHp(50);
                    }
                } else {
                    narrativa.getMensageiro().andar(narrativa.getMensageiro().getLugarAtual().getVizinhos().get(3), false);
                    modificaImagemLugarPassado();
                }
                mostraPosicao.setText("" + narrativa.getMensageiro().getLugarAtual().getNome());
                mostraNomeLugar();
                encerrarJogo();
                setaBotoes();
                configurarFlags();
                configurarPainelDesafio();
            }

            if (e.getSource() == BLeste) {
                frameAndar.setVisible(false);
                if (BLeste.getText().equals("Voltar")) {
                    modificaImagemLugaresAnteriores();
                    narrativa.getMensageiro().voltar();
                    if (narrativa.getMensageiro().getLugarAtual().getDesafio() instanceof DesafioLuta) {
                        narrativa.getMensageiro().getLugarAtual().getInimigo().setHp(50);
                    }
                } else {
                    narrativa.getMensageiro().andar(narrativa.getMensageiro().getLugarAtual().getVizinhos().get(0), false);
                    modificaImagemLugarPassado();
                }
                mostraPosicao.setText("" + narrativa.getMensageiro().getLugarAtual().getNome());
                mostraNomeLugar();
                encerrarJogo();
                setaBotoes();
                configurarFlags();
                configurarPainelDesafio();
            }

            if (e.getSource() == BOeste) {
                frameAndar.setVisible(false);
                if (BOeste.getText().equals("Voltar")) {
                    modificaImagemLugaresAnteriores();
                    narrativa.getMensageiro().voltar();
                    if (narrativa.getMensageiro().getLugarAtual().getDesafio() instanceof DesafioLuta) {
                        narrativa.getMensageiro().getLugarAtual().getInimigo().setHp(50);
                    }
                } else {
                    narrativa.getMensageiro().andar(narrativa.getMensageiro().getLugarAtual().getVizinhos().get(1), false);
                    modificaImagemLugarPassado();
                }
                mostraPosicao.setText("" + narrativa.getMensageiro().getLugarAtual().getNome());
                mostraNomeLugar();
                encerrarJogo();
                setaBotoes();
                configurarFlags();
                configurarPainelDesafio();
            }

            if (e.getSource() == dormir) {
                narrativa.getMensageiro().dormir();
                dormir.setEnabled(false);
                HPBar.setValue(narrativa.getMensageiro().getHp());
                textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n*** Você tirou um cochilo e regenerou suas forças. "
                        + "Seus pontos de vida estão em "+narrativa.getMensageiro().getHp()+ "***");
            }

            if (e.getSource() == beber) {
                String saida = narrativa.getMensageiro().beber();
                JOptionPane.showMessageDialog(null, saida);
                HPBar.setValue(narrativa.getMensageiro().getHp());
                textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n*** " + saida + " ***");
            }

            if (e.getSource() == comer) {
                frameComer.setVisible(true);
            }

            if (e.getSource() == BPorco) {
                narrativa.getMensageiro().ganharHP(20);
                frameComer.setVisible(false);
                comer.setEnabled(false);
                HPBar.setValue(narrativa.getMensageiro().getHp());
                textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n*** Você comeu um Porco Assado e ganhou 20 de HP."
                        + " Seus pontos de vida estão em "+narrativa.getMensageiro().getHp()+ "***");
            }

            if (e.getSource() == BMaca) {
                narrativa.getMensageiro().ganharHP(10);
                frameComer.setVisible(false);
                comer.setEnabled(false);
                HPBar.setValue(narrativa.getMensageiro().getHp());
                textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n*** Você comeu uma Macã e ganhou 10 de HP."
                        + " Seus pontos de vida estão em "+narrativa.getMensageiro().getHp()+ "***");
            }

            if (e.getSource() == BPinhao) {
                narrativa.getMensageiro().ganharHP(15);
                frameComer.setVisible(false);
                comer.setEnabled(false);
                HPBar.setValue(narrativa.getMensageiro().getHp());
                textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n***Você comeu um Pinhão e ganhou 15 de HP."
                        + " Seus pontos de vida estão em "+narrativa.getMensageiro().getHp()+ "***");
            }

            if (e.getSource() == botaoAtacarOuCharada) {
                if (narrativa.getMensageiro().getLugarAtual().getDesafio() instanceof DesafioLuta) {
                    if (flagBatalha == false) {
                        configuraBatalha(narrativa.getMensageiro().getNome(), narrativa.getMensageiro().getLugarAtual().getNome());
                        hpInimigo.setText("HP: " + narrativa.getMensageiro().getLugarAtual().getInimigo().getHp());
                        String texto = "";
                        if (narrativa.getMensageiro().getLugarAtual().getInimigo().getHp() <= 0) {
                            if (!verificaSePossuiRecurso(narrativa.getMensageiro().getLugarAtual().getInimigo().getRecursos().get(0))) {
                                narrativa.getMensageiro().getRecursos().add(narrativa.getMensageiro().getLugarAtual().getInimigo().getRecursos().get(0));
                                comboR.addItem(narrativa.getMensageiro().getLugarAtual().getInimigo().getRecursos().get(0).getNome());
                                texto = "\nLoot do Inimgo: "
                                        + narrativa.getMensageiro().getLugarAtual().getInimigo().getRecursos().get(0).getNome()
                                        + " --- Este Item foi add ao seu Inventário";

                            } else {
                                texto = "\nLoot do Inimgo: "
                                        + narrativa.getMensageiro().getLugarAtual().getInimigo().getRecursos().get(0).getNome()
                                        + " --- Item já foi add ao seu Inventário";
                            }
                            botaoAtacarOuCharada.setEnabled(false);
                            JOptionPane.showMessageDialog(null, texto);
                            andar.setEnabled(true);
                            textSaidaDeDados.setText(textSaidaDeDados.getText() + texto);
                            textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n--------- FIM DA LUTA ---------");
                            if (narrativa.getMensageiro().getLugarAtual().isFim() == true) {
                                JOptionPane.showMessageDialog(null, "Parabéns!!! Você venceu os desafios e conseguir entregar a Mensagem ao General!!");
                                JOptionPane.showMessageDialog(null, "Desenvolvido por:\n Anderson Raugust.\n Alex Malmann Becker."
                                        + "\n Antoni Sganzerla. \n Miguel Zinelli.\n Edison Jhonatan R. Moura.");
                                System.exit(0);
                            }
                        } else {
                            botaoDefenderOuVerDica.setEnabled(true);
                            botaoAtacarOuCharada.setEnabled(false);
                        }
                        flagBatalha = true;
                    }

                } else {
                    if (flagSorteioCharada == false) {
                        configuraCharada();
                        botaoAtacarOuCharada.setEnabled(false);
                    }
                    flagSorteioCharada = true;
                }
            }
            if (e.getSource() == botaoDefenderOuVerDica) {
                if (narrativa.getMensageiro().getLugarAtual().getInimigo() != null) {
                    if (flagBatalha == true) {
                        configuraBatalha(narrativa.getMensageiro().getLugarAtual().getInimigo().getNome(), "Você");
                        if (narrativa.getMensageiro().getHp() < 0) {
                            botaoAtacarOuCharada.setEnabled(false);
                            botaoDefenderOuVerDica.setEnabled(false);
                            textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n--------- FIM DA LUTA ---------");
                            encerrarJogo();
                        } else {
                            botaoDefenderOuVerDica.setEnabled(false);
                            botaoAtacarOuCharada.setEnabled(true);
                            encerrarJogo();
                        }
                        flagBatalha = false;
                    }
                } else {
                    if (flagDica == false) {
                        String dica = narrativa.getMensageiro().getLugarAtual().getAmigo().mostrarDica(narrativa.getMensageiro().getLugarAtual(), narrativa.getMensageiro().getLugaresPassados().lastElement());
                        textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n" + dica);
                        JOptionPane.showMessageDialog(null, dica);
                        botaoDefenderOuVerDica.setEnabled(false);
                        flagDica = true;
                    }
                }
            }
            if (e.getSource() == respostasCharada[0] || e.getSource() == respostasCharada[2]) {
                String texto = "Resposta Errada.. Você não venceu o desafio e perdeu 10 pontos de vida!!!";
                JOptionPane.showMessageDialog(null, texto);
                textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n" + texto);
                narrativa.getMensageiro().perderHP(10);
                HPBar.setValue(narrativa.getMensageiro().getHp());
                janelaDesafioCharada.setVisible(false);
                andar.setEnabled(true);
            }

            if (e.getSource() == respostasCharada[1]) {
                if (flagCharada == false) {
                    String texto = "";
                    if (!verificaSePossuiRecurso(narrativa.getMensageiro().getLugarAtual().getAmigo().getRecursos().get(0))) {
                        narrativa.getMensageiro().getRecursos().add(narrativa.getMensageiro().getLugarAtual().getAmigo().getRecursos().get(0));
                        texto = "Resposta Certa... Você venceu este desafio e ganhou um Item:\n "
                                + narrativa.getMensageiro().getLugarAtual().getAmigo().getRecursos().get(0).getNome()
                                + " --- Este Item foi add ao seu Inventário";
                        comboR.addItem(narrativa.getMensageiro().getLugarAtual().getAmigo().getRecursos().get(0).getNome());
                    } else {
                        texto = "Resposta Certa... Você venceu este desafio!";
                    }
                    JOptionPane.showMessageDialog(null, texto);
                    textSaidaDeDados.setText(textSaidaDeDados.getText() + "\n" + texto);
                    janelaDesafioCharada.setVisible(false);
                    andar.setEnabled(true);
                    flagCharada = true;
                }
            }
        }

        /**
         * Método que verifica se Mensageiro possui o recurso
         * @param recurso - passa o recurso que deseja verificar se possui
         * @return boolean - retorna true|false se tem ou não o recurso passado como parametro
         */
        private boolean verificaSePossuiRecurso(Recursos recurso) {
            boolean possuiRecurso = false;
            for (int i = 0; i < narrativa.getMensageiro().getRecursos().size(); i++) {
                if (recurso.equals(
                        narrativa.getMensageiro().getRecursos().get(i))) {
                    possuiRecurso = true;
                }
            }
            return possuiRecurso;
        }

        /**
         * Método que altera os botões do personagem a cada lugar.
         */
        private void setaBotoes() {
            BNorte.setText(narrativa.getMensageiro().getLugarAtual().getVizinhos().get(2).getNome());
            BSul.setText(narrativa.getMensageiro().getLugarAtual().getVizinhos().get(3).getNome());
            BLeste.setText(narrativa.getMensageiro().getLugarAtual().getVizinhos().get(0).getNome());
            BOeste.setText(narrativa.getMensageiro().getLugarAtual().getVizinhos().get(1).getNome());
            HPBar.setValue(narrativa.getMensageiro().getHp());
            dormir.setEnabled(true);
            comer.setEnabled(true);

            for (int i = 0; i < 4; i++) {
                if (!narrativa.getMensageiro().getLugaresPassados().isEmpty()) {
                    if (narrativa.getMensageiro().getLugaresPassados().lastElement() != null) {
                        if (narrativa.getMensageiro().getLugarAtual().getVizinhos().get(i).equals(narrativa.getMensageiro().getLugaresPassados().lastElement())) {
                            switch (i) {
                                case 0:
                                    BLeste.setText("Voltar");
                                    break;
                                case 1:
                                    BOeste.setText("Voltar");
                                    break;
                                case 2:
                                    BNorte.setText("Voltar");
                                    break;
                                case 3:
                                    BSul.setText("Voltar");
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
}
