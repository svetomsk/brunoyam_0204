package project;

import java.util.Random;

public class Controller {

    private Field own;
    private Field rival;
    private View view;

    Random random = new Random();
    public Controller(Field own, Field rival, View view) {
        this.own = own;
        this.rival = rival;
        this.view = view;
    }

    public void cellClicked(int x, int y) {
        System.out.println("clicked " + x + " " + y);
        int value = rival.getValue(x, y);
        System.out.println(rival.getValue(x, y));
        if (value == Field.HIDDEN_EMPTY) {
            rival.setValue(x, y, Field.MISSED);

        } else if (value == Field.HIDDEN_SHIP) {
            rival.setValue(x, y, Field.CRASHED_SHIP);

        }
        view.updateView();


        x=random.nextInt(9);
        y=random.nextInt(9);


        value = own.getValue(x, y);
        System.out.println(own.getValue(x, y));
        if (value == Field.EMPTY) {
            own.setValue(x, y, Field.MISSED);

        } else if (value == Field.SHIP) {
            own.setValue(x, y, Field.CRASHED_SHIP);
        }

    }


}
