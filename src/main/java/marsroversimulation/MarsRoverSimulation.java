package marsroversimulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MarsRoverSimulation {
    public static void main(String[] args) {
        ArrayList<String> commandList;
        try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/command.txt"))) {
            commandList = (ArrayList<String>) stream.collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("command.txt dosyası içerisinden komutlar okunamadı.");
            return;
        }
        Plateau plateau = new Plateau(commandList);
        plateau.explore();
    }


}
