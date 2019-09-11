
package classes;

import entity.Book;
import java.util.Scanner;

public class BookProvider {
    public Book createBook(){
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------- Создание новой книги --------");
        System.out.println("Введите название книги: ");
        book.setTitle(scanner.nextLine());
        System.out.println("Введите автора книги: ");
        book.setAuthor(scanner.nextLine());
        System.out.println("Введите год издания книги: ");
        book.setYear(new Integer (scanner.nextLine()));
        System.out.println("Создание книги завершено.");
        return book;
    }
}
