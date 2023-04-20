package by.teachmeskills.lapeiko.homework25.model.comparator;

import by.teachmeskills.lapeiko.homework25.model.Show;

import java.util.Comparator;

public class ShowByRatingComparator implements Comparator<Show> {
    public static final Comparator<Show> CASE = new ShowByRatingComparator();

    private ShowByRatingComparator() {
    }

    @Override
    public int compare(Show show1, Show show2) {
        return Double.compare(show1.getRating(), show2.getRating());
    }
}