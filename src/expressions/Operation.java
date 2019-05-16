package expressions;

public abstract class Operation implements Expression {
    private Expression left;
    private Expression right;

    public Operation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int calculate() {
        return operation(left.calculate(), right.calculate());
    }

    public abstract int operation(int a, int b);
}
