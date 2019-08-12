package project;

import java.util.List;

public class Field implements IField {
    public static final int EMPTY = 0;
    public static final int HIDDEN_EMPTY = 1;
    public static final int MISSED = 2;
    public static final int SHIP = 3;
    public static final int HIDDEN_SHIP = 4;
    public static final int CRASHED_SHIP = 5;

    private int[][] data;

    public Field(String file) {

    }

    public Field(List<Ship> ships) {
        data = new int[10][10];
        for(int i = 0; i < size(); i++) {
            for(int j = 0; j < size(); j++) {
                data[i][j] = EMPTY;
            }
        }
        if (!checkShips(ships)) {
            throw new IllegalArgumentException("Incorrect ships position");
        }
    }

    private boolean IncorrectRange(int x, int y) {
        return x <= 0 || x > 10 || y <= 0 || y > 10;
    }

    private boolean checkShips(List<Ship> ships) {
        for (Ship ship : ships) {
            int x = ship.getX();
            int y = ship.getY();
            if (ship.isHorizontal()) {
                for (int i = 0; i < ship.getSize(); i++) {
                    if (IncorrectRange(x, y + i) || data[x][y + i] != EMPTY) {
                        return false;
                    }
                    data[x][y + i] = SHIP;
                }
            } else {
                for (int i = 0; i < ship.getSize(); i++) {
                    if (IncorrectRange(x + i, y) || data[x + i][y] != EMPTY) {
                        return false;
                    }
                    data[x + i][y] = SHIP;
                }
            }
        }
        return true;
    }

    @Override
    public void setValue(int x, int y, int value) {
        data[x][y] = value;
    }

    @Override
    public int getValue(int x, int y) {
        return data[x][y];
    }

    @Override
    public int size() {
        return 10;
    }

    @Override
    public boolean isAllCrashed() {
        return false;
    }
}
