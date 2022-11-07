package modelo;

public class Cavalo extends Peca {

    public Cavalo(EnumCor cor, int linha, int coluna) {
        super(cor, linha, coluna, "figs/CAVALO" + cor + ".png");
    }

    public Cavalo(EnumCor cor, int linha, int coluna, String image) {
        super(cor, linha, coluna, image);
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        // TODO Auto-generated method stub
        return true;
    }
    
}
