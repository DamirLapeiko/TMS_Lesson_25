package by.teachmeskills.lapeiko.homework25.repository;

import by.teachmeskills.lapeiko.homework25.model.Show;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class ShowFileRepository implements ShowRepository {
    private static final Path FILMS_PATH = Path.of("films.csv");
    private static final Path SERIES_PATH = Path.of("series.csv");

    @Override
    public List<Show> getAllShows() {
        try (Stream<String> filmsCsv = Files.lines(FILMS_PATH);
             Stream<String> seriesCsv = Files.lines(SERIES_PATH)) {
            return Stream.concat(
                    filmsCsv.map(FilmDeserializer.FILM::deserialize),
                    seriesCsv.map(SeriesDeserializer.SERIES::deserialize)
            ).collect(toCollection(ArrayList::new));

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
