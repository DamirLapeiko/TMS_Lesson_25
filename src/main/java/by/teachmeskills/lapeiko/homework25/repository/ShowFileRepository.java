package by.teachmeskills.lapeiko.homework25.repository;

import by.teachmeskills.lapeiko.homework25.model.Show;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ShowFileRepository implements ShowRepository {
    private static final Path FILMS_PATH = Path.of("films.csv");
    private static final Path SERIES_PATH = Path.of("series.csv");

    @Override
    public List<Show> getAllShows() {
        List<Show> shows = new ArrayList<>();
        readAllShows(shows, FILMS_PATH, new FilmDeserializer());
        readAllShows(shows, SERIES_PATH, new SeriesDeserializer());
        return shows;
    }

    private void readAllShows(List<Show> shows, Path path, ShowDeserializer deserializer) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String csvLine = reader.readLine();
            while (csvLine != null) {
                Show show = deserializer.deserialize(csvLine);
                shows.add(show);
                csvLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
