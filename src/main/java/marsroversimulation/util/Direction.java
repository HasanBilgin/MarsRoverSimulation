package marsroversimulation.util;

import lombok.Getter;

@Getter
public enum Direction {
    NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

    String directionCode;
    Direction(String directionCode) {
        this.directionCode = directionCode;
    }
}
