package by.teachmeskills.lapeiko.homework25.repository;

import by.teachmeskills.lapeiko.homework25.model.Series;
import by.teachmeskills.lapeiko.homework25.model.Show;

import java.time.Year;

public class SeriesDeserializer implements ShowDeserializer{
    public static final SeriesDeserializer SERIES = new SeriesDeserializer();
    private SeriesDeserializer(){

    }
    @Override
    public Show deserialize(String line) {
        String[] parts = line.split(",");
        return new Series(
                parts[0],
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2]),
                parts[3],
                Integer.parseInt(parts[4]),
                Integer.parseInt(parts[5]),
                Double.parseDouble(parts[6]),
                Integer.parseInt(parts[7])
        );
    }
}
