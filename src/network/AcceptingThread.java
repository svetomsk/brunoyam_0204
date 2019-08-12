package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class AcceptingThread extends Thread {
    private ServerSocket server;
    List<Socket> connections;

    public AcceptingThread(ServerSocket server) {
        this.server = server;
        connections = new ArrayList<>();
    }

    @Override
    public void run() {
        while(true) {
            try {
                Socket connection = server.accept();
                InputThread inputThread = new InputThread(connection);
                ConsoleOutputThread consoleThread = new ConsoleOutputThread(connection);
                inputThread.start();
                consoleThread.start();

                connections.add(connection);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // ivan hello
    // petr hello
    // ivan how are you
    // pert i'm fine

    public void closeThread() throws IOException {
        server.close();
    }
}
