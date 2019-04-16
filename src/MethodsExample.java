public class MethodsExample {
    public static void main(String[] args) {
        int a = 12;
        int b = 13;
        int result = sum(23, b) + sum(232, a) +
                sum(12312, 12312);

        int k = f(0) + f(1) + f(2);
        System.out.println(result);

        int[] arr = {1, 2, 3};
        System.out.println(appendWorld(arr)[0]);
        System.out.println(arr[0]);

        System.out.println(k);
        System.out.println(f(k));
        System.out.println(k);

        int c = 213;
        int d = 32313;
        System.out.println(sub(c, d));
    }

    public static int sum(int first, int b) {
        return first + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) {
        return a / b;
    }

    public static int calculate(int a, int b) {

        sumOfElems(1, 2, 3, 4, 5, 6, 4);
        return f(a) + f(b);
    }

    public static int sumOfElems(Integer... a) {
        return a[0];
    }

    public static int sumOfElements(int[] a) {
        // элемент, накапливающий сумму
        int sum = 0;
        // цикл для перебора всех элементов массива
        for (int i = 0; i < a.length; i++) {
            // на каждом повторении цикла текущий элемент, с которым
            // мы работаем - это a[i]
            sum += a[i];
        }
        // не забываем про возвращаемое значение
        return sum;
    }

    public static int[] appendWorld(int[] s) {
        s[0] = 123456;
        return s;
    }

    private static int f(int x) {
        return ++x;
    }


    public static String foo() {
        return "hello";
    }
}
