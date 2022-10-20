package book;

import java.util.Scanner;

public class Task2_5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Book book1 = new Book("Title1", "Author1","Publisher1","1975","240","hardcover");
        Book book2 = new Book("Title2", "Author2","Publisher2","2000","56","paperback");
        Book book3 = new Book("Title3", "Author3","Publisher3","1899","550","hardcover");
        Book book4 = new Book("Title4", "Author2","Publisher4","2005","120","hardcover");
        Book book5 = new Book("Title5", "Author4","Publisher3","1999","16","paperback");

        Book[] books = Book.toList(5, book1, book2, book3, book4, book5);

        System.out.println("Введіть автора, список книг якого ви хочете отримати: ");
        String author = sc.nextLine();

        System.out.println("Список книг, які написав вказаний автор: ");
        for(Book book: books){
            if(author.equals(book.getAuthor())){
                System.out.println(book);
            }
        }
        System.out.println();

        System.out.println("Введіть видавництво, список книг якого ви хочете отримати: ");
        String publisher = sc.nextLine();

        System.out.println("Список книг, які написав вказаного видавництва: ");
        for(Book book: books){
            if(publisher.equals(book.getPublisher())){
                System.out.println(book);
            }
        }
        System.out.println();

        System.out.println("Введіть рік, щоб отримати список книг виданих пізніше цього року: ");
        String year = sc.nextLine();

        System.out.println("Шуканий список книг: ");
        for(Book book: books){
            if(Integer.parseInt(book.getYear())>Integer.parseInt(year)){
                System.out.println(book);
            }
        }

    }
}
