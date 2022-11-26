package PartesDaInterface;

import gol.GolListado;
import gol.GolSumario;
import gol.ParteDoGol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu extends JPanel {

    protected JLabel gols;
    protected JLabel traves;
    protected JLabel foras;
    protected JLabel defesas;
    protected int totGols = 0;
    protected int totTraves = 0;
    protected int totForas = 0;
    protected int totDefesas = 0;
    protected ArrayList<ParteDoGol> partesDoGol;

    public Menu(GolListado golListado) {
        this.partesDoGol = golListado.getGol();

        setBackground(Color.black);

        setLayout(new FlowLayout());

        gols = new JLabel("GOLS: 0");
        gols.setForeground(Color.white);
        traves = new JLabel("TRAVES: 0");
        traves.setForeground(Color.white);
        foras = new JLabel("FORAS: 0");
        foras.setForeground(Color.white);
        defesas = new JLabel("DEFESAS: 0");
        defesas.setForeground(Color.white);

        add(gols);
        add(traves);
        add(foras);
        add(defesas);
        add(golListado.getShowBotao());

        adicionarEvento();

    }

    private void adicionarEvento(){
        for (ParteDoGol parteDoGol: partesDoGol){
            parteDoGol.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    parteDoGol.actionPerformed(e);

                    if (parteDoGol.getGolSumario() == GolSumario.GOL){
                        totGols++;
                        gols.setText("GOLS: " + totGols);
                    } else if (parteDoGol.getGolSumario() == GolSumario.TRAVE) {
                        totTraves++;
                        traves.setText("TRAVES: " + totTraves);
                    } else if (parteDoGol.getGolSumario() == GolSumario.FORA) {
                        totForas++;
                        foras.setText("FORAS: " + totForas);
                    } else {
                        totDefesas++;
                        defesas.setText("DEFESAS: " + totDefesas);
                    }
                }
            });
        }
    }
}
