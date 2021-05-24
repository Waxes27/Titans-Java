package server;

import org.json.JSONObject;
import server.Commands.CommandInterface;
import server.Commands.Forward;
import server.RobotTypes.RobotTypes;

import java.io.PrintStream;
import java.net.Socket;
import java.util.PrimitiveIterator;
//import server.Commands.Null;

public class CommandHandler {
//    public CommandHandler(){}

    public static CommandInterface command(JSONObject command, RobotTypes robot, PrintStream out){
        int steps;

        String commandAfterJson = command.get("command").toString();
        String[] args = commandAfterJson.split(" ");

        switch (args[0]){
            case "forward":
                steps = Integer.parseInt(args[1]);
                return new Forward(steps,robot);

            case "launch":
                out.println("Launching into world");



            default:
                throw new IllegalArgumentException();
        }
    }

}
