package gol;

import javax.swing.*;
import java.awt.*;

public class GolFeito extends JPanel {
    public GolFeito(GolListado golListado) {
        setLayout(new GridLayout(golListado.altura, golListado.largura));
        for (ParteDoGol parteDoGol: golListado.gol){
            add(parteDoGol);
        }

        setVisible(true);
    }
}
