package network;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class InputThread extends Thread {
    private Scanner sc;
    private Socket connection;
    private boolean isRunning = true;

    public InputThread(Socket connection) throws IOException {
        this.connection = connection;
        sc = new Scanner(connection.getInputStream());
    }

    @Override
    public void run() {
        while(isRunning) {
            String input = sc.nextLine();
            System.out.println("Received: " + input);
            if(input.equals("exit")) {
                break;
            }
        }
    }

    public void close() {

    }
}
