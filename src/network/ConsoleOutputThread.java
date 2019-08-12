package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleOutputThread extends Thread {
    private Scanner sc;
    private Socket connection;
    private DataOutputStream out;
    private boolean isRunning = true;


    public ConsoleOutputThread(Socket connection) throws IOException {
        this.connection = connection;
        sc = new Scanner(System.in);
        out = new DataOutputStream(connection.getOutputStream());
    }

    @Override
    public void run() {
        while(isRunning) {
            String input = sc.nextLine();
            if(input.equals("exit")) {
                break;
            }
            try {
                out.writeBytes(input + "\n");
            } catch (IOException e) {
                System.out.println("Error while sending message: " + e.getMessage());
            }
        }
    }

    public void close() {

    }
}
