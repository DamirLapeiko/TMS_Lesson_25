package by.teachmeskills.lapeiko.homework25.model.comparator;

import by.teachmeskills.lapeiko.homework25.model.Show;

import java.util.Comparator;

public class ShowByCountryComparator implements Comparator<Show> {
    public static final Comparator<Show> CASE = new ShowByCountryComparator();

    private ShowByCountryComparator() {
    }

    @Override
    public int compare(Show show1, Show show2) {
        return show1.getCountryCode().compareTo(show2.getCountryCode());
    }
}
