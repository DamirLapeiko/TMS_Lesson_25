package by.teachmeskills.lapeiko.homework25.model.predicate;

import by.teachmeskills.lapeiko.homework25.model.Show;

import java.util.function.Predicate;

public class ShowByMarksCountPredicate implements Predicate<Show> {
    private final int countFrom;
    private final int countTo;

    public ShowByMarksCountPredicate(int countFrom, int countTo) {
        if (countFrom < 0) throw new IllegalArgumentException();
        if (countTo < 0) throw new IllegalArgumentException();
        if (countFrom > countTo) throw new IllegalArgumentException();

        this.countFrom = countFrom;
        this.countTo = countTo;
    }

    @Override
    public boolean test(Show show) {
        return show.getMarksCount() >= countFrom && show.getMarksCount() <= countTo;
    }
}
