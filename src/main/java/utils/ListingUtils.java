package utils;

import model.Listing;
import model.ListingBuilder;
import model.ListingStatus;
import model.ListingType;

import java.math.BigDecimal;
import java.util.List;

public class ListingUtils {
    public static List<Listing> sampleListings = List.of(
            new ListingBuilder()
                    .title("Rustical 5-Bed House with Garden")
                    .address("Grinzinger Strasse 17")
                    .district(DistrictUtils.DÖBLING)
                    .type(ListingType.HOUSE)
                    .squareMeters(350.00)
                    .price(new BigDecimal("980.000"))
                    .status(ListingStatus.AVAILABLE)
                    .build(),
            new ListingBuilder()
                    .title("Modern 2-Bed Apartment")
                    .address("Landstrasser Hauptstrasse 2")
                    .district(DistrictUtils.LANDSTRASSE)
                    .type(ListingType.APARTMENT)
                    .squareMeters(77.00)
                    .price(new BigDecimal("275000"))
                    .status(ListingStatus.AVAILABLE)
                    .build(), //BUILDER PATTERN that creates one object for List
            //BUILDER PATTERN that creates one object for List
            new ListingBuilder()
                    .title("Modern 2-Bed Apartment")
                    .address("Landstrasser Hauptstrasse 2")
                    .district(DistrictUtils.LANDSTRASSE)
                    .type(ListingType.APARTMENT)
                    .squareMeters(77.00)
                    .price(new BigDecimal("275000"))
                    .status(ListingStatus.AVAILABLE)
                    .build()

    );


}
