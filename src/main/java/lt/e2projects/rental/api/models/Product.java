package lt.e2projects.rental.api.models;

import java.io.Serializable;

public record Product(Integer id, String name, boolean isRentable) implements Serializable {
}
