package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;

import org.json.*;
import server.Position.Position;
import server.RobotTypes.RobotTypes;

public class ClientThread implements Runnable{
    Socket socket;
    static BufferedReader in;
    static PrintStream out;
    RobotTypes robotType = null;


    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintStream(socket.getOutputStream());

    }

    @Override
    public void run() {
        Random randint = new Random();
        System.out.println("Client Connected: "+ socket.getInetAddress());
        listOfRobots();


//        CommandHandler commandHandler = new CommandHandler();

        String command = null;

        Robot robot = new Robot();
        while (true){
            try {
                command = in.readLine();
                if ( command != null) {
                    JSONObject message = new JSONObject(command);

                    if (robotType == null) {
                        Position position = new Position(randint.nextInt(200),randint.nextInt(200));
                        String robotCandidate = (String) message.get("robotType");

                        try {

                            robotType = robot.validateRobot(robotCandidate);
                            out.println("Class selected: "+robotType);
                            message.put("positionX",position.getX());
                            message.put("positionY",position.getY());
                            out.println(message);

                        }catch (IllegalArgumentException e){
                             out.println("invalid Robot "+"'" +robotCandidate + "'");
                             out.println("Enter valid robot: ");
                            robotType = null;
                        }

                    }
                    else {
                        CommandHandler.command(message, robotType, out);
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    public static void sendToClient(JSONObject toClient){
        out.println(toClient);
    }


    public static void listOfRobots(){
        String[] roboList = {"Assassin","Juggernaut","Sniper"};
        out.println("List of Robots Available:\n");
        for ( String i : roboList){
            out.println(i);
        }
        out.println("Pick Wisely and GoodLuck!");


    }
}
