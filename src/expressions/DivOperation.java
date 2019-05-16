package expressions;

public class DivOperation extends Operation {
    public DivOperation(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int operation(int a, int b) {
        return a / b;
    }
}
