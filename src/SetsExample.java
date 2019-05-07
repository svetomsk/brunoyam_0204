import java.util.HashSet;
import java.util.Set;

public class SetsExample {
    public static void main(String[] args) {
        Set<Integer> value = new HashSet<>();
        value.add(213);
        value.add(123);
        System.out.println(value.contains(213));
        System.out.println(value.contains(213232));
        for(Integer i : value) {
            System.out.println(i);
        }
    }
}
