package model;

import java.math.BigDecimal;

public class ListingBuilder {

    private final Listing listing = new Listing();

    public ListingBuilder title(String title) {
        listing.setTitle(title);
        return this;
    }

    public ListingBuilder address(String address) {
        listing.setAddress(address);
        return this;
    }

    public ListingBuilder district(District district) {
        listing.setDistrict(district);
        return this;
    }

    public ListingBuilder type(ListingType type) {
        listing.setType(type);
        return this;
    }

    public ListingBuilder squareMeters(Double size) {
        listing.setSquareMeters(size);
        return this;
    }

    public ListingBuilder price(BigDecimal price) {
        listing.setPrice(price);
        return this;
    }

    public ListingBuilder status (ListingStatus status) {
        listing.setStatus(status);
        return this;
    }

    public ListingBuilder yearofConstruction (Integer yearofConstruction) {
        listing.setYearOfConstruction(yearofConstruction);
        return this;
    }

    public Listing build() {
        return listing;
    }
}
