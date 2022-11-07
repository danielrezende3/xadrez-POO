package modelo;

public class Peao extends Peca {

    private boolean primeiroMovimento = true;

    public Peao(EnumCor cor, int linha, int coluna) {
        super(cor, linha, coluna, "figs/PEAO" + cor + ".png");
    }

    public Peao(EnumCor cor, int linha, int coluna, String image) {
        super(cor, linha, coluna, image);
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        if(colunaDestino != getColuna())
        {
            return false;
        }
        return true;
    }
}
