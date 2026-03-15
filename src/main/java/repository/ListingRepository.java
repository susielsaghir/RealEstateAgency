package repository;

import model.Listing;

import java.math.BigDecimal;
import java.util.List;

public interface ListingRepository {
    public Listing insert (Listing listing);
    List<Listing> search (String type, String status, String district, Double maxSize,BigDecimal maxPrice);

    List<Listing> findAllListingsByDistrict (Long districtId);

}
