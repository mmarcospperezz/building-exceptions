package org.example.components;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.exceptions.ApartmentNotFoundException;
import org.example.model.Building;

import java.util.InputMismatchException;
import java.util.Scanner;

@AllArgsConstructor
@Log4j
public class BuildingApp {
    private final Scanner scanner;
    private final Reader<Building> buildingReader;

    public void run() {
        var building = buildingReader.read();
        int option;
        do {
            option = askOpt();
            if (option == 1) {
                try {
                    int floor = askFloor();
                    String door = askDoor();
                    var apartment = building.findApartment(floor, door);
                    log.info(apartment.toString());
                } catch (ApartmentNotFoundException e) {
                    log.error("No se ha encontrado el apartamento en " + e.getFloor() + e.getDoor());
                }
            } else if (option == 2) {
                try {
                    int floor = askFloor();
                    String door = askDoor();
                    var owners = building.findOwners(floor, door);
                    log.info(owners.toString());
                } catch (ApartmentNotFoundException e) {
                    log.error("No se ha encontrado el apartamento en " + e.getFloor() + e.getDoor());
                }
            } else {
                log.info("Saliendo...");
            }
        } while (option != 3);
    }


    private String askDoor() {
        log.info("Ingrese la letra de la puerta");
        return scanner.nextLine();
    }

    private int askFloor() {
        log.info("Ingrese el número de piso:");
        return askNumber();
    }

    private int askOpt() {
        Integer opt;
        do {
            log.info("Elija una operación: ");
            log.info("1. ver un apartamento");
            log.info("2. ver los propietarios de un apartamento");
            log.info("3. salir");
            opt = askNumber();
            if (opt < 1 || opt > 3) {
                log.error("Opción inválida, inténtelo de nuevo");
                opt = null;
            }
        } while (opt == null);
        return opt;
    }

    private int askNumber() {
        Integer number = null;
        do {
            try {
                number = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                log.error("Opción inválida, inténtelo de nuevo");
                scanner.nextLine();
            }
        } while (number == null);
        return number;
    }
}