package crosses_zeros;

import java.awt.*;

public class Player {
    protected Field field;
    private Cell sign;

    public Player(Cell sign, Field field) {
        this.sign = sign;
        this.field = field;
    }

    public Cell getSign() {
        return sign;
    }

    public Point makeTurn() {
        return new Point(0, 0);
    }
}
