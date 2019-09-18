
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App { 
    List<Book> listBooks=new ArrayList<>();//generic list interface
    SaverToFile saverToFile =new SaverToFile();
    List<Reader> listReaders=new ArrayList<>();
    List<History> listHistories=new ArrayList<>();
    
    
    public App() {
        listBooks.addAll(saverToFile.loadListBooks());
        listReaders.addAll(saverToFile.loadListReaders());
        listHistories.addAll(saverToFile.loadListHistories());
    }
    
    public void run(){
        HistoryProvider historyProvider = new HistoryProvider();
        String operation="0";
        boolean badOperation=false;
        
        //-------------List------------------
       
        
        
        //-------------SCaNNER---------------
        
        Scanner scanner = new Scanner(System.in);
        
        //-------------Do WHILE--------------
        do {
            
            do{
                System.out.println("Выберите операцию:");
                System.out.println("1. Добавить книгу");
                System.out.println("2. Добавить читателя");
                System.out.println("3. Выдача книги");
                System.out.println("4. Возвращение книги");
                System.out.println("5. Список книг");
                System.out.println("6. Список читателей");
                
                System.out.println("0. Выход");
                badOperation=false;

                operation=scanner.next();
                switch (operation) {
                    case "1":
                         System.out.println("1. Добавить книгу в библиотеку");
                         BookProvider bookProvider = new BookProvider();
                         Book book = bookProvider.createBook();
                         if(book==null){
                             System.out.println("Книгу внести не удалось");                         
                         }else{
                             listBooks.add(book);
                             saverToFile.saveBooks(listBooks);
                             System.out.println("Книга добавлена");
                         }
                        break;
                        
                    case "2":
                        System.out.println("2. Добавить читателя в список");
                        ReaderProvider readerProvider = new ReaderProvider();
                        Reader reader = readerProvider.createReader();
                        
                        if(reader==null){
                             System.out.println("Читателя внести не удалось");                         
                        }else{
                             listReaders.add(reader);
                             saverToFile.saveReaders(listReaders);
                             System.out.println("Читатель добавлен");
                        }
                        
                        break;

                    case "3":
                        System.out.println("3. Читатель взял книгу на дом");
                        History history = historyProvider.createHistory(listBooks,listReaders);
                        
                        if(history==null){
                             System.out.println("Книгу внести не удалось");                         
                         }else{
                             listHistories.add(history);
                             saverToFile.saveHistories(listHistories);
                             System.out.println("Книга выдана");
                         }
                        break;

                    case "4":
                                    
                        System.out.println("4. Читатель вернул книгу в библиотеку");
                        historyProvider.returnBook(listHistories);
                        saverToFile.saveHistories(listHistories);
                        break;
                        
                    case "5":
                        System.out.println();
                        System.out.println("Список книг: ");
                        for (Book b : listBooks){
                            System.out.println(b.toString());
                        }
                        System.out.println("-------------------");
                        System.out.println();
                        break;
                        
                    case "6":
                        System.out.println();
                        System.out.println("Список Читателей:");
                        
                        for (Reader r : listReaders){
                            System.out.println(r.toString());
                        }
                        System.out.println("-------------------");
                        System.out.println();
                        break;
                    case "0":
                                             
                        badOperation=false; 
                        break;

                    default:
                        System.out.println("Ошибка ввода! \"q\"");
                        badOperation=true;
                }
            }while(badOperation);
            if(operation.equals("0"))break;
            
        }while(true);
    }
}