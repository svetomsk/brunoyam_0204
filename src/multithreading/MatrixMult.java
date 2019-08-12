package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class MatrixMult {
    public static void main(String[] args) throws InterruptedException {
        int n = 1500;
        int[][] a = {   {1, 2},
                        {3, 4}
        };
        int[][] b = {   {5, 6},
                        {7, 8}
        };

        a = randomMatrix(n);
        b = randomMatrix(n);

//        multiplyParallel(a, b);

        long start = System.currentTimeMillis();
        int [][] parallelResult = multiplyParallel(a, b);
        long parallelTime =System.currentTimeMillis() - start;
        System.out.println("Parallel " + parallelTime);

        start = System.currentTimeMillis();
        int [][] result = multiply(a, b);
        long time = System.currentTimeMillis() - start;
        System.out.println("Consequently " + time);

        start = System.currentTimeMillis();
        int [][] threadResult = multiply(a, b);
        time = System.currentTimeMillis() - start;
        System.out.println("Threads " + time);


        System.out.println("Speed up = " + (1.0 - (double) 1 / (double) time));
    }

    public static int [][] randomMatrix(int n) {
        int [][] result = new int[n][n];
        Random r = new Random();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = r.nextInt();
            }
        }
        return result;
    }

    public static int [][] multiplyThreads(int [][] a, int [][] b) throws InterruptedException {
        int n = a.length;
        int [][] result = new int[n][n];
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Thread thread = new Thread(new Task(result, a, b, i, j));
                thread.start();
                threads.add(thread);
            }
        }

        for(Thread t : threads) {
            t.join();
        }
        return result;
    }

    public static int [][] multiplyParallel(int [][] a, int [][] b) throws InterruptedException {
        int coreThreads = 16;
        int maxThreads = 16;
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(coreThreads, maxThreads, 1, TimeUnit.MINUTES, queue);
        int [][] result = new int[a.length][a.length];
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                pool.execute(new Task(result, a, b, i, j));
            }
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);

        return result;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) { // rows from A
            for (int j = 0; j < n; j++) { // column from B
                int sum = 0;
                for (int k = 0; k < n; k++) { // multiply row by column
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
