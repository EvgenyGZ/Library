/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author melnikov
 */
public class App {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        String operation = "0";
        boolean badOperation;
        List<Book> listBooks = new ArrayList<>();
        List<Reader> listReaders = new ArrayList<>();
        List<History> listHistories = new ArrayList<>();
        do{
            do{
                System.out.println("Выберите операцию: ");
                System.out.println("0 - Выход");
                System.out.println("1 - Добавить книгу");
                System.out.println("2 - Добавить читателя");
                System.out.println("3 - Выдать книгу");
                System.out.println("4 - Вернуть книгу");
                System.out.println("5 - Показать список книг");
                System.out.println("6 - Показать список читателей");
                System.out.println("-----------------------------------");
                operation = scanner.next();
                badOperation = false;
                switch (operation) {
                    case "0":
                        badOperation = false;                              
                    break;
                    case "1":
                        // создаем объек класса
                        BookProvider bookProvider = new BookProvider();
                        listBooks.add(bookProvider.createBook());
                        break;
                    case "2":
                        ReaderProvider readerProvider = new ReaderProvider();
                        listReaders.add(readerProvider.createReader());
                        break;
                    case "3":
                        HistoryProvider historyProvider = new HistoryProvider();
                        listHistories.add(HistoryProvider.createHistory());
                        break;
                    case "4":
                        System.out.println("Выполняем операцию 4"); 
                        break;
                    case "5":
                        System.out.println("-------- Список книг: --------");
                        for (Book book : listBooks){
                            System.out.println(book.toString());}
                        break;
                    case "6":
                    System.out.println("-------- Список книг: --------");
                    for (Reader reader : listReaders){
                        System.out.println(reader.toString());}
                    break;
                    default:
                        System.out.println("Выберите правильную операцию!!!");
                        badOperation = true;
                }
            }while(badOperation);
            if(operation.equals("0"))break;
        }while(true);
    }
//        Book book = new Book();
//        book.setId(1L);
//        book.setTitle("Voina i mir");
//        book.setAuthor("L.Tolstoy");
//        book.setYear(2010);
//        System.out.println(book.getId());
//        System.out.println(book.getTitle());
//        System.out.println(book.getAuthor());
//        System.out.println(book.getYear());
//        System.out.println("Вывод метода toString(): ");
//        System.out.println(book.toString());
//        
//        Book book2 = new Book(2L, "Otsi i deti", "I.Turgenev", 2011);
//        System.out.println(book2.toString());
//        
//        book.setYear(2012);
//        System.out.println(book.toString());
//        
//        Reader reader = new Reader(1L, "Ivan", "Ivanov", 10, 10, 2000);
//        System.out.println(reader.toString());
//                
//        System.out.println("Выдача книги:");
//        History history = new History();
//        history.setId(1L);
//        history.setBook(book);
//        history.setReader(reader);
//        history.setTakeOnDate(new Date());
//        System.out.println(history.toString());
//        System.out.println("Возврат книги:");
//        history.setReturnDate(new Date());
//        System.out.println(history.toString());
    
}
