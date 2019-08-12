package multithreading;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaFunctions {
    static void foo2(int a, String b) {

    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Hello"));
        Consumer<Integer> f1 = System.out::println; // == (x) -> System.out.println(x)
        f1.accept(123);
        BiConsumer<Integer, String> f2 = LambdaFunctions::foo2;
        f2.accept(123, "Svetozar");

        Function<Integer, Integer> fun1 = (x) -> x + 1;
        System.out.println(fun1.apply(14));

        BiFunction<Integer, Integer, Integer> fun2 = (x, y) -> x + y;
        System.out.println(fun2.apply(2, 4));
        thread.start();

        Supplier<Integer> supplier = () -> 1;

        // Stream API
        List<Integer> data = new ArrayList<>();

        for(int i = 0; i < 1000; i++) {
            data.add(1000000 - i);
        }

        List<Integer> data1 = new ArrayList<>(data);

//        System.out.println(data);
        System.out.println("--");
        long start = System.currentTimeMillis();
        data = data.parallelStream()
                .map(x -> (int)Math.cbrt(Math.sqrt(x * x)))
                .filter(x -> x > 25)
                .map(x -> -x)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        data1 = data1.stream()
                .map(x -> (int)Math.cbrt(Math.sqrt(x * x)))
                .filter(x -> x > 25)
                .map(x -> -x)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - start);

        IntStream numbers = IntStream.iterate(1, x -> x + 3);
        numbers.skip(10).limit(10).forEach(System.out::println);
//        System.out.println(data);

    }

    public static void mapper(List<Integer> data, Consumer<Integer> function) {
        for(Integer i : data) {
            function.accept(i);
        }
    }
}
