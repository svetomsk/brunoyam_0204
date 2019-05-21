package expressions;

public class TestExpression {
    public static void main(String[] args) {
        Const two = new Const(2);
        Const four = new Const(4);
        Const five = new Const(5);
        Const six = new Const(6);

        MultOperation multiply = new MultOperation(four, five);
        DivOperation divide = new DivOperation(six, two);
        SubOperation sub = new SubOperation(divide, two);
        PlusOperation plus = new PlusOperation(multiply, sub);

        // x -> 1; y -> 2; z -> 3
        System.out.println(plus.calculate());


    }
}
