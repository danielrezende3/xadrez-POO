package modelo;

public class Rainha extends Peca {

    public Rainha(EnumCor cor, int linha, int coluna) {
        super(cor, linha, coluna, "figs/RAINHA" + cor + ".png");
    }
    
    public Rainha(EnumCor cor, int linha, int coluna, String image) {
        super(cor, linha, coluna, image);
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
