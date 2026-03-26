package service;

import model.Listing;
import model.ListingType;
import repository.ListingRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public BigDecimal getAvgPricePerDistrict (Long districtId){
        List<Listing> listings = repository.findAllListingsByDistrict(districtId);
        //first edition starts with 0
        //defining total with the datatype of Bigdecimal
        BigDecimal total = BigDecimal.ZERO;
        for (Listing l: listings){ //each listing at a time from all the listings
            total = total.add(l.getPrice());
        }
        int count = listings.size();
        if (count==0)
            return BigDecimal.ZERO;
        return total.divide(BigDecimal.valueOf(count),2, RoundingMode.HALF_UP);
    }

    public List<Listing> findAllListingsByType(ListingType type) {
        return repository.findAllListingsByType(type);
    }

    //seperating the Listings by Type and create groups
    public Map<String, List<Listing>> groupListingsByType() {
        List<Listing> all = repository.findAll();
        Map<String, List<Listing>> map = new HashMap<>();

        for (Listing l : all) {
            String type = l.getType().toString();
            if (type == null) continue;

            if (!map.containsKey(type)) {
                map.put(type, new ArrayList<>());
            }
            map.get(type).add(l);
        }
        return map;
    }







}
