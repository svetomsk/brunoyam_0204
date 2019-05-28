package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class OutputThread extends Thread {
    private Socket connection;
    private volatile boolean isAlive = true;
    private Scanner sc;
    private DataOutputStream writer;

    public OutputThread(Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        sc = new Scanner(System.in);
        try {
            writer = new DataOutputStream(connection.getOutputStream());
            while (isAlive) {
                String inputString = sc.nextLine();
                writer.writeBytes(inputString + "\n");
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
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
