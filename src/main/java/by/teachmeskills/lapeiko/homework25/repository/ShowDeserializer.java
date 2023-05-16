package by.teachmeskills.lapeiko.homework25.repository;

import by.teachmeskills.lapeiko.homework25.model.Show;

public interface ShowDeserializer {
    Show deserialize(String line);
}
