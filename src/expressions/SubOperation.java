package expressions;

public class SubOperation extends Operation {
    public SubOperation(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int operation(int a, int b) {
        return a - b;
    }
}
