import java.util.Arrays;

public class Complexity {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // O(1)
        // === константное
        int a = 12;
        int b = 1234;
        int c = a + b;

        int n = 100000;
        // ===
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        int [] mas = new int[n];
        //O(n)
        // === линейное время
        for(int i = 0; i < n; i++) {
            mas[i] = i;
        }
        for(int i = 0; i < n; i++) {
            mas[i] = i;
        }
        // ===
        System.out.println(System.currentTimeMillis() - start);


        start = System.currentTimeMillis();
//        int [] mas1 = new int[n];
//        // O(n^2)
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                mas1[(i + j)%10] = i + j;
//            }
//        }
//        System.out.println(System.currentTimeMillis() - start);

        for(int i = 0; i < 30; i++) {
            System.out.println((int)Math.pow(2, i) + " " + i);
        }

        Arrays.sort(mas);
        Arrays.binarySearch(mas, 3);
        Arrays.fill(mas, 1);
    }
}
