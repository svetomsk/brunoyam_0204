package expression;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> values = new HashMap<>();
        values.put("x", 15);
        values.put("y", 2);

        Expression two = new Const(2);
        System.out.println(two.calculate(values));

        Div plus = new Div(two, two);
        System.out.println(plus.calculate(values));
        System.out.println(plus);

        Expression x = new Var("x");
        Expression x2 = new Mul(x, x);

        Expression xPlusX2 = new Plus(x, x2);
        Expression plusOne = new Plus(xPlusX2, new Const(1)); // x^2 + x + 1

        int max = -100000;
        for(int i = -1000; i < 1000; i++){
            values.put("x", i);
            max = Math.max(max, plusOne.calculate(values));
        }

        System.out.println(max);
    }
}
