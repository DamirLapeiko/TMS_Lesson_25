package by.teachmeskills.lapeiko.homework25.model.comparator;

import by.teachmeskills.lapeiko.homework25.model.Show;

import java.util.Comparator;

public class ShowByYearComparator implements Comparator<Show> {

    public static final Comparator<Show> CASE = new ShowByYearComparator();

    private ShowByYearComparator() {
    }

    @Override
        public int compare(Show show1, Show show2) {
            return Integer.compare(show1.getYearOfIssue(), show2.getYearOfIssue());
    }
}
