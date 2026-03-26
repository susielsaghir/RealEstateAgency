package repository;

import exceptions.ListingOwnerNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Listing;
import model.ListingOwner;
import model.ListingType;

import java.util.List;

public class ListingOwnerRepositoryImpl implements ListingOwnerRepository {


    private final EntityManager entityManager;

    public ListingOwnerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ListingOwner insert(ListingOwner owner) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(owner);
            entityManager.flush();
            transaction.commit();
            return owner;
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public ListingOwner findById(Long id) {
        try {
            ListingOwner owner = entityManager.find(ListingOwner.class, id);
            if (owner == null) {
                throw new ListingOwnerNotFoundException("Owner not Found with ID=" + id);
            }
            return owner;
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public ListingOwner update(ListingOwner owner) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            ListingOwner updatedOwner = entityManager.merge(owner);
            entityManager.flush();
            transaction.commit();
            return updatedOwner;
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteById(Long id) {
    }

}
