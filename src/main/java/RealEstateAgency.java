import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RealEstateAgency {
     static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("realestatePU"); //persistence unit
        EntityManager em = emf.createEntityManager();
        System.out.println("Connected to PostgreSQL successfully!");
        em.close();
        emf.close();
    }
}
