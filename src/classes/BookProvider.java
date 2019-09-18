/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class BookProvider {
    public Book createBook(){
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Создание новой книги ---");
        System.out.println("Введите название книги: ");
        book.setTitle(scanner.nextLine());
        System.out.println("Введите имя автора книги: ");
        book.setAuthor(scanner.nextLine());
        System.out.println("Введите год издания книги: ");
        book.setYear(new Integer(scanner.nextLine()));
        System.out.println("Для добавления книги нажмите \"y\"");
        System.out.println("Для отмены добавления книги нажмите любой другой символ");
        String flag = scanner.next();
        if("y".equals(flag)){
            return book;
        }
        return null;
    }    
}