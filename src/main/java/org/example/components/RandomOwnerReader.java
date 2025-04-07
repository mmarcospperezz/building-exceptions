package org.example.components;

import lombok.AllArgsConstructor;
import org.example.model.Owner;

import java.util.Random;

@AllArgsConstructor
public class RandomOwnerReader implements Reader<Owner> {

    private final static String[] NAMES = {
            "Bob", "Peppa", "Pocoyo", "George", "Calamardo"
    };

    private final static String[] SURNAMES = {
            "Pig", "Esponja", "Pocoyo", "Pérez", "López"
    };
    private final Random random;


    @Override
    public Owner read() {
        return new Owner(
                NAMES[random.nextInt(NAMES.length)],
                SURNAMES[random.nextInt(SURNAMES.length)]
        );
    }
}