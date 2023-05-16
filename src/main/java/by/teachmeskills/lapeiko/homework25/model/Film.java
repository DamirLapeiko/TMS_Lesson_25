package by.teachmeskills.lapeiko.homework25.model;

import java.time.Year;

public class Film extends Show{

    public Film(String nameOfShow, int yearOfIssue, String country, double rating, int marksCount) {
        super(nameOfShow, yearOfIssue, country, rating, marksCount);
    }

    @Override
    public String toString(){
        return "Фильм:  %-40s  %-10s %s             %.1f  %7s"
                .formatted(nameOfShow, yearOfIssue, countryCode, rating, marksCount);
    }
}
