package repository;

import model.Property;
import model.PropertyOwner;
import org.hibernate.sql.Update;

interface OwnerRepository {
    PropertyOwner insert(PropertyOwner owner);
    PropertyOwner findById(Long id);
    PropertyOwner update (PropertyOwner owner);
    void deleteById(Long id);


}
