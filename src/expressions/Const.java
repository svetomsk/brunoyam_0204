package expressions;

public class Const implements Expression {

    private int value;

    public Const(int value) {
        this.value = value;
    }

    @Override
    public int calculate() {
        System.out.println("Enter const");
        System.out.println("Exit const");
        return value;
    }
}
