package crosses_zeros;

public class Field {
    private final int DEFAULT_SIZE = 3;
    private Cell[][] data;

    public Field() {
        data = new Cell[DEFAULT_SIZE][DEFAULT_SIZE];
        // fill with empty values
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            for (int j = 0; j < DEFAULT_SIZE; j++) {
                data[i][j] = Cell.EMPTY;
            }
        }
    }

    public boolean setCell(int x, int y, Cell value) {
        if (x < 0 || x >= size() || y < 0 || y >= size()) {
            return false;
        }
        if (data[x][y] == Cell.EMPTY) {
            data[x][y] = value;
            return true;
        }
        return false;
    }

    public Cell getCell(int x, int y) {
        return data[x][y];
    }

    public int size() {
        return data.length;
    }
}
