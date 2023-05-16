package by.teachmeskills.lapeiko.homework25.model;

import java.time.Year;

public abstract class Show {
    public static final double MIN_RATING_OF_SHOW = 0;
    public static final double MAX_RATING_OF_SHOW = 10;
    public static final int COUNTRY_CODE = 2;
    protected final String nameOfShow;
    protected final int yearOfIssue;
    protected final String countryCode;
    protected final double rating;
    protected final int marksCount;

    public Show(String nameOfShow, int yearOfIssue, String countryCode, double rating, int marksCount) {
        if (nameOfShow.isEmpty()) throw new IllegalArgumentException();
        if (countryCode.length() != COUNTRY_CODE) throw new IllegalArgumentException();
        if (rating < MIN_RATING_OF_SHOW || rating > MAX_RATING_OF_SHOW) throw new IllegalArgumentException();
        if (marksCount == 0) throw new IllegalArgumentException();
        this.nameOfShow = nameOfShow;
        this.yearOfIssue = yearOfIssue;
        this.countryCode = countryCode;
        this.rating = rating;
        this.marksCount = marksCount;
    }

    public String getNameOfShow() {
        return nameOfShow;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public double getRating() {
        return rating;
    }

    public int getMarksCount() {
        return marksCount;
    }
}
