package model.dao;
    
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.bean.Categoria;
import model.connection.ConnectionFactory;

public class CategoriaDAO {
    
    private EntityManager em;

    public CategoriaDAO() {
        em = ConnectionFactory.getConnection(); 
    }
    
    public Categoria save(Categoria categoria) {        
        EntityTransaction transacao = em.getTransaction();
        
        try {
            transacao.begin();
            
            if(categoria.getId() == 0) {
                em.persist(categoria);
            } else {
                em.merge(categoria);//realiza o update no registro.
            }
            transacao.commit();
        } catch (Exception e) {
            transacao.rollback();
            System.err.println("ERRO: " + e);
        } finally {
            em.close();
        }
        
        return categoria;
    }
    
    public Categoria findById(int id) {
        Categoria  categoria = new Categoria();
        
        try {
            categoria = em.find(Categoria.class, id);
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        } finally {
            em.close();
        }
        
        return categoria;
    }
    
    public List<Categoria> findAll() {
        List<Categoria> lista = new ArrayList<Categoria>();
        
        try {
            lista = em.createQuery("from Categoria c").getResultList();
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        } finally {
            em.close();
        }
        
        return lista;
    }
    
    public Categoria remove(int id) {
        EntityTransaction transacao = em.getTransaction();
        Categoria categoria = new Categoria();
        
        try {
            categoria = em.find(Categoria.class, id);
            transacao.begin();            
            em.remove(categoria);
            transacao.commit();
            
        } catch (Exception e) {
            transacao.rollback();
            System.err.println("ERRO: " + e);
        } finally {
            em.close();
        }
        
        return categoria;
    }
    
}
