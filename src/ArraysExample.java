import java.util.Arrays;
import java.util.Random;

public class ArraysExample {
    public static void main(String[] args) {
        int [] a = new int[10];
        int [] b = { 23, 123 , 123, 123};

        Random r = new Random();

//        System.out.println(a[4]);
//        a[4] = 123;
//        System.out.println(a[4]);
//        a[4]++;
//        System.out.println(a[4]);
        int value = a[1] + a[3] + a[4];
//        System.out.println(value);

        int [] temperature = new int[365];
        // generate dat a
        for(int i = 0; i < temperature.length; i++) {
            temperature[i] = r.nextInt(40);
        }
        // sum of elements
        int sum = 0;
        for(int i = 0; i < temperature.length; i++) {
            sum += temperature[i];
        }
        System.out.println("sum of elements = " + sum);

        System.out.println((double)sum / (double)temperature.length);

    }
}
