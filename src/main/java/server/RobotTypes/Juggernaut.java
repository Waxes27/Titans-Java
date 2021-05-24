package server.RobotTypes;

public class Juggernaut implements RobotTypes{
    /*
    Heavy on defense and slow medium attack
    */

    @Override
    public int attackStrength() {
        return 0;
    }

    @Override
    public String defenseType() {
        return "";
    }

    @Override
    public int movementSpeed() {
        return 0;
    }

    @Override
    public int reloadTime() {
        return 0;
    }

    @Override
    public int attackRange() {
        return 0;
    }

    @Override
    public int health() {
        return 0;
    }

    @Override
    public int shield() {
        return 0;
    }

    @Override
    public String toString(){
        return "Juggernaut";
    }
}
