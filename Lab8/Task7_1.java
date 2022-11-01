import books.Dictionary;
import books.Encyclopedia;
import publisher.BookPublisher;

import java.util.*;

public class Task7_1 {
    public static void main(String args[]){

        BookPublisher publisher = new BookPublisher("Publisher1");

        Map<String, String> dict_values = new HashMap<String, String>();
        dict_values.put("word1","def1");
        dict_values.put("word2","def2");
        dict_values.put("word3","def3");


        Dictionary dict = new Dictionary("Dictionary 1", 240, publisher, 50, 2007, "Animals", dict_values);
        Encyclopedia enc = new Encyclopedia("Encyclopedia1", 600, publisher, 150, 1999);

        publisher.publishBook(dict);
        publisher.publishBook(enc);

    }
}
