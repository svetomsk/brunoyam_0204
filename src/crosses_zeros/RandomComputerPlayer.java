package crosses_zeros;

import java.awt.*;
import java.util.Random;

public class RandomComputerPlayer extends Player {
    public RandomComputerPlayer(Cell sign, Field field) {
        super(sign, field);
    }

    @Override
    public Point makeTurn() {
        Random r = new Random();
        return new Point(r.nextInt(field.size()), r.nextInt(field.size()));
    }
}
