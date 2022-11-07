package modelo;

import java.util.ArrayList;
import java.util.List;

import visao.JXadrez;

public class Tabuleiro {
    private Peca[][] peca;
    private Peca pecaselecionada = null;
    private EnumCor vez = EnumCor.BRANCO;
    private List<Peca> pecasForaDeJogo;

    public List<Peca> getPecasForaDeJogo() {
        return pecasForaDeJogo;
    }

    public void setPecasForaDeJogo(List<Peca> pecasForaDeJogo) {
        this.pecasForaDeJogo = pecasForaDeJogo;
    }

    public EnumCor getVez() {
        return vez;
    }

    public void setVez(EnumCor vez) {
        this.vez = vez;
    }


    public Tabuleiro() {
        this.peca = new Peca[8][8];
        this.pecasForaDeJogo = new ArrayList<>();
        Torre torreBranca1 = new Torre(EnumCor.BRANCO, 0, 0);
        Torre torreBranca2 = new Torre(EnumCor.BRANCO, 0, 7);
        this.adicionaPeca(torreBranca1);
        this.adicionaPeca(torreBranca2);
        Torre torrePreta1 = new Torre(EnumCor.PRETO, 7, 0);
        Torre torrePreta2 = new Torre(EnumCor.PRETO, 7, 7);
        this.adicionaPeca(torrePreta1);
        this.adicionaPeca(torrePreta2);

        Cavalo cavaloBranco1 = new Cavalo(EnumCor.BRANCO, 0, 1);
        Cavalo cavaloBranco2 = new Cavalo(EnumCor.BRANCO, 0, 6);
        this.adicionaPeca(cavaloBranco1);
        this.adicionaPeca(cavaloBranco2);
        Cavalo cavaloPreto1 = new Cavalo(EnumCor.PRETO, 7, 1);
        Cavalo cavaloPreto2 = new Cavalo(EnumCor.PRETO, 7, 6);
        this.adicionaPeca(cavaloPreto1);
        this.adicionaPeca(cavaloPreto2);

        Bispo bispoBranco1 = new Bispo(EnumCor.BRANCO, 0, 2);
        Bispo bispoBranco2 = new Bispo(EnumCor.BRANCO, 0, 5);
        this.adicionaPeca(bispoBranco1);
        this.adicionaPeca(bispoBranco2);
        Bispo bispoPreto1 = new Bispo(EnumCor.PRETO, 7, 2);
        Bispo bispoPreto2 = new Bispo(EnumCor.PRETO, 7, 5);
        this.adicionaPeca(bispoPreto1);
        this.adicionaPeca(bispoPreto2);

        Rainha rainhaBranco = new Rainha(EnumCor.BRANCO, 0, 3);
        Rainha rainhaPreto = new Rainha(EnumCor.PRETO, 7, 3);
        this.adicionaPeca(rainhaBranco);
        this.adicionaPeca(rainhaPreto);

        Rei reiBranco = new Rei(EnumCor.BRANCO, 0, 4);
        Rei reiPreto = new Rei(EnumCor.PRETO, 7, 4);
        this.adicionaPeca(reiBranco);
        this.adicionaPeca(reiPreto);

        for (int i = 0; i < 8; i++) {
            Peao peaoBranco = new Peao(EnumCor.BRANCO, 1, i);
            this.adicionaPeca(peaoBranco);
            Peao peaoPreto = new Peao(EnumCor.PRETO, 6, i);
            this.adicionaPeca(peaoPreto);
        }
    }

    public Peca getPeca(int linha, int coluna) {
        return this.peca[linha][coluna];
    }

    public void setPeca(Peca peca) {
        this.peca[peca.getLinha()][peca.getColuna()] = peca;
        peca.setTabuleiro(this);
    }

    public void adicionaPeca(Peca peca) {
        this.peca[peca.getLinha()][peca.getColuna()] = peca;
        peca.setTabuleiro(this);
    }

    public void selecionaPeca(Peca peca) {
        if (peca.isSelecionada()) {
            peca.setSelecionada(false);
            this.pecaselecionada = null;
        } else {
            peca.setSelecionada(true);
            this.pecaselecionada = peca;
        }
    }

    public void movePeca(Peca peca, int novaLinha, int novaColuna) {
        if (peca.validaMovimento(novaLinha, novaColuna)) {
            this.peca[peca.getLinha()][peca.getColuna()] = null;
            peca.setLinha(novaLinha);
            peca.setColuna(novaColuna);
            this.setPeca(peca);
            this.selecionaPeca(peca);
            this.inverteVez();
        }
    }

    public void inverteVez() {
        if (this.vez.equals(EnumCor.BRANCO)) {
            this.vez = EnumCor.PRETO;
        } else {
            this.vez = EnumCor.BRANCO;
        }
        JXadrez.setVez(this.vez);
    }

    public void realizaJogada(int linha, int coluna) {
        Peca peca = this.getPeca(linha, coluna);
        if (this.pecaselecionada == null) {
            if (peca != null && peca.getCor().equals(this.vez)) {
                this.selecionaPeca(peca);
            }
        } else {
            if (this.pecaselecionada == peca) {
                this.selecionaPeca(peca);

            } else {
                if (peca == null) {
                    this.movePeca(this.pecaselecionada, linha, coluna);
                }
                if (peca != null && !peca.getCor().equals(this.pecaselecionada.getCor())) {
                    peca.setEliminada(true);
                    this.pecasForaDeJogo.add(peca);
                    this.movePeca(this.pecaselecionada, linha, coluna);
                }
            }
        }
    }
}
