package project;

import java.util.List;

public class Field implements IField {
    public static final int EMPTY = 0;
    public static final int HIDDEN_EMPTY = 1;
    public static final int MISSED = 2;
    public static final int SHIP = 3;
    public static final int HIDDEN_SHIP = 4;
    public static final int CRASHED_SHIP = 5;

    private int [][] data;

    public Field(String file) {

    }

    public Field(List<Ship> ships) {

    }

    @Override
    public void setValue(int x, int y, int value) {

    }

    @Override
    public int getValue(int x, int y) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isAllCrashed() {
        return false;
    }
}
