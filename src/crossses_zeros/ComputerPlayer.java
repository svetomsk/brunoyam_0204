package crossses_zeros;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Random;

public class ComputerPlayer extends Player{
    public ComputerPlayer(String name, int sign) {
        super(name, sign);
    }

    @Override
    public Point makeTurn(Field field) {
        Random r = new Random();
        int x = r.nextInt(field.size());
        int y = r.nextInt(field.size());
        return new Point(x, y);
    }
}
