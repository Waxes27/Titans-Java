package server.Commands;

import server.RobotTypes.RobotTypes;

public class Forward implements CommandInterface{
    private int steps;

    public Forward(int steps, RobotTypes robot){

        this.steps = steps;
        run();
    }

    @Override
    public void run() {
        System.out.println("Forward "+steps);
    }
}
