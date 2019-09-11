
package classes;

import entity.Reader;
import java.util.Scanner;

public class ReaderProvider {
    public Reader createReader(){
        Reader reader = new Reader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------- Создание новой читателя --------");
        System.out.println("Введите имя читателя: ");
        reader.setName(scanner.nextLine());
        System.out.println("Введите фамилию читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.println("Введите день рождения читателя: ");
        reader.setDay (new Integer (scanner.nextLine()));
        System.out.println("Введите месяц рождения читателя: ");
        reader.setMonth (new Integer (scanner.nextLine()));
        System.out.println("Введите год рождения читателя: ");
        reader.setYear (new Integer (scanner.nextLine()));
        System.out.println("Создание читателя завершено.");
        return reader;
    }
}
