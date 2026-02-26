package model;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity //will create a table in the database & the database will create property
@Table (name = "properties") //lower case & plural
public class Property {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long ID;
    private String title;
    private Double squareMeters;
    private BigDecimal price;
    private String address;
    private PropertyType type;
    private Integer yearOfConstruction;









}
