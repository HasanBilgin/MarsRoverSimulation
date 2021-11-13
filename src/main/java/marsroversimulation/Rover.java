package marsroversimulation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marsroversimulation.util.Direction;
import marsroversimulation.util.IRoverControl;

import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor
public class Rover implements IRoverControl {
    private Position position;
    private Direction direction;
    private String commandList;

    public Rover(String position, String command) {
        try (Scanner scanner = new Scanner(position)) {
            this.position = new Position(scanner.nextInt(), scanner.nextInt());
            switch (scanner.next().trim()) {
                case "N":
                    this.direction = Direction.NORTH;
                    break;
                case "S":
                    this.direction = Direction.SOUTH;
                    break;
                case "E":
                    this.direction = Direction.EAST;
                    break;
                case "W":
                    this.direction = Direction.WEST;
                    break;
                default:
                    this.direction = null;
            }
        }
        this.commandList = command;
    }

    @Override
    public void move() {
        switch (this.direction) {
            // ( x , y+1 )
            case NORTH:
                position.setY(position.getY() + 1);
                break;
            // ( x+1 , y )
            case EAST:
                position.setX(position.getX() + 1);
                break;
            // ( x , y-1 )
            case SOUTH:
                position.setY(position.getY() - 1);
                break;
            // ( x-1 , y )
            case WEST:
                position.setX(position.getX() - 1);
                break;
            default:
                break;
        }
    }

    @Override
    public void rotate(String spinDirection) {
        if (spinDirection != null && !spinDirection.isEmpty()) {
            switch (this.direction) {
                case NORTH:
                    if ("L".equalsIgnoreCase(spinDirection))
                        setDirection(Direction.WEST);
                    else if ("R".equalsIgnoreCase(spinDirection))
                        setDirection(Direction.EAST);
                    break;
                case WEST:
                    if ("L".equalsIgnoreCase(spinDirection))
                        setDirection(Direction.SOUTH);
                    else if ("R".equalsIgnoreCase(spinDirection))
                        setDirection(Direction.NORTH);
                    break;
                case SOUTH:
                    if ("L".equalsIgnoreCase(spinDirection))
                        setDirection(Direction.EAST);
                    else if ("R".equalsIgnoreCase(spinDirection))
                        setDirection(Direction.WEST);
                    break;
                case EAST:
                    if ("L".equalsIgnoreCase(spinDirection))
                        setDirection(Direction.NORTH);
                    else if ("R".equalsIgnoreCase(spinDirection))
                        setDirection(Direction.SOUTH);
                    break;
                default:
                    break;
            }
        }
    }

    public String execute() throws UnsupportedOperationException {
        for (char controlData : this.commandList.toUpperCase().toCharArray()) {
            if ('L' != controlData && 'R' != controlData && 'M' != controlData)
                throw new UnsupportedOperationException("Rover command error");

            if ('M' == controlData)
                move();
            else
                rotate(Character.toString(controlData));
        }

        return this.getPosition().getX() + " " + this.getPosition().getY() + " " + this.getDirection().getDirectionCode();
    }
}
