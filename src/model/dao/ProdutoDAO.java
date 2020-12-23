package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.bean.Produto;
import model.connection.ConnectionFactory;

public class ProdutoDAO {
    
    public Produto save(Produto produto) {
        EntityManager em = ConnectionFactory.getConnection();
        EntityTransaction transacao = em.getTransaction();
        
        try {
            transacao.begin();
            
            if(produto.getId() == 0) {
                em.persist(produto);
            } else {
                em.merge(produto);
            }
            
            transacao.commit();
            
        } catch (Exception e) {
            transacao.rollback();
            System.err.println("ERRO: " + e);
        } finally {
            em.close();
        }
        
        return produto;
    }
    
    public Produto findById(int id) {
        EntityManager em = ConnectionFactory.getConnection();
        Produto produto = new Produto();
        
        try {
            produto = em.find(Produto.class, id);
        } catch (Exception e) {            
            System.err.println("ERRO: " + e);
        } finally {
            em.close();
        }
        
        return produto;
    }
}
