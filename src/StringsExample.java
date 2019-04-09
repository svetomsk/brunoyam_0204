import java.util.Scanner;

public class StringsExample {
    public static void main(String[] args) {
        String name = "Ivan";
        String welcome = "Welcome ";
        String fullWelcome = welcome + name;
        System.out.println(welcome + name);
        System.out.println(fullWelcome);

        char symbol = welcome.charAt(0);
        System.out.println(symbol);

        String substring = welcome.substring(2, 4);
        System.out.println(substring);

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(input);
        String firstWord = sc.next();
        int nextNumber = sc.nextInt();
        System.out.println(firstWord + " " + nextNumber);
    }
}
