package modelo;

public class Torre extends Peca {

    public Torre(EnumCor cor, int linha, int coluna) {
        super(cor, linha, coluna, "figs/TORRE" + cor + ".png");
    }

    public Torre(EnumCor cor, int linha, int coluna, String image) {
        super(cor, linha, coluna, image);
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        return true;
    }

}
