package server;

import java.net.Socket;

public class ClientThread implements Runnable{
    Socket socket;
    public ClientThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Client Connected: "+ socket.getInetAddress());
    }
}
