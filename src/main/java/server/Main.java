package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int PORT = 9999;
        ServerSocket socket = new ServerSocket(PORT);
        while (true) {
            acceptClient(socket);
        }

    }
    public static void acceptClient(ServerSocket socket) throws IOException {
        Socket clientSocket = socket.accept();
        Runnable r = new ClientThread(clientSocket);
        Thread thread = new Thread(r);
        thread.start();

    }
}
