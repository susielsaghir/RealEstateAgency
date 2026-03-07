package service;

import jakarta.persistence.EntityManager;
import model.Listing;
import model.ListingOwner;
import model.ListingStatus;
import model.OwnerPortfolioSummary;
import repository.ListingOwnerRepository;
import repository.ListingOwnerRepositoryImpl;
import repository.ListingRepository;

import java.util.List;

public class OwnerService {
    private final ListingRepository repository;
    private final ListingOwnerRepository ownerRepository;

    public OwnerService(ListingRepository repository, ListingOwnerRepository ownerRepository) {
        this.repository = repository;
        this.ownerRepository = ownerRepository;
    }

    public ListingOwner createOwner(ListingOwner owner) {
        return ownerRepository.insert(owner);
    }

    public OwnerPortfolioSummary getOwnerSummary(Long id) {
        ListingOwner owner = ownerRepository.findById(id);
        List<Listing> listings = owner.getListings();
        int total = listings.size();
        long available = listings.stream().filter(l -> ListingStatus.AVAILABLE.equals(l.getStatus())).count();
        long sold = listings.stream().filter(l -> ListingStatus.SOLD.equals(l.getStatus())).count();
        long archived = listings.stream().filter(l -> ListingStatus.ARCHIVED.equals(l.getStatus())).count();
        return new OwnerPortfolioSummary();
    }
}
