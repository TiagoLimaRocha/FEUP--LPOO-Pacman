package utils;

import drawables.agents.Pacman;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class ScoreSaver {
    /**
     * Saves pacmans points
     */
    public void save() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(Consts.Pacman.SCORES_FILE, true));
            writer.append(Pacman.getPoints().toString());
            writer.append('\n');
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads previous game points in asc order
     */
    public List<Integer> load() {
        List<Integer> scores = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(Consts.Pacman.SCORES_FILE))) {
            stream.forEach(p -> scores.add(parseInt(p)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(scores);
        return scores;
    }

}
