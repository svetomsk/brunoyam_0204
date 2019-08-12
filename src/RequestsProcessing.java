import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RequestsProcessing {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int n = sc.nextInt();
        System.out.println(n);
        for(int i = 0; i < n; i++) {
            int month = sc.nextInt();
            int temperature = sc.nextInt();
            System.out.println("For month " + month + " average temp = " + temperature);
        }

        int m = sc.nextInt();
        System.out.println(m);
        for(int i = 0; i < m; i++) {
            int request = sc.nextInt();
            System.out.println("Request = " + request);
        }
    }
}
