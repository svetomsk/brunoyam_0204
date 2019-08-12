package expression;

import java.util.Map;

public abstract class AbstractBinaryOperation implements Expression {
    protected Expression left;
    protected Expression right;

    public AbstractBinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public abstract int operation(int a, int b);

    @Override
    public int calculate(Map<String, Integer> variables) {
        return operation(left.calculate(variables), right.calculate(variables));
    }
}
