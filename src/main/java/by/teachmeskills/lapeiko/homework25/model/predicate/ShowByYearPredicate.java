package by.teachmeskills.lapeiko.homework25.model.predicate;

import by.teachmeskills.lapeiko.homework25.model.Show;

import java.util.function.Predicate;

public class ShowByYearPredicate implements Predicate<Show> {
    private final int yearOfIssue;

    public ShowByYearPredicate(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    @Override
    public boolean test(Show show) {
return show.getYearOfIssue() == yearOfIssue;
    }
}
