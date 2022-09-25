package lt.e2projects.rental.api.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "product")
@Table(name = "product")
public class ProductEntity {

    @Id
    @Column(unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private boolean rentable;

    @Column(nullable = false)
    private float initialCharge;

    @Column(nullable = false, columnDefinition = "Rental price without commitment")
    private float rentalPrice;

    @Column(nullable = false, columnDefinition = "Rental price for 3 months commitment")
    private float rentalPriceForQuarter;

    @Column(nullable = false, columnDefinition = "Rental price for 6 months commitment")
    private float rentalPriceForHalfYear;

}
