package client;

import java.io.IOException;
import java.net.Socket;

public class Main {
    static int PORT = 9999;
    static String ipAddress = "localhost";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(ipAddress,PORT);
    }
}
