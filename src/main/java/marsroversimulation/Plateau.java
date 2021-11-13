package marsroversimulation;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Getter
@NoArgsConstructor
public class Plateau {
    Position plateauGrid;

    public Plateau(Position plateauGrid) {
        this.plateauGrid = plateauGrid;
    }

    public Plateau(int x, int y) {
        this.plateauGrid = new Position(x, y);
    }

    public Plateau(String commandList) {
        int upperRightPointX;
        int upperRightPointY;
        try (Scanner scanner = new Scanner(commandList)) {
            upperRightPointX = scanner.nextInt();
            upperRightPointY = scanner.nextInt();
        }
        this.plateauGrid = new Position(upperRightPointX, upperRightPointY);
    }
}
