package by.teachmeskills.lapeiko.homework25.model;

import java.time.Year;

public class Series extends Show {

    private final int yearOfIssueLastEpisode;
    private final int seasonsCount;

    private final int episodesCount;

    public Series(String nameOfShow, int yearOfIssue, int yearOfIssueLastEpisode,
                  String countryCode, int seasonsCount, int episodesCount, double rating, int marksCount) {
        super(nameOfShow, yearOfIssue, countryCode, rating, marksCount);
        if (seasonsCount < 0) throw new IllegalArgumentException();
        if (episodesCount < 0) throw new IllegalArgumentException();
        this.yearOfIssueLastEpisode = yearOfIssueLastEpisode;
        this.seasonsCount = seasonsCount;
        this.episodesCount = episodesCount;
    }

    @Override
    public String toString() {
        return "Сериал: %-40s  %s–%s  %s  %2ss  %3se  %.1f  %7s"
                .formatted(nameOfShow, yearOfIssue, yearOfIssueLastEpisode, countryCode,
                        seasonsCount, episodesCount, rating, marksCount);
    }

}
