import PartesDaInterface.Menu;
import gol.GolFeito;
import gol.GolListado;

import javax.swing.*;
import java.awt.*;

public class InterfaceUser extends JFrame {
    public InterfaceUser() {
        setSize(800, 600);
        setLayout(new BorderLayout());

        GolListado golListado = new GolListado(9, 17);
        GolFeito golFeito = new GolFeito(golListado);
        Menu menu = new Menu(golListado);

        add(golFeito, BorderLayout.CENTER);
        add(menu, BorderLayout.NORTH);

        setVisible(true);
    }



}
