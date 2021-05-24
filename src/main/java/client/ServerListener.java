package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerListener implements Runnable{
    Socket socket;
    BufferedReader in;

    public ServerListener(Socket socket) throws IOException {

        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    @Override
    public void run() {

        while (true) {
            try {
                listener();
            } catch (IOException e) {
                ;
            }
        }

    }

    public void listener() throws IOException {
        String message = in.readLine();
        if (message != null) {
            System.out.println(message);
        }
    }
}
