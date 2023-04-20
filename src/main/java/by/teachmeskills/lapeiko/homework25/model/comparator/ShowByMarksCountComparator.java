package by.teachmeskills.lapeiko.homework25.model.comparator;

import by.teachmeskills.lapeiko.homework25.model.Show;

import java.util.Comparator;

public class ShowByMarksCountComparator implements Comparator<Show> {
    public static final Comparator<Show> CASE = new ShowByMarksCountComparator();

    private ShowByMarksCountComparator() {
    }

    @Override
    public int compare(Show show1, Show show2) {
        return Integer.compare(show1.getMarksCount(), show2.getMarksCount());
    }
}
