package by.teachmeskills.lapeiko.homework25.model.predicate;

import by.teachmeskills.lapeiko.homework25.model.Show;

import java.util.function.Predicate;

public class ShowByRatingPredicate implements Predicate<Show> {
    private final double ratingFrom;
    private final double ratingTo;

    public ShowByRatingPredicate(double ratingFrom, double ratingTo) {
        if (ratingFrom < Show.MIN_RATING_OF_SHOW || ratingFrom > Show.MAX_RATING_OF_SHOW) throw new IllegalArgumentException();
        if (ratingTo < Show.MIN_RATING_OF_SHOW || ratingTo > Show.MAX_RATING_OF_SHOW) throw new IllegalArgumentException();
        this.ratingFrom = ratingFrom;
        this.ratingTo = ratingTo;
    }

    @Override
    public boolean test(Show show) {
        return show.getRating() >= ratingFrom && show.getRating() <= ratingTo;
    }
}
