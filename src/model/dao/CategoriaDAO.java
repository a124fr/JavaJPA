package model.dao;
    
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.bean.Categoria;
import model.connection.ConnectionFactory;

public class CategoriaDAO {
    
    public Categoria save(Categoria categoria) {
        EntityManager em = ConnectionFactory.getConnection();
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
        } finally {
            em.close();
        }
        
        return categoria;
    }
    
    public Categoria findById(int id) {
        EntityManager em = ConnectionFactory.getConnection();                
        Categoria  categoria = new Categoria();
        
        try {
            categoria = em.find(Categoria.class, id);
        } catch (Exception e) {
            
        }
        
        return categoria;
    }
    
}
