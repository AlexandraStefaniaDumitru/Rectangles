package org.example;

import static java.util.Objects.hash;

// class for a pair containing the abscissa and the ordinate for a point
public class Coordinate {
    int abscissa;
    int ordinate;

    public Coordinate(int abscissa, int ordinate) {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

    @Override
    public int hashCode() {
        return hash(abscissa, ordinate);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        Coordinate other = (Coordinate) obj;
        return this.abscissa == other.abscissa && this.ordinate == other.ordinate;
    }
}