public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");

        // this variable has type integer
        int nameOfVariable = 123;

        int number = 123;
        {
            {
                int b = 123;
            }
            {
                int b = 123;
            }
        }
        long bigNumber = 213132;
        number = (int) bigNumber;
        bigNumber = number;
        /*
        Very
        long
        comment
         */
        System.out.println(number);
        number = 1234;
        System.out.println(number);

        double range = 123.2313123;
        System.out.println(range);
        range = 1223213.2323;
        System.out.println(range);

        char symbol = 'b';


        boolean flag = true;
        boolean anotherFlag = false;
    }
}