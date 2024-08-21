package hus.oop.lab9.library;

import java.util.Collection;

public class Library {
    Rent[] rents;

    public Library(Rent[] rents) {
        this.rents = rents;
    }

    public Rent getLongestRent() {
        Rent longestRent = null;
        long longestDuration = 0;

        for (Rent rent : rents) {
            long duration = rent.getEnd().getTime() - rent.getBegin().getTime();
            if (duration > longestDuration) {
                longestDuration = duration;
                longestRent = rent;
            }
        }

        return longestRent;
    }
}