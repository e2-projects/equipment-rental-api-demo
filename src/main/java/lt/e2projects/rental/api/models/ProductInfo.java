package lt.e2projects.rental.api.models;

public record ProductInfo(
        Integer id,
        String name,
        Boolean isRentable,
        Float initialCharge,
        Float rentalPrice,
        Float rentalPriceForQuarter,
        Float rentalPriceForHalfYear) {
}
