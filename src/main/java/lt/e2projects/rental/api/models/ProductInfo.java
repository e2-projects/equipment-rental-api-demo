package lt.e2projects.rental.api.models;

import java.util.Set;

public record ProductInfo(Integer id, String name, boolean isRentable, Set<Integer> commitmentMonths) {
}
