public class RecursionExample {
    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        System.out.println(fib(1, 1, 4));
        // 1 1 2 3 5 8
        // 1 1 2 3 5 8
    }

    public static int fib(int a, int b, int k) {
        if(k == 0) {
            return b;
        }
        return fib(b, a + b, k - 1);
    }

    public static int sum(int n) {
        System.out.println("Enter with n = " + n);
        if(n == 1) {
            System.out.println("Exit with n = " + n);
            return 1;
        }
        int result = n + sum(n - 1);
        System.out.println("Exit with n = " + n);
        return result;
    }
}
