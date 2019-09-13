/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class ReaderProvider {
    public Reader createReader(){
        Reader reader = new Reader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Регистрация нового читателя ---");
        System.out.println("Введите имя читателя: ");
        reader.setName(scanner.nextLine());
        System.out.println("Введите фамилию читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.println("Введите день рождения читателя: ");
        reader.setDay(new Integer(scanner.nextLine()));
        System.out.println("Введите месяц рождения читателя: ");
        reader.setMonth(new Integer(scanner.nextLine()));
        System.out.println("Введите год рождения читателя: ");
        reader.setYear(new Integer(scanner.nextLine()));
        System.out.println("Регистрация нового читателя завершена");
        return reader;
    }    
}