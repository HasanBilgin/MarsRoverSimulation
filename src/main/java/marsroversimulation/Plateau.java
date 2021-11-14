package marsroversimulation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import marsroversimulation.util.RoverException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

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

    public Plateau(List<String> commandList) throws RoverException {
        int upperRightPointX;
        int upperRightPointY;
        try (Scanner scanner = new Scanner(commandList.get(0))) {
            upperRightPointX = scanner.nextInt();
            if ( upperRightPointX <= 0 )
                throw new RoverException("Plato sınırları 0'dan büyük olmalıdır");
            upperRightPointY = scanner.nextInt();
            if ( upperRightPointY <= 0 )
                throw new RoverException("Plato sınırları 0'dan büyük olmalıdır");
        }
        this.plateauGrid = new Position(upperRightPointX, upperRightPointY);
        roverList = new ArrayList<>();
        for (int i = 1; i < commandList.size(); i += 2)
            roverList.add(new Rover(commandList.get(i), commandList.get(i + 1)));
    }

    public void explore() {
        AtomicInteger roverCounter = new AtomicInteger(0);
        roverList.forEach(rover -> {
            final int counter = roverCounter.incrementAndGet();
            try {
                System.out.println(counter + ". gezici konumu: " + rover.execute(plateauGrid));
            } catch (RoverException exception) {
                System.out.println(counter + ". gezici hareket sırasında hata. " + exception.getMessage());
            }
        });
    }
}
