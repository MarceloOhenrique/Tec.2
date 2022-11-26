package PartesDaInterface;

import gol.ParteDoGol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowBotao extends JButton implements ActionListener {
    protected ArrayList<ParteDoGol> partesDoGol;

    public ShowBotao(ArrayList<ParteDoGol> partesDoGol) {
        setText("SHOW");

        this.partesDoGol = partesDoGol;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (ParteDoGol parteDoGol: partesDoGol){
            parteDoGol.paintDefenses();
        }
    }
}
