package model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "districts") //requesting the table to create the districts
public class District {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //return from library not my class
    private Long id; //presentation for the database
    private Integer number;
    private String name;
    private BigDecimal avgPriceSqm;

    public District() {
    }

    public District(Integer number, String name, BigDecimal avgPriceSqm) {
        this.number = number;
        this.name = name;
        this.avgPriceSqm = avgPriceSqm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAvgPriceSqm() {
        return avgPriceSqm;
    }

    public void setAvgPriceSqm(BigDecimal avgPriceSqm) {
        this.avgPriceSqm = avgPriceSqm;
    }
}
