package model.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");        
    
    public static EntityManager getConnection() {
        return emf.createEntityManager();
    }
}
