package crosses_zeros;

public class View {
    private Field field;

    public View(Field field) {
        this.field = field;
    }

    public void showField() {
        System.out.println(this.field);
        for(int i = 0; i < field.size(); i++) {
            for(int j = 0; j < field.size(); j++) {
                Cell current = field.getCell(i, j);
                System.out.print(current.getValue());
            }
            System.out.println();
        }
        System.out.println();
    }
}


class Ctrl {
    public static void main(String[] args) {
        play();
    }
    public static void play() {
        Field field = new Field();
        System.out.println(field);
        View view = new View(field);
        view.showField();
        field.setCell(1, 1, Cell.CROSS);
        field.setCell(1, 2, Cell.ZERO);
        view.showField();
    }
}