package crosses_zeros;

import java.awt.*;

public class Controller {
    public void play() {
        Field field = new Field();
        View view = new View(field);
        Player crosses = new RandomComputerPlayer(Cell.CROSS, field);
        Player zeros = new NotSoRandomComputerPlayer(Cell.ZERO, field);

        // who's turn !
        // print field !
        // makeTurn of current player !
        // try to set value
        // success -> check field  | fail -> makeTurn
        // change player

        Player currentPlayer = crosses;

        while (true) {
            view.showField();
            System.out.println("Ходят " + currentPlayer.getSign().getValue());
            Point coords = currentPlayer.makeTurn();
            if (field.setCell(coords.x, coords.y, currentPlayer.getSign())) {
                // success check field
                boolean checkField = checkField(field);
                if (checkField) {
                    System.out.println(currentPlayer.getSign().getValue() + " победил");
                    break;
                } else {
                    // change players
                    if (currentPlayer.getSign() == Cell.CROSS) {
                        currentPlayer = zeros;
                    } else {
                        currentPlayer = crosses;
                    }
                }
            } else {
                // fail
                System.out.println("Попробуй снова");
                continue;
            }
        }

        view.showField();

    }

    public boolean checkField(Field field) {
        for (int i = 0; i < field.size(); i++) {
            if (field.getCell(i, 0) == field.getCell(i, 1) && field.getCell(i, 1) == field.getCell(i, 2) && field.getCell(i, 2) != Cell.EMPTY) {
                return true;
            }
            if (field.getCell(0, i) == field.getCell(1, i) && field.getCell(1, i) == field.getCell(2, i) && field.getCell(2, i) != Cell.EMPTY) {
                return true;
            }
        }

        if (field.getCell(0, 0) == field.getCell(1, 1) && field.getCell(1, 1) == field.getCell(2, 2) && field.getCell(2, 2) != Cell.EMPTY) {
            return true;
        }

        if (field.getCell(0, 2) == field.getCell(1, 1) && field.getCell(1, 1) == field.getCell(2, 0) && field.getCell(2, 0) != Cell.EMPTY) {
            return true;
        }
        return false;
    }
}
