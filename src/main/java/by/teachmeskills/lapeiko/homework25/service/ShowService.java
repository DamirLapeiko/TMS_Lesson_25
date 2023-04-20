package by.teachmeskills.lapeiko.homework25.service;

import by.teachmeskills.lapeiko.homework25.model.Show;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface ShowService {
    List<Show> request(List<Predicate<Show>> filters, List<Comparator<Show>> sortings);
}
