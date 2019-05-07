import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ExceptionExample {
    public static void main(String[] args) {
//        String [] strs = new String[10];
//        System.out.println(strs[0].length());
        System.out.println(fact(-5));

    }

    static class BadMoodException extends RuntimeException {

    }

    static int fact(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        if(n == 0) {
            return 1;
        }
        List<List<Integer>> arr;
        return n * fact(n -1);
    }

    public static void NPEGenerator() {
        int r = new Random().nextInt();
        if(r % 2 == 0) {
            throw new BadMoodException();
        }
//        throw new IllegalArgumentException();
//        String [] arr = new String[10];
//        System.out.println(arr[0].length());
    }

    public static void readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input123123.txt"));
        int n = sc.nextInt();
        System.out.println("Entered number = " + n);
    }
}
