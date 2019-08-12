package miner;

public class Controller {
    private View view;
    private Field field;
    int count = 0;
    public Controller(Field field, View view) {
        this.field = field;
        this.view = view;
    }

    public void buttonClicked(int i, int j) {
        System.out.println("clicked " + i + " " + j);
        int value = field.getValue(i, j);
        System.out.println(field.getValue(i, j));
        if(value == Field.HIDDEN_EMPTY) {
            field.setValue(i, j, Field.EMPTY);
            view.updateStatus("Total score: " + ++count);
        } else if(value == Field.HIDDEN_MINE) {
            field.setValue(i, j, Field.MINE);
            view.updateStatus("You lose");
        }
        view.updateView();
    }
}
