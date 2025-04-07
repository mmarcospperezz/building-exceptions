package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.exceptions.ApartmentNotFoundException;

import java.util.List;

@Data
@AllArgsConstructor
public class Building {
    private String address;
    private String city;
    private int zipCode;
    private List<Apartment> apartments;

    public Apartment findApartment(int floor, String door) throws ApartmentNotFoundException {
//        return apartments
//                .stream()
//                .filter(apartment -> apartment.getFloor() == floor && apartment.getDoor().equals(door))
//                .findFirst()
//                .orElseThrow(() -> new ApartmentNotFoundException(floor, door));

        for (var apartment : apartments) {
            if (apartment.getFloor() == floor && apartment.getDoor().equals(door)) {
                return apartment;
            }
        }
        throw new ApartmentNotFoundException(floor, door);
    }

    public List<Owner> findOwners(int floor, String door) throws ApartmentNotFoundException {
        return findApartment(floor, door)
                .getOwners();
    }
}