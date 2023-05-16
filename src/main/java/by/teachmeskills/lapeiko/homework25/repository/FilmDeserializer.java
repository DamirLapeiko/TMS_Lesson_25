package by.teachmeskills.lapeiko.homework25.repository;

import by.teachmeskills.lapeiko.homework25.model.Film;
import by.teachmeskills.lapeiko.homework25.model.Show;

import java.time.Year;

public class FilmDeserializer implements ShowDeserializer {
    public static final FilmDeserializer FILM = new FilmDeserializer();
    private FilmDeserializer(){

    }
    @Override
    public Show deserialize(String line) {
        String[] parts = line.split(",");
        return new Film(
                parts[0],
                Integer.parseInt(parts[1]),
                parts[2],
                Double.parseDouble(parts[3]),
                Integer.parseInt(parts[4])
        );
    }
}
