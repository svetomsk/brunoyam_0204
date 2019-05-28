package network;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class InputThread extends Thread {
    private Socket connection;
    private volatile boolean isAlive = true;
    private Scanner sc;

    public InputThread(Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            sc = new Scanner(connection.getInputStream());
            while (isAlive) {
                String inputString = sc.nextLine(); // blocking
                if (inputString != null) {
                    System.out.println(inputString);
                } else {
                    System.out.println("Empty string");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopThread() {
        isAlive = false;
        if (sc != null) {
            sc.close();
        }
    }
}
