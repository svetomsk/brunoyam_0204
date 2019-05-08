import java.util.*;

public class TimeComplexityLists {
    public static void main(String[] args) {
        testSetVsList();
    }

    public static void testSetVsList() {
        List<Integer> data = new ArrayList<>();
        int n = 10000000;
        for (int i = 0; i < n; i++) {
            data.add(i * 123);
        }

        int k = 1000;
        Random r = new Random();
        List<Integer> list = new ArrayList<>(data);
        long start = System.currentTimeMillis();
//        for(int i = 0; i < k; i++) {
//            int element = r.nextInt(data.size());
//            boolean result = list.contains(element);
//        }
        System.out.println("list contains time = " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        Set<Integer> set = new HashSet<>(data);
        for (int i = 0; i < k; i++) {
            int element = r.nextInt(data.size());
            boolean result = set.contains(element);
        }
        System.out.println("set contains time = " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        Set<Integer> treeSet = new TreeSet<>(data);
        for (int i = 0; i < k; i++) {
            int element = r.nextInt(data.size());
            boolean result = treeSet.contains(element);
        }
        System.out.println("treeSet contains time = " + (System.currentTimeMillis() - start));

    }

    public static void testLists() {
        List<Integer> data = new ArrayList<>();
        int n = 1000000;
        for (int i = 0; i < n; i++) {
            data.add(i * 4);
        }

        List<Integer> array = new ArrayList<>(data);
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array.remove(0);
        }
        System.out.println("ArrayList time = " + (System.currentTimeMillis() - start));

        Long a;
        List<Integer> linkedList = new LinkedList<>(data);
        start = System.currentTimeMillis();
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += linkedList.remove(0);
        }
        System.out.println("LinkedList time = " + (System.currentTimeMillis() - start));

        List<Integer> anotherList = new LinkedList<>(data);
        start = System.currentTimeMillis();
        sum = 0;
        for (Integer i : anotherList) {
            sum += i;
        }
        System.out.println("For each LinkedList time = " + (System.currentTimeMillis() - start));
    }
}
