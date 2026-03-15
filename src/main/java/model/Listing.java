package model;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity //will create a table in the database & the database will create property
@Table (name = "listings") //lower case & plural
public class Listing {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long ID;
    private String title;
    private Double squareMeters;
    private BigDecimal price;
    private String address;
    private ListingType type; //enum as variable defined
    private Integer yearOfConstruction;
    private ListingStatus status; //enum as variable defined

    @ManyToOne
    @JoinColumn (name = "listing_owner_id")
    private ListingOwner owner;

    @ManyToOne
    @JoinColumn (name = "district_id")
    private District district;


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Double squareMeters) {
        this.squareMeters = squareMeters;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ListingType getType() {
        return type;
    }

    public void setType(ListingType type) {
        this.type = type;
    }

    public Integer getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(Integer yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public ListingStatus getStatus() {
        return status;
    }

    public void setStatus(ListingStatus status) {
        this.status = status;
    }

    public ListingOwner getOwner() {
        return owner;
    }

    public void setOwner(ListingOwner owner) {
        this.owner = owner;
    }

}
