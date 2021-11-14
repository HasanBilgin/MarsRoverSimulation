package marsroversimulation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marsroversimulation.util.Direction;
import marsroversimulation.util.IRoverControl;
import marsroversimulation.util.RoverException;

import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor
public class Rover implements IRoverControl {
    private Position position;
    private Direction direction;
    private String commandList;

    public Rover(String position, String command) {
        if (!position.matches("\\d \\d \\w")) {
            this.position = null;
            this.direction = null;
        } else {
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
        }

        if (!command.toUpperCase().matches("^[LMR]*$"))
            this.commandList = null;
        else
            this.commandList = command.toUpperCase();

    }

    @Override
    public void move(Position gridSize) throws RoverException {
        switch (this.direction) {
            // ( x , y+1 )
            case NORTH:
                if (position.getY() + 1 > gridSize.getY())
                    throw new RoverException("Plato sınırı dışına çıkıldı.");
                position.setY(position.getY() + 1);
                break;
            // ( x+1 , y )
            case EAST:
                if (position.getX() + 1 > gridSize.getX())
                    throw new RoverException("Plato sınırı dışına çıkıldı.");
                position.setX(position.getX() + 1);
                break;
            // ( x , y-1 )
            case SOUTH:
                if (position.getY() - 1 < 0)
                    throw new RoverException("Plato sınırı dışına çıkıldı.");
                position.setY(position.getY() - 1);
                break;
            // ( x-1 , y )
            case WEST:
                if (position.getX() - 1 < 0)
                    throw new RoverException("Plato sınırı dışına çıkıldı.");
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

    public String execute(Position gridSize) throws RoverException {
        if (this.position == null)
            throw new RoverException("Gezici cihaz pozisyon bilgisi hatalı");
        if (this.direction == null)
            throw new RoverException("Gezici cihaz yön bilgisi hatalı");
        if (this.commandList == null)
            throw new RoverException("Gezici cihaz komutları hatalı");

        for (char controlData : this.commandList.toUpperCase().toCharArray()) {
            if ('M' == controlData)
                move(gridSize);
            else
                rotate(Character.toString(controlData));
        }

        return this.getPosition().getX() + " " + this.getPosition().getY() + " " + this.getDirection().getDirectionCode();
    }
}
