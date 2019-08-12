package miner;

public class Field {
    public static final int HIDDEN_EMPTY = 0;
    public static final int HIDDEN_MINE = 1;
    public static final int MINE = 2;
    public static final int EMPTY = 3;

    public static final int DEFAULT_SIZE = 7;
    private int [][] data;

    public Field() {
        data = new int[DEFAULT_SIZE][DEFAULT_SIZE];
    }

    public Field(int size) {

    }

    public int size() {
        return data.length;
    }

    public void setValue(int x, int y, int value) {
        data[x][y] = value;
    }

    public int getValue(int x, int y) {
        return data[x][y];
    }
}
