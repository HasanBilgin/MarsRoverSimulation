package marsroversimulation;

import marsroversimulation.util.Direction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MarsRoverSimulation {
    public static void main(String[] args) {
        ArrayList<String> commandList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/command.txt"))) {
            commandList = (ArrayList<String>) stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Plateau plateau = new Plateau(commandList.get(0));
        ArrayList<Rover> roverList = new ArrayList<>();
        for (int i = 1; i < commandList.size(); i += 2)
            roverList.add(new Rover(commandList.get(i),commandList.get(i+1)));

        roverList.forEach(Rover::execute);
        roverList.forEach(rover -> rover.getPosition().toString());
    }


}
