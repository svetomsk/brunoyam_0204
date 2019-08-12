package expression;

public class Minus extends AbstractBinaryOperation{
    private Expression left;
    private Expression right;

    public Minus(Expression left, Expression right) {
        super(left, right);
    }


    @Override
    public int operation(int a, int b) {
        return a - b;
    }
}
