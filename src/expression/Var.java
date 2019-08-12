package expression;

import java.util.Map;

public class Var implements Expression {
    private String name;

    public Var(String name) {
        this.name = name;
    }

    @Override
    public int calculate(Map<String, Integer> variables) {
        return variables.get(name);
    }
}
