public class Field {
    public static final int EMPTY = 0;
    public static final int TRACE = 1;
    public static final int ROBOT = 2;

    private static final int DEFAULT_SIZE = 3;

    private int [][] data;
    private Robott robott;

    public Field() {
        this(DEFAULT_SIZE, DEFAULT_SIZE, new Robott(0, 0));
    }

    public Field(Robott r) {
        this(DEFAULT_SIZE, DEFAULT_SIZE, r);
    }

    public Field(int width, int height, Robott r) {
        data = new int[width][height];
        robott = r;
        clearField();
        data[robott.getX()][robott.getY()] = ROBOT;
    }

    private void clearField() {
        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[0].length; j++) {
                data[i][j] = EMPTY;
            }
        }
    }

    public void display() {
        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[0].length; j++) {
                switch (data[i][j]) {
                    case EMPTY: {
                        System.out.print("_");
                        break;
                    }
                    case TRACE: {
                        System.out.print(robott.getTrace());
                        break;
                    }
                    case ROBOT: {
                        System.out.print("*");
                        break;
                    }
                }
            }
            System.out.println();
        }
    }


}
