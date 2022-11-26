package gol;

import java.awt.*;

public enum GolSumario {
    GOL(Color.green),
    TRAVE(Color.GRAY),
    FORA(Color.green),
    AREA_DE_DEFESA(Color.cyan);

    Color color;

    GolSumario(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
