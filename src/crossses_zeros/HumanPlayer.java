package crossses_zeros;

import java.awt.*;
import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, int sign) {
        super(name, sign);
    }

    @Override
    public Point makeTurn(Field field) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        return new Point(x, y);
    }
}
