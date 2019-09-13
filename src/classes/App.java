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
        HistoryProvider historyProvider = null;
        do {
            do {
            System.out.println("Выберите операцию:");
            System.out.println("0. Выход");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Добавить читателя");
            System.out.println("3. Выдать книгу");
            System.out.println("4. Вернуть книгу");
            System.out.println("5. Список книг");
            System.out.println("6. Список читателей");
            
            operation = scanner.next();
            badOperation = false;
            switch (operation) {
                case "0":
                    badOperation = false;
                    break;
                case "1":
                    BookProvider bookProvider = new BookProvider();
                     Book book = bookProvider.createBook();
                    if (book == null){
                        System.out.println("Книгу создать не удалось.");
                    }else{
                        listBooks.add(book);
                        System.out.println("Добавлена новая книга!");}
                    break;                     
                case "2":
                    ReaderProvider readerProvider = new ReaderProvider();
                    Reader reader = readerProvider.createReader();
                    if (reader == null){
                        System.out.println("Читателя создать не удалось.");
                    }else{
                        listReaders.add(reader);
                        System.out.println("Добавлен новый читатель.");}
                    /*System.out.println("Выполняем операцию 2");*/
                    break;
                case "3":
                    //HistoryProvider 
                    historyProvider = new HistoryProvider();
                    //listHistories.add(historyProvider.createHistory(listBooks, listReaders));
                    History history = historyProvider.createHistory(listBooks, listReaders);
                    if (history == null){
                        System.out.println("Не удалось выдать книгу.");
                    }else{
                        listHistories.add(history);
                        System.out.println("Книга выдана читателю.");}
                    /*System.out.println("Выполняем операцию 3");*/
                    break;
                case "4":
                    historyProvider.returnBook(listHistories);
                    System.out.println("Книга возвращена в библиотеку.");
                    break;
                case "5":
                    System.out.println("--- Список книг ---");
                    for(Book b : listBooks){
                        System.out.println(b.toString());
                    }
                    break;
                case "6":
                    System.out.println("--- Список читателей ---");
                    for(Reader r : listReaders){
                        System.out.println(r.toString());
                    }
                    break;
                default:
                    System.out.println("Неправильная операция");
                    System.out.println("Выберите правильную операцию");
                    badOperation = true;
            }
            }while (badOperation);
            if(operation.equals("0"))break;
        }while (true);
        
        
}
}