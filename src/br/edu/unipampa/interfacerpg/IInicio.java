package br.edu.unipampa.interfacerpg;

import br.edu.unipampa.narrativa.Narrativa;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * IInicio
 *
 * @author Alex Malmann Becker
 * @since 27/02/2013
 * @version 1.0
 *
 * Interface IInicio
 */
public class IInicio extends JFrame {

    private BorderLayout layout;
    private JPanel panelNorth;
    private JLabel labelTitulo;
    private JPanel panelCenter;
    private JLabel labelCenter;
    private JPanel panelSouth;
    private JPanel panelSouthWest;
    private JPanel panelSouthEast;
    private JButton buttonJogar;
    private JButton buttonSair;
    private Narrativa narrativa;

    /**
     * Método Construtor Default
     */
    public IInicio(Narrativa narrativa) {
        this.narrativa = narrativa;
        criarComponentsInterface();
        configurarInterface();
    }

    /**
     * Método para criar os componentes da interface
     */
    private void criarComponentsInterface() {
        //define layout
        layout = new BorderLayout(0, 0);
        setLayout(layout);

        //panel norte
        panelNorth = new JPanel();
        panelNorth.setBackground(Color.black);
        panelNorth.setPreferredSize(new Dimension(0, 25));

        labelTitulo = new JLabel("Seja Bem Vindo ao Jogo RPG Aventura Solo - O MENSAGEIRO RURAL!");
        labelTitulo.setForeground(Color.white);
        labelTitulo.setFont(new Font("Tahoma", 1, 14));

        //panel centro
        panelCenter = new JPanel();
        panelCenter.setBackground(Color.white);
        panelCenter.setPreferredSize(new Dimension(600, 625));

        //add a imagem do centro
        ImageIcon image = new ImageIcon("src\\br\\edu\\unipampa\\images\\imagemTelaPrincipal.jpg");
        labelCenter = new JLabel(image);

        //panel sul
        panelSouth = new JPanel();
        panelSouth.setBackground(new Color(0, 36, 87));
        panelSouth.setPreferredSize(new Dimension(0, 50));

        panelSouthWest = new JPanel();
        panelSouthWest.setBackground(new Color(0, 36, 87));
        panelSouthWest.setPreferredSize(new Dimension(350, 50));

        panelSouthEast = new JPanel();
        panelSouthEast.setBackground(new Color(0, 36, 87));
        panelSouthEast.setPreferredSize(new Dimension(350, 50));

        //botões
        buttonJogar = new JButton();
        buttonJogar.setText("Jogar");
        buttonJogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                //pede o nome do usuário
                String nome = JOptionPane.showInputDialog(null, "Digite seu nome:");
                narrativa.getMensageiro().setNome(nome);
                if ("".equals(nome)) { //se não digitar o nome, mostra a mensagem e não faz nada
                    JOptionPane.showMessageDialog(null, "Jogo não iniciado. Você não digitou seu nome.");
                } else { //se não foi cancelado a janela do nome, levanta o jogo
                    if (nome != null) {
                        narrativa.getMensageiro().setNome(nome);
                        setVisible(false);
                        narrativa.abrirInterfaceJogo();
                    }
                }
            }
        });

        buttonSair = new JButton();
        buttonSair.setText("Sair");
        buttonSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                System.exit(0); //fecha sistema
            }
        });

        //adiciona aos contaneir
        add(panelNorth, BorderLayout.NORTH);
        panelNorth.add(labelTitulo, BorderLayout.PAGE_START);
        add(panelCenter, BorderLayout.CENTER);
        panelCenter.add(labelCenter, BorderLayout.LINE_START);
        add(panelSouth, BorderLayout.SOUTH);
        panelSouth.add(panelSouthWest, BorderLayout.WEST);
        panelSouthWest.add(buttonJogar, BorderLayout.EAST);
        panelSouth.add(panelSouthEast, BorderLayout.EAST);
        panelSouthWest.add(buttonSair, BorderLayout.WEST);
        
    }

    /**
     * Método para configurar os parâmetros da interface
     */
    private void configurarInterface() {
        super.setTitle("Rpg Aventura Solo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550, 380);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
