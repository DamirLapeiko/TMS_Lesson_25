package by.teachmeskills.lapeiko.homework25;

import by.teachmeskills.lapeiko.homework25.model.Show;
import by.teachmeskills.lapeiko.homework25.repository.ShowFileRepository;
import by.teachmeskills.lapeiko.homework25.repository.ShowRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShowRepository showList = new ShowFileRepository();
        List<Show> shows = showList.getAllShows();
        for (Show show : shows) {
            System.out.println(show.toString());
        }
    }
}
