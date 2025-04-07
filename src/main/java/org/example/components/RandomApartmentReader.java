package org.example.components;

import lombok.AllArgsConstructor;
import org.example.model.Apartment;
import org.example.model.Owner;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@AllArgsConstructor
public class RandomApartmentReader implements Reader<Apartment> {

    private final static String[] DOORS = {
            "A", "B"
    };

    private final Random random;

    private final Reader<Owner> ownerReader;


    @Override
    public Apartment read() {
        var owners = new ArrayList<Owner>();
        int numOwners = random.nextInt(3) + 1;
        for (int i = 0; i < numOwners; i++) {
            owners.add(ownerReader.read());
        }
        return new Apartment(
                random.nextInt(2),
                DOORS[random.nextInt(DOORS.length)],
                owners
        );
    }
}