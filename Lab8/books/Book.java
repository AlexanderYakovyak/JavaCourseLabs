package books;
import publisher.*;

public abstract class Book {

    public String title;
    public int pages;
    public BookPublisher publisher;
    public int price;
    public int year;

    public Book(String title, int pages, BookPublisher publisher, int price, int year) {
        this.title = title;
        this.pages = pages;
        this.publisher = publisher;
        this.price = price;
        this.year = year;
    }

    abstract void read(int from_page, int to_page);

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                ", publisher=" + publisher +
                ", price=" + price +
                ", year=" + year +
                '}';
    }
}


