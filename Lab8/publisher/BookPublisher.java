package publisher;

import books.Book;

import java.util.ArrayList;
import java.util.List;

public class BookPublisher implements Publisher {

    int books_number;
    List<Book> published_books;
    String name;

    public BookPublisher(String name){
        this.published_books = new ArrayList<>();
        this.name = name;
        this.books_number = 0;
    }

    public BookPublisher(int books_number, List<Book> published_books, String name){
        this.books_number = books_number;
        this.name = name;
        this.published_books = new ArrayList<>(published_books);
    }


    @Override
    public void publishBook(Book book) {
        this.published_books.add(book);
        this.books_number+=1;
        System.out.printf("The the book '%s' was published by %s \n", book.title, this.name);
    }


    @Override
    public void getPublishedBooks() {
        for(Book book: this.published_books){
            System.out.println(book);
        }
    }

    @Override
    public String toString() {
        return "BookPublisher{" +
                "books_number=" + books_number +
                ", published_books=" + published_books +
                ", name='" + name + '\'' +
                '}';
    }

}
