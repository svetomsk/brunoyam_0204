package crossses_zeros;

import java.util.ArrayList;
import java.util.List;


public class Field {
    public static final int EMPTY = 0;
    public static final int CROSS = 1;
    public static final int ZERO = 2;
    public static final int DEFAULT_SIZE = 3;
    // поле
    private List<List<Integer>> data;

    public Field() {
        this(DEFAULT_SIZE);
    }

    public Field(int size) {
        data = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(EMPTY);
            }
            data.add(row);
        }
    }

    public int get(int x, int y) {
        return data.get(x).get(y);
//        return data[x][y];
    }

    public boolean set(int x, int y, int value) {
        // data[x][y] = value;
        if (get(x, y) == EMPTY) {
            data.get(x).set(y, value);
            return true;
        }
        return false;
    }

    public int size() {
        return data.size();
    }

    @Override
    public String toString() {
        String result = "";
        for(List<Integer> row : data) {
            for(int item : row) {
                result += item;
            }
        }
        return result;
    }

    public boolean checkField() {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            if (get(i, 0) == get(i, 1) && get(i, 1) == get(i, 2) &&
                    get(i, 2) != EMPTY) {
                return true;
            }
            if(get(0, i) == get(1, i) && get(1, i) == get(2, i) &&
                    get(2, i) != EMPTY) {
                return true;
            }
        }

        if(get(0, 0) == get(1, 1) && get(1,1) == get(2, 2) &&
                get(2, 2) != EMPTY) {
            return true;
        }

        if(get(0, 2) == get(1, 1) && get(1, 1) == get(2, 0) &&
                get(2, 0) != EMPTY) {
            return true;
        }

        return false;
    }
}
