package miner;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Field field;
    private Controller controller;
    private JButton [][] cells;

    public View(Field field) {
        this.field = field;
        cells = new JButton[field.size()][field.size()];

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(field.size(), field.size()));

        initCells();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void updateView() {
        updateField();
    }

    private void initCells() {
        for(int i = 0; i < field.size(); i++) {
            for(int j = 0; j < field.size(); j++) {
                cells[i][j] = new JButton();
                int finalI = i;
                int finalJ = j;
                cells[i][j].addActionListener(e -> controller.buttonClicked(finalI, finalJ));
                add(cells[i][j]);
            }
        }
    }

    public void updateStatus(String status) {
        setTitle(status);
    }

    private void updateField() {
        for(int i = 0; i < field.size(); i++) {
            for (int j = 0; j < field.size(); j++) {
                int value = field.getValue(i, j);
                if (value == Field.MINE) {
                    cells[i][j].setText("**");
                } else if (value == Field.EMPTY) {
                    cells[i][j].setText("--");
                } else {
                    cells[i][j].setText("@@");
                }
            }
        }
    }
}
