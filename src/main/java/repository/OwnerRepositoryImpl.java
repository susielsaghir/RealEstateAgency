package repository;

import jakarta.persistence.EntityManager;
import model.PropertyOwner;

public class OwnerRepositoryImpl implements OwnerRepository {


    private final EntityManager entityManager;

    public OwnerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public PropertyOwner insert(PropertyOwner owner) {
        try {
            entityManager.persist(owner);
            return owner;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public PropertyOwner findById(Long id) {
        return entityManager.find(PropertyOwner.class,id);
    }

    @Override
    public PropertyOwner update(PropertyOwner owner) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
