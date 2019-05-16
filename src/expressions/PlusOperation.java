package expressions;

public class PlusOperation extends Operation {

    public PlusOperation(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int operation(int a, int b) {
        return a + b;
    }
}
