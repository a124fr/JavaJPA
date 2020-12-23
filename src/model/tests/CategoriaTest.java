package model.tests;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bean.Categoria;
import model.connection.ConnectionFactory;
import model.dao.CategoriaDAO;


public class CategoriaTest {
    
    public static void main(String[] args) {                
        //Categoria c = new Categoria();        
        //c.setDescricao("Roupas 2");
        /*
        EntityManager em = ConnectionFactory.getConnection();        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();        
        em.close();
        */
        
        //Categoria c = new Categoria();
        //c.setId(3);
        //c.setDescricao("Roupas 2");
        //CategoriaDAO dao = new CategoriaDAO();        
        //c = dao.save(c);        
        //System.out.println(c);
        
        //CategoriaDAO dao = new CategoriaDAO();
        //Categoria categoria = dao.findById(2);
        //System.out.println(categoria);
        
        /*CategoriaDAO dao = new CategoriaDAO();
        List<Categoria> categorias = dao.findAll();
        
        for(Categoria c:categorias) {
            System.out.println(c);
        }*/
        
        CategoriaDAO dao = new CategoriaDAO();        
        Categoria c = dao.remove(3); 
        
        if(c.getId() > 0) {
            System.out.println("A categoria id: " + c.getId() + " foi removido com sucesso!");
        }
        
    }
    
}
