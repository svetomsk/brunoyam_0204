public class ConcurrencyExample {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        long start = System.currentTimeMillis();
        thread.start();

        System.out.println("here");
        while (true) {
            if (thread.isStarted()) {
                break;
            }
        }
        System.out.println(System.currentTimeMillis() + "!");


    }
}

class MyThread extends Thread {
    private volatile boolean isStarted = false;

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
