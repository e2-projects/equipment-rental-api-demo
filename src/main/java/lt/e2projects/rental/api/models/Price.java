package lt.e2projects.rental.api.models;

import java.io.Serializable;
import java.math.BigInteger;

public record Price(int commitmentMonths, BigInteger value) implements Serializable {
}
