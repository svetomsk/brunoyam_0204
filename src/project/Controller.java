package project;

public class Controller {
    private Field own;
    private Field rival;
    private View view;

    public Controller(Field own, Field rival, View view) {
        this.own = own;
        this.rival = rival;
        this.view = view;
    }

    public void cellClicked(int x, int y) {
        /*
        here some code to change field
         */
        view.updateView();
    }
}
