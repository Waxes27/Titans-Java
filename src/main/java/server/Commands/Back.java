package server.Commands;

import server.RobotTypes.RobotTypes;

public class Back implements CommandInterface{
    private int steps;

    public Back(int steps, RobotTypes robot){
        this.steps = steps;
        run();
    }

    @Override
    public void run() {
        System.out.println("Back "+steps);

    }
}