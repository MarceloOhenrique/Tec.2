package goleiro;

import gol.GolListado;
import gol.GolSumario;
import gol.ParteDoGol;

import java.util.ArrayList;
import java.util.Random;

public class Goleiro {

    protected ArrayList<ParteDoGol> areaDeDefesa;
    protected GolListado golListado;

    public Goleiro(GolListado golListado) {
        areaDeDefesa = new ArrayList<>();
        this.golListado = golListado;
        setarDefesas();
    }

    private void setarDefesas(){
        for (ParteDoGol parteDoGol: golListado.getGol()) {
            Random random = new Random();
            int escolha = random.nextInt(1, 3);

            if (escolha == 2){
                areaDeDefesa.add(new ParteDoGol(GolSumario.AREA_DE_DEFESA, parteDoGol.getLinha(), parteDoGol.getColuna()));
            }
        }
    }

    public ArrayList<ParteDoGol> getAreaDeDefesa() {
        return areaDeDefesa;
    }
}
