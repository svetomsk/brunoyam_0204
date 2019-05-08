import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsExample {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        System.out.println("Initial size = " + data.size());
        Random r = new Random();
        int n = 15;
        for (int i = 0; i < n; i++) {
            data.add(r.nextInt(10));
        }
        System.out.println(data);

        int sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum += data.get(i); // data[i]
        }
        System.out.println(sum);

        sum = 0;
        for (Integer element : data) {
            sum += element;
        }

        System.out.println(sum);

        System.out.println(maximum(data));

        data.sort(Integer::compareTo);
        Collections.sort(data);

        Collections.reverse(data);
        Collections.shuffle(data);
        int max = Collections.min(data);
        int min = Collections.max(data);
        System.out.println(min + " " + max);

        Collections.fill(data, -1);
        Collections.swap(data, 0, 1);


    }

    public static boolean contains(int element, List<Integer> data) {
        boolean result = false;
        for (Integer current : data) {
            if (current == element) {
                result = true;
            }
        }
        return result;
    }

    static boolean contains1(int element, List<Integer> data) {
        for (Integer current : data) {
            if (current == element) {
                return true;
            }
        }
        return false;
    }

    public static Integer maximum(List<Integer> data) {
        int maximum = data.get(0);
        for (Integer current : data) {
            if (current > maximum) {
                maximum = current;
            }
        }
        return maximum;
    }
}
