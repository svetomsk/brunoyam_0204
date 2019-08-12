package expression;

public class Mul extends AbstractBinaryOperation {
    public Mul(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int operation(int a, int b) {
        return a * b;
    }
}
