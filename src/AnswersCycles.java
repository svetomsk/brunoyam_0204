import java.util.Scanner;

public class AnswersCycles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // sum on numbers
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 0; i <= n; i++) {
            sum += i;
        }
        // 0 + 0 + 1 + 2 + 3 + 4..
        System.out.println("sum of numbers = " + sum);

        // factorial
        n = sc.nextInt();
        int fact = 1;
        for(int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.println("fact = " + fact);

        // n^k
        n = sc.nextInt();
        int k = sc.nextInt();
        int pow = 1;
        for(int i = 0; i <= k; i++) {
            pow *= n;
        }
        System.out.println("pow = " + pow);

        // sum of digits
        n = sc.nextInt();
        int sumOfDigits = 0;
        while(n > 0) {
            sumOfDigits += n%10;
            n /= 10;
        }
        System.out.println("sum of digits = " + sumOfDigits);

        // very long number div by 3
        String input = sc.nextLine();
        sum = 0;
        for(int i = 0; i < input.length(); i++) {
            sum += input.charAt(i) - '0';
        }
        if(sum % 3 == 0) {
            System.out.println("div by 3");
        } else {
            System.out.println("not div by 3");
        }

        //palindrom
        input = sc.nextLine();
        boolean isPalindrom = true;
        for(int i = 0; i < input.length() / 2; i++) {
            if(input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrom = false;
                break;
            }
        }
        if(isPalindrom) {
            System.out.println("Palindrom");
        } else {
            System.out.println("ne palindrom");
        }

    }
}
