package by.teachmeskills.lapeiko.homework25.model.predicate;

import by.teachmeskills.lapeiko.homework25.model.Show;

import java.util.function.Predicate;

public class ShowByCountryPredicate implements Predicate<Show> {
    private final String countryCode;

    public ShowByCountryPredicate(String countryCode) {
        if (countryCode.length() != Show.COUNTRY_CODE) throw new IllegalArgumentException();
        this.countryCode = countryCode;
    }

    @Override
    public boolean test(Show show) {
        return show.getCountryCode().equals(countryCode);
    }
}