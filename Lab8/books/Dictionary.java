package books;

import publisher.BookPublisher;

import java.util.HashMap;
import java.util.Map;

public class Dictionary extends Book{

    String topic;
    Map<String, String> dict;

    public Dictionary(String title, int pages, BookPublisher publisher, int price, int year, String topic, Map<String, String> dict) {
        super(title, pages, publisher, price, year);
        this.topic = topic;
        this.dict = new HashMap<String, String>();
        this.dict.putAll(dict);
    }


    @Override
    void read(int from_page, int to_page) {
        System.out.printf("You've read '%s' from page: %d, to page: %d", this.title, from_page, to_page);
    }
}
