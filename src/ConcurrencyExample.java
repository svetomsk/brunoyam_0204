import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ConcurrencyExample {
    static List<Long> timesCons = new ArrayList<>();
    static List<Long> timesParallel = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        int n = 1400;
        int maxValue = 1400;
        int step = 50;
        for (int value = 50; value <= maxValue; value += step) {
            testMultiplyParallel(value);
        }
        System.out.println(timesCons);
        System.out.println(timesParallel);
    }

    public static void testMultiplyParallel(int n) throws InterruptedException {
//        int n = 50;
        int[][] a = randomMatrix(n);
        int[][] b = randomMatrix(n);
        int[][] c = new int[n][n];

        long time = System.currentTimeMillis();
//        int [][] result = multiply(a, b);
        long diff = System.currentTimeMillis() - time;
        System.out.println("Cons time = " + diff);
        timesCons.add(diff);


        a = randomMatrix(n);
        b = randomMatrix(n);
        long start = System.currentTimeMillis();
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(16, 16, 1000, TimeUnit.MILLISECONDS, queue);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                threadPool.execute(new MyTask(a, b, i, j, c));
            }
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1000, TimeUnit.DAYS);
        diff = System.currentTimeMillis() - start;
        System.out.println("Parallel time = " + diff);
        timesParallel.add(diff);
//        printMatrix(c);
    }

    public static void testMultiplyCons() {
        int n = 50;

        int step = 50;
        int maxSize = 1000;
        for (int value = n; value <= maxSize; value += step) {
            int[][] a = randomMatrix(value);
            int[][] b = randomMatrix(value);
            long start = System.currentTimeMillis();
            int[][] c = multiply(a, b);
            System.out.println("size = " + value + "cons time = " + (System.currentTimeMillis() - start));
        }
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) { // rows of a
            for (int j = 0; j < n; j++) { // columns of b
                int currentResult = 0;
                for (int k = 0; k < n; k++) { // multiply
                    currentResult += a[i][k] * b[k][j];
                }
                result[i][j] = currentResult;
            }
        }

        return result;
    }

    public static int[][] randomMatrix(int n) {
        int[][] result = new int[n][n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = r.nextInt(10);
            }
        }

        return result;
    }

    public static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class MyTask implements Runnable {
        private int[][] a;
        private int[][] b;
        private int[][] c;
        private int row;
        private int column;

        public MyTask(int[][] a, int[][] b, int row, int column, int[][] c) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.row = row;
            this.column = column;
        }

        @Override
        public void run() {
            int currentResult = 0;
            for (int k = 0; k < a.length; k++) { // multiply
                currentResult += a[row][k] * b[k][column];
            }
            c[row][column] = currentResult;
        }
    }
}

enum G {
    A(1.1),
    B(1.4);

    private double value;

    G(double value) {
        this.value = value;
    }

    public double toDouble() {
        return value;
    }
}

class Constants {
    public static final double VALUE_A = 1.1;
    public static final double VALUE_B = 1.4;
}

class MyThread extends Thread {
    private volatile boolean isStarted = false;

    public MyThread() {
        double result = G.A.toDouble() + G.B.toDouble();
        result = Constants.VALUE_A + Constants.VALUE_B;
    }

    public void updateData() {

    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isStarted = true;
        System.out.println(System.currentTimeMillis());
        System.out.println("I'm alive");
    }

    public boolean isStarted() {
        return isStarted;
    }
}
