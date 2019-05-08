import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MapExamples {
    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "buy");
        map.put(3, "world");
        System.out.println(map);
        String oldValue = map.put(1, "sdflkdsjf");
        System.out.println(map);
        System.out.println("old value = " + oldValue);
        map.putIfAbsent(6, "sdflsdfjlsdfjsdklfjsdlfjslf");
        System.out.println(map);

        System.out.println("value for 1 = " + map.get(2312312));
        System.out.println("value for 123123 = " + map.getOrDefault(123123, "not found"));

        Set<Integer> keys = map.keySet();
        Collection<String> values = map.values();
        List<String> strings = new ArrayList<>(values);

        Scanner sc = new Scanner(new File("input.txt"));
        int n = sc.nextInt();
        Map<Integer, Integer> dayToTemperature = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int day = sc.nextInt();
            int temperature = sc.nextInt();
            dayToTemperature.put(day, temperature);
            System.out.println(sc.nextInt() + " " + sc.nextInt());
        }


    }
}
