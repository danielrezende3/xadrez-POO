package visao;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;

public class JCelula extends JPanel {
    private JPeca jPeca;
    private int linha, coluna;

    public JCelula(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public JCelula(JPeca jPeca) {
        this.jPeca = jPeca;
        this.linha = jPeca.getPeca().getLinha();
        this.coluna = jPeca.getPeca().getColuna();
        this.add(jPeca);
        if (jPeca.getPeca() != null && jPeca.getPeca().isSelecionada()) {
            this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        }
    }

    public JPeca getjPeca() {
        return jPeca;
    }

    public int getLinha() {
        return this.linha;
    }

    public int getColuna() {
        return this.coluna;
    }

}
