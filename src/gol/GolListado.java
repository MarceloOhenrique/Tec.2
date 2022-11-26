package gol;

import PartesDaInterface.ShowBotao;
import goleiro.Goleiro;

import java.util.ArrayList;

public class GolListado {

    protected ArrayList<ParteDoGol> gol;
    protected Goleiro goleiro;
    protected int largura;
    protected int altura;
    protected ShowBotao showBotao;

    public GolListado(int altura, int largura){
        this.altura = altura;
        this.largura = largura;
        gol = new ArrayList<>();
        criarGol();
        goleiro = new Goleiro(this);
        criarDefesas();
        showBotao = new ShowBotao(gol);
    }

    private void criarGol(){
        for (int i = 0; i < altura; i++){
            for (int j = 0; j < largura; j++){
                if (checarTrave(j, i) || checarTraveSuperior(j, i)){
                    gol.add(new ParteDoGol(GolSumario.TRAVE ,i, j));
                }
                else if (checarGol(j, i)){
                    gol.add(new ParteDoGol(GolSumario.GOL, i, j));
                }
                else if (checarFora(j, i)){
                    gol.add(new ParteDoGol(GolSumario.FORA, i, j));
                }
            }
        }
    }

    private boolean checarTrave(int coluna, int linha){

        boolean colunasValidas = (coluna == 1 || coluna == largura - 2);
        boolean linhasValidas = (linha >= 2 || coluna == -1);

        return linhasValidas && colunasValidas;

    }

    private boolean checarTraveSuperior(int coluna, int linha){
        boolean colunasValidas = coluna > 0 && coluna < largura - 1;
        boolean linhaValida = linha == 1;
        return colunasValidas && linhaValida;
    }

    private boolean checarFora(int coluna, int linha){
        return coluna == 0 || coluna == largura - 1 || linha == 0;
    }

    private boolean checarGol(int coluna, int linha){
        Boolean colunasValidas = coluna >= 2 && coluna < largura - 2;

        Boolean linhasValidas = linha >= 2 && linha < altura;

        return linhasValidas && colunasValidas;
    }

    public ArrayList<ParteDoGol> getGol() {
        return gol;
    }

    private void criarDefesas(){
        for (int i = 0, j = 0; i < gol.size(); i++){
            try {
                if ((gol.get(i).coluna == goleiro.getAreaDeDefesa().get(j).coluna)
                        && (gol.get(i).linha == goleiro.getAreaDeDefesa().get(j).linha)) {

                    if (gol.get(i).getGolSumario() == GolSumario.GOL) {
                        gol.set(i, new ParteDoGol(GolSumario.AREA_DE_DEFESA, gol.get(i).linha, gol.get(i).coluna));
                    }
                    j++;
                }
            } catch (Exception e){
                break;
            }
        }
    }

    public ShowBotao getShowBotao() {
        return showBotao;
    }
}
