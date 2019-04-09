public class CyclesExample {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + " " + j);
            }
        }

        int j = 0;
        for (; j < n; ) {
            System.out.println(j);
            j++;
        }

        int i = 0;
        while (i < n) {
            System.out.println(i);
            i++;
        }

        i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i > n);

        int k = 12;
        k = k + 123;
        k += 123; // k = k + 123;
    }
}
