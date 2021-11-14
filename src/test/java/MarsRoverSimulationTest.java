import marsroversimulation.Plateau;
import marsroversimulation.Rover;
import marsroversimulation.util.Direction;
import marsroversimulation.util.RoverException;
import org.junit.Assert;
import org.junit.Test;

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

//    @Test
//    public void moveEastSuccess()   {
//        try {
//            Rover rover = new Rover();
//            Plateau plateau = new Plateau(5,5);
//            rover.move(plateau.getPlateauGrid());
//        } catch (RoverException e) {
//            e.printStackTrace();
//        }
//    }
}
