package multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ThreadsExample {
    public static void main(String[] args) throws InterruptedException, IOException {
        Runnable function = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000000; i++) {
                    System.out.println("thread1");
                }
            }
        };
        Runnable secondFunction = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000000; i++) {
                    System.out.println("thread2");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(function);
//        thread.start();
//        Thread thread2 = new Thread(secondFunction);
//        thread2.start();
//        System.out.println("Thread started");
//        thread.join();
//        thread2.join();
//        System.out.println("Main thread finished");

        MyThread printingThread = new MyThread(100, 2000000);
        printingThread.start();
        printingThread.join();

        EchoThread echoThread = new EchoThread();
        echoThread.start();
        echoThread.join();
    }
}

class EchoThread extends Thread {
    private boolean isRunning = true;
    private BufferedReader sc;

    @Override
    public void run() {
        sc = new BufferedReader(new InputStreamReader(System.in));
        while(isRunning) {
            String input = "";
            try {
                input = sc.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(input.equals("exit")) {
                break;
            }
            System.out.println(input);
        }

        System.out.println("Thread finished");
    }

    public void stopThread() throws IOException {
        isRunning = false;
        System.out.println("Closing");
        sc.close();
        System.out.println("Closed");
    }
}

class MyThread extends Thread {
    private int a;
    private int b;
    public MyThread(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        for(int i = a; i <= b; i++) {
            System.out.println(i);
        }
    }
}