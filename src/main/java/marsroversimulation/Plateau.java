package marsroversimulation;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@NoArgsConstructor
public class Plateau {
    Position plateauGrid;
    ArrayList<Rover> roverList;

    public Plateau(Position plateauGrid) {
        this.plateauGrid = plateauGrid;
    }

    public Plateau(int x, int y) {
        this.plateauGrid = new Position(x, y);
    }

    public Plateau(List<String> commandList) {
        int upperRightPointX;
        int upperRightPointY;
        try (Scanner scanner = new Scanner(commandList.get(0))) {
            upperRightPointX = scanner.nextInt();
            upperRightPointY = scanner.nextInt();
        }
        this.plateauGrid = new Position(upperRightPointX, upperRightPointY);
        roverList = new ArrayList<>();
        for (int i = 1; i < commandList.size(); i += 2)
            roverList.add(new Rover(commandList.get(i), commandList.get(i + 1)));
    }

    public void explore () {
        roverList.forEach(rover -> System.out.println(rover.execute()));
    }
}
