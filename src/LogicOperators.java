public class LogicOperators {
    public static void main(String[] args) {

        int [] aa = new int[100];
        System.out.println(aa);


        String one = "123";
        String two = "123";
        if(one.equals(two)) {
            System.out.println("Strings are equal");
        }



        int a = 123;
        int b = 123;
        int c = 232;
        if(c > a && c > b && c != a || c < 123) {
            System.out.println("C is maximum");
        }
        if(c > a && c > b ) {
            if(c != a || c < 123) {
                System.out.println("C is maximum");
            }
        }
//        if(a > b) {
//            System.out.println("a > b");
//        } else if(a < b) {
//            System.out.println("a < b");
//        } else {
//            System.out.println("a == b");
//        }
//
//        if(a == b) {
//            System.out.println("equal");
//        }

        int value = -2; // 0..5
        switch (value) {
            case -1: {}
            case -2: {}
            case 0: {
                System.out.println(0);
                break;
            }
            case 1: {
                System.out.println(1);
                break;
            }
            case 2: {
                System.out.println(2);
                break;
            }
        }



    }
}
