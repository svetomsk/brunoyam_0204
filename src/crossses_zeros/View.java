package crossses_zeros;

public class View {
    private Field field;

    public View(Field field) {
        this.field = field;
    }

    public void displayField() {
        for(int i = 0; i < field.size(); i++) {
            for(int j = 0; j < field.size(); j++) {
                switch (field.get(i, j)) {
                    case Field.EMPTY: {
                        System.out.print("_ ");
                        break;
                    }
                    case Field.CROSS: {
                        System.out.print("X ");
                        break;
                    }
                    case Field.ZERO: {
                        System.out.print("0 ");
                        break;
                    }
                }
            }
            System.out.println();
        }
    }
}
