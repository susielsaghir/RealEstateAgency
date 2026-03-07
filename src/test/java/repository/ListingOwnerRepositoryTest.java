package repository;

import config.JpaConfig;
import exceptions.ListingOwnerNotFoundException;
import jakarta.persistence.EntityManager;
import model.ListingOwner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListingOwnerRepositoryTest {
    private EntityManager entityManager;
    private ListingOwnerRepository ownerRepository;

    @BeforeEach
    void beforeSetUp() {
        entityManager = JpaConfig.getEntityManager(); //Jpa Java persistence API =
        ownerRepository = new ListingOwnerRepositoryImpl(entityManager);
    }

    @Test
    void testCreateOwner() {
        ListingOwner owner = new ListingOwner();
        owner.setFirstName("Alice");
        owner.setEmailAddress("alice@example.com");
        owner.setPhoneNumber("123456789");
        owner.setAddress("10 Downing Street");
        ListingOwner saved = ownerRepository.insert(owner);
        Assertions.assertNotNull(saved.getID());
    }

    @Test
    void testUpdateOwner_successful() {
        ListingOwner owner = ownerRepository.findById(1L); //1 Long
        owner.setPhoneNumber("170125");
        ListingOwner updated = ownerRepository.update(owner);
        Assertions.assertNotNull(updated.getID());
        Assertions.assertEquals("170125", updated.getPhoneNumber());
    }

    @Test
    void testFindById_NotFound_ThrowsException() {
        Long nonExistingId = 999L;
        assertThrows(ListingOwnerNotFoundException.class, () -> ownerRepository.findById(nonExistingId));
    }
}
