package project;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Field ownField;
    private Field rivalField;
    private Controller controller;
    private final int WIDTH = 840;
    private JPanel own;
    private JPanel rival;
    private JLabel [][] ownLabels;
    private JLabel [][] rivalLabels;

    public View(Field ownField, Field rivalField) {
        this.ownField = ownField;
        this.rivalField = rivalField;
        setLayout(new FlowLayout());
        setSize(WIDTH, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initControlPanel();

        ownLabels = new JLabel[ownField.size()][ownField.size()];
        own = initField(ownLabels, ownField);
        rivalLabels = new JLabel[rivalField.size()][rivalField.size()];
        rival = initField(rivalLabels, rivalField);

        add(own);
        add(rival);

    }

    private void initControlPanel() {
        JPanel control = new JPanel(new FlowLayout());
        control.setBackground(Color.BLUE);
        control.setPreferredSize(new Dimension(WIDTH, 100));
        add(control);
    }

    private JPanel initField(JLabel [][] labels, Field field) {
        JPanel left = new JPanel(new GridLayout(10, 10));
        left.setPreferredSize(new Dimension(400, 400));
        left.setBackground(Color.RED);
        for(int i = 0; i < field.size(); i++) {
            for(int j = 0; j < field.size(); j++) {
                int currentCell = field.getValue(i, j);
                String text = "";
                if(currentCell == Field.EMPTY) {
                    text = "_";
                } else if(currentCell == Field.CRASHED_SHIP) {
                    text = "#";
                }

                JLabel label = new JLabel(text);
                label.setPreferredSize(new Dimension(50, 50));
                left.add(label);
                labels[i][j] = label;
            }
        }
        return left;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void updateView() {

    }
}
