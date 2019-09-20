/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import interfaces.Saver;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class SaverToBase implements Saver{
    EntityManager em;
    EntityTransaction tx;

    public SaverToBase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");
        this.em = emf.createEntityManager();
        this.tx = em.getTransaction();
    }
    
    

    
    @Override
    public void saveBooks(List<Book> listBooks) {
        for (Book book : listBooks){
            tx.begin();
            em.persist(book);
            tx.commit();
        } //for
        
    } // saveBook

    @Override
    public void saveReaders(List<Reader> listReaders) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveHistories(List<History> listHistories) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> loadListBooks() {
            return em.createQuery("SELECT b From Book b")
                .getResultList();
    }

    @Override
    public List<Reader> loadListReaders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<History> loadListHistories() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
