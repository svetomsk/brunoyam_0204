package miner;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        field.setValue(1, 1, Field.HIDDEN_MINE);
        field.setValue(1, 2, Field.HIDDEN_EMPTY);
        View view = new View(field);
        view.updateView();
        Controller controller = new Controller(field, view);
        view.setController(controller);
        view.setVisible(true);
    }
}
