/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pupil
 */
public class SaverToFile {

    private FileOutputStream fos = null;
    private ObjectOutputStream oos = null;
    FileInputStream fileInputStream = null;
    ObjectInputStream objectInputStream = null;

    public void saveBook(List<Book> listBooks) {
        try {
            fos = new FileOutputStream("Books.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listBooks);
            oos.flush(); // запись файлов
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден. Ошибка: " + ex);
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода. Ошибка: " + ex);
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException ex) {
                System.out.println("Ресурсы освободить не удалось: " + ex);
            }
        }
    }

    public void saveReader(List<Reader> listReaders) {

    }

    public void saveHistories(List<History> listHistories) {

    }

    public List<Book> loadListBooks() {
        List<Book> listBooks = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream("Books.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            listBooks = (List<Book>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден. Ошибка: " + ex);
        } catch (IOException ex) {
            System.out.println("Файл не прочитан. Ошибка: " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс. " + ex);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException ex) {
                System.out.println("Ресурсы освободить не удалось." + ex);
            }
        }
        return listBooks;
    }

    public List<Reader> loadListReaders() {
        return null;
    }

    public List<History> loadListHistories() {
        return null;
    }
}
