package org.example.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class ApartmentNotFoundException extends Exception {
    private final int floor;
    private final String door;
}