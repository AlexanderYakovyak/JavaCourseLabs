package book;
public class Book {

    String title;
    String author;
    String publisher;
    String year;
    String pages;
    String price;
    String binding;

    Book(String title, String author, String publisher, String year,
            String pages, String price){

        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.binding = binding;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year='" + year + '\'' +
                ", pages='" + pages + '\'' +
                ", price='" + price + '\'' +
                ", binding='" + binding + '\'' +
                '}';
    }

    public static Book[] toList(int n, Book ... books){
        Book[] array = new Book[n];
        for(int i=0; i<n; ++i){
            array[i] = books[i];
        }

        return array;
    }

}
