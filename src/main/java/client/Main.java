package client;

import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    static int PORT = 9999;
    static String ipAddress = "localhost";
    static Scanner userIn = new Scanner(System.in);
    static JSONObject userData;

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket(ipAddress, PORT);


        PrintStream out = new PrintStream(socket.getOutputStream());

        userData = userData(socket);
        out.println(userData);

        while(true){
            String command = prompt("Command thee");
            serverSend(command,out,userData);

        }



    }

    public static JSONObject userData(Socket socket) throws IOException, InterruptedException {
        String username = prompt("What's your username? ");
        Runnable r = new ServerListener(socket);
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(2);
        String robot = prompt("Robot type: ");
        JSONObject obj = new JSONObject();

        obj.put("username", username);
        obj.put("robotType", robot);
//        obj.put("command", "launch");

        return obj;
    }

    public static void serverSend(String command,PrintStream out, JSONObject user) throws IOException, InterruptedException {
        JSONObject test = user;
        test.put("command",command);

        out.println(test);
    }






















    public static String prompt(String prompt){
        System.out.println(prompt);
        return userIn.nextLine();
    }
}
