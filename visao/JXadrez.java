package visao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelo.EnumCor;
import modelo.Tabuleiro;

public class JXadrez extends JFrame {

    private static JLabel lbVez;
    private Tabuleiro tabuleiro;
    private JTabuleiro jtabuleiro;
    private JButton btReiniciarJogo;

    public JXadrez() {
        setTitle("Jogo de Xadrez");
        this.setLayout(new BorderLayout());
        this.tabuleiro = new Tabuleiro();
        this.jtabuleiro = new JTabuleiro(tabuleiro);

        this.add(jtabuleiro, BorderLayout.CENTER);

        JPanel pnTopo = new JPanel();
        lbVez = new JLabel("VEZ DE: BRANCO");
        pnTopo.add(lbVez);
        this.add(pnTopo, BorderLayout.NORTH);

        JPanel pnLateral = new JPanel();
        pnLateral.setLayout(new GridLayout(10, 1));
        btReiniciarJogo = new JButton("Reiniciar jogo");
        pnLateral.add(btReiniciarJogo);
        btReiniciarJogo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                reiniciaJogo();
            }
        });
        this.add(pnLateral, BorderLayout.WEST);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void reiniciaJogo() {
        this.tabuleiro = new Tabuleiro();
        this.jtabuleiro.setTabuleiro(tabuleiro);
        this.jtabuleiro.desenhaTabuleiro();
        setVez(tabuleiro.getVez());
    }

    public static void setVez(EnumCor corVez) {
        lbVez.setText("VEZ DE:" + corVez);
    }

    public static void main(String[] args) {
        new JXadrez();
    }
}
