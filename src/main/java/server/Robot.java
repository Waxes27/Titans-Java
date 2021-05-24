package server;

import server.RobotTypes.Assassin;
import server.RobotTypes.Juggernaut;
import server.RobotTypes.RobotTypes;
import server.RobotTypes.Sniper;

import java.util.Locale;

public class Robot {


    public RobotTypes validateRobot(String robotToValidate){
        switch (robotToValidate.toLowerCase(Locale.ROOT)){
            case "sniper":
                return new Sniper();

            case "juggernaut":
                return new Juggernaut();

            case "assassin":
                return new Assassin();

            default:
                throw new IllegalArgumentException();
        }
    }
}
