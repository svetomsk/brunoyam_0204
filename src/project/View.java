package project;

import javax.swing.*;

public class View extends JFrame {
    private Field ownField;
    private Field rivalField;
    private Controller controller;
    int [][] f;
    public View(Field ownField, Field rivalField) {
        this.ownField = ownField;
        this.rivalField = rivalField;
        setSize(500, 500);

        controller.cellClicked(1, 2);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void updateView() {

    }
}
