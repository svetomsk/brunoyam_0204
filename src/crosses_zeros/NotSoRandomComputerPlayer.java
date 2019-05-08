package crosses_zeros;

import java.awt.*;

public class NotSoRandomComputerPlayer extends Player {
    public NotSoRandomComputerPlayer(Cell sign, Field field) {
        super(sign, field);
    }

    @Override
    public Point makeTurn() {
        for (int i = 0; i < field.size(); i++) {
            for (int j = 0; j < field.size(); j++) {
                if (field.getCell(i, j) == Cell.EMPTY) {
                    return new Point(i, j);
                }
            }
        }
        return new Point(0, 0);
    }
}
