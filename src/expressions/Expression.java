package expressions;

public interface Expression {
    int calculate();
}


interface MyExpression {
    int calculate();

    int min(int a, int b);

    int max(int a, int b);
}

class AbstactChild implements Expression {
    @Override
    public int calculate() {
        return 0;
    }
}

class InterfaceChild implements MyExpression {

    @Override
    public int calculate() {
        return 0;
    }

    @Override
    public int min(int a, int b) {
        return 0;
    }

    @Override
    public int max(int a, int b) {
        return 0;
    }
}
