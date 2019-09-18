/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class HistoryProvider {
    
    private History history = new History();
    private Scanner scanner = new Scanner(System.in);
    
    public History createHistory(List <Book> listBooks, List <Reader> listReaders){
        
        System.out.println("--- Выдача книги ---");
        System.out.println("Список книг в библиотеке:");
        for(int i=0; i<listBooks.size();i++){
            System.out.printf("%d. Название: %s. Автор: "
                    ,i+1,listBooks.get(i).getTitle()
                    ,listBooks.get(i).getAuthor()
            );
        }
        System.out.println("Список читателей в библиотеке:");
        for(int i=0; i<listReaders.size();i++){
            System.out.printf("%d. Название: %s. Автор: "
                    ,i+1,listReaders.get(i).getName()
                    ,listReaders.get(i).getLastname()
            );
        }
        System.out.print("Выберите номер книги: ");
        int numBook = scanner.nextInt();
        System.out.print("Выберите номер читателя: ");
        int numReader = scanner.nextInt();
        history.setBook(listBooks.get(numBook -1));
        history.setReader(listReaders.get(numReader -1));
        history.setTakeOnDate(new Date());
        return history;
    }
    public void returnBook(List<History> histories){
        System.out.println("--- Вернуть книгу ---");
        System.out.println("Список выданных книг в библиотеке:");
        for(int i=0; i<histories.size();i++){
            System.out.printf("%d. Название книги: %s. Читатель: %s %s%n"
                    ,i+1
                    ,histories.get(i).getBook().getTitle()
                    ,histories.get(i).getReader().getName()
                    ,histories.get(i).getReader().getLastname()
            );
        }
        System.out.println("выберите номер истории:");
        int numHistory = scanner.nextInt();
        histories.get(numHistory - 1).setReturnDate(new Date());
    }
}