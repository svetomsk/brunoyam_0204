package expression;

public class Div extends AbstractBinaryOperation {
    public Div(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int operation(int a, int b) {
        return a - b;
    }

    @Override
    public String toString() {
        return left.toString() + " / " + right.toString();
    }
}
