package repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Listing;

import java.math.BigDecimal;
import java.util.List;

public class ListingRepositoryImpl implements ListingRepository {

    private final EntityManager entityManager;

    public ListingRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public Listing insert(Listing listing) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(listing);
            entityManager.flush();
            transaction.commit();
            return listing;
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<Listing> search (String type, String status, String district, Double maxSize,BigDecimal maxPrice) {
        try {
            StringBuilder jpql = new StringBuilder("SELECT * FROM Listing l WHERE 1 = 1");
            if (type != null) jpql.append(" AND l.type = :type");
            if (status != null) jpql.append(" AND l.status = :status");
            if (district != null) jpql.append(" AND l.district = :district");
            if (maxSize != null) jpql.append(" AND l.squareMeters <= :maxSize");
            if (maxPrice != null) jpql.append(" AND l.price <= :maxPrice");

            var query = entityManager.createQuery(jpql.toString(), Listing.class);
            if (type != null) query.setParameter("type", type);
            if (status != null) query.setParameter("status", status);
            if (district != null) query.setParameter("district", district);
            if (maxSize != null) query.setParameter("maxSize", maxSize);
            if (maxPrice != null) query.setParameter("maxPrice", maxPrice);

            return query.getResultList();

        }catch (Exception e){
            throw e;
        }
    }
}


