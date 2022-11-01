package books;

import publisher.BookPublisher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Encyclopedia extends Book{

    List<String> categories;

    public Encyclopedia(String title, int pages, BookPublisher publisher, int price, int year) {
        super(title, pages, publisher, price, year);
        this.categories = Arrays.asList("All topics");

    }

    public Encyclopedia(String title, int pages, BookPublisher publisher, int price, int year, List<String> categories) {
        super(title, pages, publisher, price, year);
        this.categories = new ArrayList<>(categories);
    }

    @Override
    void read(int from_page, int to_page) {
        System.out.printf("You've read '%s' from page: %d, to page: %d", this.title, from_page, to_page);
    }
}
