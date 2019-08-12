package project;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Field own = new Field(new ArrayList<>());
        Field rival = new Field(new ArrayList<>());
        View view = new View(own, rival);
        Controller ctrl = new Controller(own, rival, view);

        view.setVisible(true);
    }
}
