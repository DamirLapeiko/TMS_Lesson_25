package by.teachmeskills.lapeiko.homework25.model.predicate;

import by.teachmeskills.lapeiko.homework25.model.Show;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShowByNameOfShowPredicate implements Predicate<Show> {
    private final Pattern pattern;

    public ShowByNameOfShowPredicate(String query) {
        this.pattern = Pattern.compile(
                "\\b" + Pattern.quote(query),
                Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
    }

    @Override
    public boolean test(Show show) {
        Matcher matcher = pattern.matcher(show.getNameOfShow());
        return matcher.find();
    }
}
