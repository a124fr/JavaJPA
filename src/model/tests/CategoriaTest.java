package model.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bean.Categoria;
import model.connection.ConnectionFactory;
import model.dao.CategoriaDAO;


public class CategoriaTest {
    
    public static void main(String[] args) {
        
        Categoria c = new Categoria();
        c.setId(3);
        c.setDescricao("Roupas 2");
        /*
        EntityManager em = ConnectionFactory.getConnection();        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();        
        em.close();
        */
        CategoriaDAO dao = new CategoriaDAO();        
        c = dao.save(c);        
        System.out.println(c);
        
        
    }
    
}
