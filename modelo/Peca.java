package modelo;

public abstract class Peca {
    private EnumCor cor;
    private int linha, coluna;
    private String image;
    private boolean eliminada = false;
    private boolean selecionada = false;
    private Tabuleiro tabuleiro;

    public Peca(EnumCor cor, int linha, int coluna, String image) {
        this.cor = cor;
        this.linha = linha;
        this.coluna = coluna;
        this.image = image;
    }

    public abstract boolean validaMovimento(int linhaDestino, int colunaDestino);

    public EnumCor getCor() {
        return cor;
    }

    public void setCor(EnumCor cor) {
        this.cor = cor;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isEliminada() {
        return eliminada;
    }

    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
    }

    public boolean isSelecionada() {
        return selecionada;
    }

    public void setSelecionada(boolean selecionada) {
        this.selecionada = selecionada;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    
}
