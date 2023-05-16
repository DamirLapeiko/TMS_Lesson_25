package by.teachmeskills.lapeiko.homework25;

import by.teachmeskills.lapeiko.homework25.model.Show;
import by.teachmeskills.lapeiko.homework25.model.comparator.ShowByMarksCountComparator;
import by.teachmeskills.lapeiko.homework25.model.comparator.ShowByNameOfShowComparator;
import by.teachmeskills.lapeiko.homework25.model.comparator.ShowByRatingComparator;
import by.teachmeskills.lapeiko.homework25.model.comparator.ShowByYearComparator;
import by.teachmeskills.lapeiko.homework25.model.predicate.*;
import by.teachmeskills.lapeiko.homework25.repository.ShowFileRepository;
import by.teachmeskills.lapeiko.homework25.repository.ShowRepository;
import by.teachmeskills.lapeiko.homework25.service.ShowService;
import by.teachmeskills.lapeiko.homework25.service.ShowServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Predicate;

public class Main {
        private static final Logger log =
            LoggerFactory.getLogger(Main.class);

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        log.info("Программа запущена");
        ShowRepository showList = new ShowFileRepository();
        ShowService showService = new ShowServiceImpl(showList);
        List<Predicate<Show>> filters = requestFilters();
        List<Comparator<Show>> sorting = requestSorting();
        List<Show> shows = showService.request(filters, sorting);
        if (shows.isEmpty()) {
            System.out.println("Ничего не было найдено");
        } else {
            for (Show show : shows) {
                System.out.println(show);
            }
            log.info("Программа закончена");
        }
    }

    private static List<Predicate<Show>> requestFilters() {
        List<Predicate<Show>> filters = new ArrayList<>();

        System.out.println("""
                Добавьте фильтр:
                  byCountry <countryCode>
                  byMarksCount <from> <to>
                  byRating <from> <to>
                  byYearOfIssue <year>
                  byNameOfShow <query>
                  end""");
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            String[] parts = command.split("\\s+");

            if (parts[0].equals("end")) return filters;

            Predicate<Show> filter = switch (parts[0]) {
                case "byCountry" -> new ShowByCountryPredicate(parts[1]);
                case "byMarksCount" ->
                        new ShowByMarksCountPredicate(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                case "byRating" ->
                        new ShowByRatingPredicate(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
                case "byYearOfIssue" -> new ShowByYearPredicate(Integer.parseInt(parts[1]));
                case "byNameOfShow" ->
                        new ShowByNameOfShowPredicate(String.join(" ", Arrays.asList(parts).subList(1, parts.length)));
                default -> throw new IllegalArgumentException("Неизвестная команда");
            };
            filters.add(filter);
        }
    }

    private static List<Comparator<Show>> requestSorting() {
        List<Comparator<Show>> sorting = new ArrayList<>();

        System.out.println("""
                Add sorting:
                  byMarksCount direct|reversed
                  byRating direct|reversed
                  byYearOfIssue direct|reversed
                  byNameOfShow direct|reversed
                  end""");
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            String[] parts = command.split("\\s+");

            if (parts[0].equals("end")) return sorting;

            Comparator<Show> comparator = switch (parts[0]) {
                case "byMarksCount" -> ShowByMarksCountComparator.CASE;
                case "byRating" -> ShowByRatingComparator.CASE;
                case "byYearOfIssue" -> ShowByYearComparator.CASE;
                case "byNameOfShow" -> ShowByNameOfShowComparator.CASE;
                default -> throw new IllegalArgumentException("Неизвестная команда");
            };
            comparator = switch (parts[1]) {
                case "direct" -> comparator;
                case "reversed" -> comparator.reversed();
                default -> throw new IllegalArgumentException("Неправильное указание сортировки");
            };
            sorting.add(comparator);
        }
    }
}
