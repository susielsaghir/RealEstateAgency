package repository;

import model.ListingOwner;

public interface ListingOwnerRepository {
    ListingOwner insert(ListingOwner owner);
    ListingOwner findById(Long id);
    ListingOwner update (ListingOwner owner);
    void deleteById(Long id);


}
