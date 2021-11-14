import marsroversimulation.Plateau;
import marsroversimulation.Position;
import marsroversimulation.Rover;
import marsroversimulation.util.Direction;
import marsroversimulation.util.RoverException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MarsRoverSimulationTest {

    @Test
    public void rotateLeftNorth() {
        Rover rover = new Rover();
        rover.setDirection(Direction.NORTH);
        rover.rotate("L");
        Assert.assertEquals(Direction.WEST, rover.getDirection());
    }

    @Test
    public void rotateRightNorth() {
        Rover rover = new Rover();
        rover.setDirection(Direction.NORTH);
        rover.rotate("R");
        Assert.assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    public void rotateLeftSouth() {
        Rover rover = new Rover();
        rover.setDirection(Direction.SOUTH);
        rover.rotate("L");
        Assert.assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    public void rotateRightSouth() {
        Rover rover = new Rover();
        rover.setDirection(Direction.SOUTH);
        rover.rotate("R");
        Assert.assertEquals(Direction.WEST, rover.getDirection());
    }

    @Test
    public void rotateLeftWest() {
        Rover rover = new Rover();
        rover.setDirection(Direction.WEST);
        rover.rotate("L");
        Assert.assertEquals(Direction.SOUTH, rover.getDirection());
    }

    @Test
    public void rotateRightWest() {
        Rover rover = new Rover();
        rover.setDirection(Direction.WEST);
        rover.rotate("R");
        Assert.assertEquals(Direction.NORTH, rover.getDirection());
    }


    @Test
    public void rotateLeftEast() {
        Rover rover = new Rover();
        rover.setDirection(Direction.EAST);
        rover.rotate("L");
        Assert.assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    public void rotateRightEast() {
        Rover rover = new Rover();
        rover.setDirection(Direction.EAST);
        rover.rotate("R");
        Assert.assertEquals(Direction.SOUTH, rover.getDirection());
    }

    @Test
    public void moveEastSuccess() {
        try {
            Rover rover = new Rover();
            rover.setPosition(new Position(1, 1));
            rover.setDirection(Direction.EAST);
            Plateau plateau = new Plateau(5, 5);
            rover.move(plateau.getPlateauGrid());
            Assert.assertEquals(new Position(2, 1).getX(), rover.getPosition().getX());
        } catch (RoverException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = RoverException.class)
    public void moveEastFail() throws RoverException {
        Rover rover = new Rover();
        rover.setPosition(new Position(5, 1));
        rover.setDirection(Direction.EAST);
        Plateau plateau = new Plateau(5, 5);
        rover.move(plateau.getPlateauGrid());
        Assert.assertEquals(new Position(2, 1).getX(), rover.getPosition().getX());
    }

    @Test
    public void moveWestSuccess() {
        try {
            Rover rover = new Rover();
            rover.setPosition(new Position(1, 1));
            rover.setDirection(Direction.WEST);
            Plateau plateau = new Plateau(5, 5);
            rover.move(plateau.getPlateauGrid());
            Assert.assertEquals(new Position(0, 1).getX(), rover.getPosition().getX());
        } catch (RoverException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = RoverException.class)
    public void moveWestFail() throws RoverException {
        Rover rover = new Rover();
        rover.setPosition(new Position(0, 1));
        rover.setDirection(Direction.WEST);
        Plateau plateau = new Plateau(5, 5);
        rover.move(plateau.getPlateauGrid());
        Assert.assertEquals(new Position(0, 1).getX(), rover.getPosition().getX());
    }

    @Test
    public void moveNorthSuccess() {
        try {
            Rover rover = new Rover();
            rover.setPosition(new Position(1, 1));
            rover.setDirection(Direction.NORTH);
            Plateau plateau = new Plateau(5, 5);
            rover.move(plateau.getPlateauGrid());
            Assert.assertEquals(new Position(1, 2).getY(), rover.getPosition().getY());
        } catch (RoverException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = RoverException.class)
    public void moveNorthFail() throws RoverException {
        Rover rover = new Rover();
        rover.setPosition(new Position(1, 5));
        rover.setDirection(Direction.NORTH);
        Plateau plateau = new Plateau(5, 5);
        rover.move(plateau.getPlateauGrid());
        Assert.assertEquals(new Position(1, 5).getY(), rover.getPosition().getY());
    }

    @Test
    public void moveSouthSuccess() {
        try {
            Rover rover = new Rover();
            rover.setPosition(new Position(1, 1));
            rover.setDirection(Direction.SOUTH);
            Plateau plateau = new Plateau(5, 5);
            rover.move(plateau.getPlateauGrid());
            Assert.assertEquals(new Position(1, 0).getY(), rover.getPosition().getY());
        } catch (RoverException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = RoverException.class)
    public void moveSouthFail() throws RoverException {
        Rover rover = new Rover();
        rover.setPosition(new Position(5, 0));
        rover.setDirection(Direction.SOUTH);
        Plateau plateau = new Plateau(5, 5);
        rover.move(plateau.getPlateauGrid());
        Assert.assertEquals(new Position(2, 1).getY(), rover.getPosition().getY());
    }

    @Test(expected = RoverException.class)
    public void plateauWrongAxisX() throws RoverException{
        ArrayList<String> command = new ArrayList<>();
        command.add("-1 2");
        new Plateau(command);
    }

    @Test(expected = RoverException.class)
    public void plateauWrongAxisX_2() throws RoverException{
        ArrayList<String> command = new ArrayList<>();
        command.add("0 2");
        new Plateau(command);
    }

    @Test(expected = RoverException.class)
    public void plateauWrongAxisY() throws RoverException{
        ArrayList<String> command = new ArrayList<>();
        command.add("1 -2");
        new Plateau(command);
    }

    @Test(expected = RoverException.class)
    public void plateauWrongAxisY_2() throws RoverException{
        ArrayList<String> command = new ArrayList<>();
        command.add("2 0");
        new Plateau(command);
    }

    @Test(expected = RoverException.class)
    public void plateauWrongLine() throws RoverException{
        ArrayList<String> command = new ArrayList<>();
        command.add("a 2");
        new Plateau(command);
    }

    @Test(expected = RoverException.class)
    public void plateauWrongLine2() throws RoverException{
        ArrayList<String> command = new ArrayList<>();
        command.add("2 sd");
        new Plateau(command);
    }

}
