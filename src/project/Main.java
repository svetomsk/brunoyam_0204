package project;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ship first = new Ship(4, 4, 2, true);
        Ship second = new Ship(2, 2, 2, false);
        List<Ship> ships = new ArrayList<>();
        ships.add(first);
        ships.add(second);
        Field own = new Field(ships);
        own.setValue(1, 1, 1);
        own.setValue(1, 1, Field.CRASHED_SHIP);
        Field rival = new Field(new ArrayList<>());
        View view = new View(own, rival);
        Controller ctrl = new Controller(own, rival, view);

        view.setVisible(true);
    }
}
