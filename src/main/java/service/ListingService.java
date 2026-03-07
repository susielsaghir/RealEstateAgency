package service;

import model.Listing;
import repository.ListingRepository;

import java.math.BigDecimal;
import java.util.List;

public class ListingService {
    private final ListingRepository repository;

    public ListingService(ListingRepository repository) {
        this.repository = repository;
    }
    public List<Listing> searchListings(
            String type,
            String status,
            String district,
            Double maxSize,
            BigDecimal maxPrice
    ) {
        return repository.search (type, status, district, maxSize, maxPrice);
    }

}
