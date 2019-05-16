package expressions;

public class MultOperation extends Operation {

    public MultOperation(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int operation(int a, int b) {
        return a * b;
    }
}
