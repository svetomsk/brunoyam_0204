package expression;

import java.util.Map;

public interface Expression {
    int calculate(Map<String, Integer> variables);
}
