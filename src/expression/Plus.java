package expression;

public class Plus extends AbstractBinaryOperation {
    public Plus(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int operation(int a, int b) {
        return a + b;
    }
}
