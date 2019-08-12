import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) throws FileNotFoundException {
        int n = 100;
        Random r = new Random();
        List<Integer> data = new ArrayList<>();
//        for(int i = 0; i < n; i++) {
//            data.add(r.nextInt());
//        }

//        List<Integer> list = new LinkedList<>();
//        for(int i = 0; i < n; i++) {
//            list.add(r.nextInt());
//        }

//        long start = System.currentTimeMillis();
//        int sum = 0;
        for(int i = 0; i < n; i++) {
            data.add(i);
        }
//        System.out.println("time = " + (System.currentTimeMillis() - start));
//
//        start = System.currentTimeMillis();
//        sum = 0;
//
//        for(int i = 0; i < n; i++) {
//            list.add(0, r.nextInt());
//        }
//        System.out.println("time = " + (System.currentTimeMillis() - start));

        System.out.println("Elements added");
        Set<Integer> hashSet = new HashSet<>();
        long start = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            hashSet.add(data.get(i));
        }
        System.out.println("time = " + (System.currentTimeMillis() - start));

        Set<Integer> treeSet = new TreeSet<>();
        start = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            treeSet.add(data.get(i));
        }
        System.out.println("time = " + (System.currentTimeMillis() - start));

        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(123, "123");
        System.out.println(hashMap.get(123));
        hashMap.put(123, "1234");
        System.out.println(hashMap.get(123));
        System.out.println(hashMap.getOrDefault(12345 ,"default"));
        System.out.println(hashMap.putIfAbsent(123, "1231231"));
        System.out.println(hashMap.get(123));

        Set<Integer> keys = hashMap.keySet();
        Collection<String> values = hashMap.values();








        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(2);

        Set<Integer> set = new HashSet<>(a);
        System.out.println(set);

        List<Integer> result = new ArrayList<>(set);


        System.out.println(a.get(2)); // a[2]
        a.set(2, 10); // a[2] = 10;

        for(int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i)); // a[i]
            if(a.get(i) > 0) {
                System.out.println("Yes");
//                a[i] = -a[i];
                a.set(i, -a.get(i));
            }
        }

        for(int i : a) {
            System.out.println(i);
        }

        Scanner sc = new Scanner(new File("input.txt"));
        sc.nextInt();
        sc.nextLine();
        sc.next();
//        List<Integer> b = new ArrayList<>();
//        b.addAll(a);
//        b.add(3);
//        System.out.println(b);

    }
}
