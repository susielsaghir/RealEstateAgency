package repository;

import config.JpaConfig;
import jakarta.persistence.EntityManager;
import model.PropertyOwner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OwnerRepositoryTest {
    private EntityManager entityManager;
    private OwnerRepository ownerRepository;

    @BeforeEach
    void beforeSetUp() {
        entityManager = JpaConfig.getEntityManager(); //Jpa Java persistence API =
        ownerRepository = new OwnerRepositoryImpl(entityManager);
    }

    @Test
    void testCreateOwner() {
        PropertyOwner owner = new PropertyOwner();
        owner.setID(1L);
        owner.setFirstName("Alice");
        owner.setEmailAddress("alice@example.com");
        owner.setPhoneNumber("123456789");
        owner.setAddress("10 Downing Street");
        PropertyOwner saved = ownerRepository.insert(owner);
        Assertions.assertNotNull(saved.getID());
    }
}
