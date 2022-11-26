package gol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ParteDoGol extends JButton implements ActionListener {
    protected GolSumario golSumario;
    protected int linha;
    protected int coluna;

    public ParteDoGol(GolSumario golSumario, int linha, int coluna) {
        this.golSumario = golSumario;
        this.linha = linha;
        this.coluna = coluna;
        paint();

        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imagens/bolaIcone.png"))));
    }

    private void paint(){
        if (golSumario != GolSumario.AREA_DE_DEFESA)
            setBackground(golSumario.getColor());
        else
            setBackground(GolSumario.GOL.getColor());
    }
    public void paintDefenses(){
        if (golSumario == GolSumario.AREA_DE_DEFESA)
            setBackground(golSumario.getColor());
    }

    public GolSumario getGolSumario() {
        return golSumario;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
}
