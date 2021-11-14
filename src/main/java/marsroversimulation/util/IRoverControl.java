package marsroversimulation.util;

import marsroversimulation.Position;

public interface IRoverControl {
    void rotate(String spinDirection);

    void move(Position gridSize) throws RoverException;
}
