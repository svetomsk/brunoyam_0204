package crosses_zeros;

public class View {
    private Field field;

    public View(Field field) {
        this.field = field;
    }

    public void showField() {
        for (int i = 0; i < field.size(); i++) {
            for (int j = 0; j < field.size(); j++) {
                Cell current = field.getCell(i, j);
                System.out.print(current.getValue());
            }
            System.out.println();
        }
        System.out.println();
    }
}
