package by.teachmeskills.lapeiko.homework25.model.comparator;

import by.teachmeskills.lapeiko.homework25.model.Show;

import java.util.Comparator;

public class ShowByNameOfShowComparator implements Comparator<Show> {
    public static final Comparator<Show> CASE = new ShowByNameOfShowComparator();

    private ShowByNameOfShowComparator() {
    }

    @Override
    public int compare(Show show1, Show show2) {
        return show1.getNameOfShow().compareTo(show2.getNameOfShow());
    }
}