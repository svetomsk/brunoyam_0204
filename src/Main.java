import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount of elements: ");
        int n = sc.nextInt();
        int [] mas = new int[n];

        for(int i = 0; i < n; i++) {
            int current = sc.nextInt();
            mas[i] = current;
        }

        for(int i = 0; i < n; i++) {
            System.out.println(mas[i]);
        }

        for(int i = n - 1; i >= 0; i--) {
            System.out.println(mas[i]);
        }

        int max = mas[0];
        int min = mas[0];
        for(int i = 0; i < n; i++) {
            if(max < mas[i]) {
                max = mas[i];
            }
            if(min > mas[i]) {
                min = mas[i];
            }
        }
        System.out.println(max + " " + min);
    }
}
