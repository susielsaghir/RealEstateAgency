package config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaConfig {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("realestatePU");

    public static EntityManager getEntityManager (){
        return emf.createEntityManager();
    }
}
