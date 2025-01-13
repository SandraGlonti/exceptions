package pl.kurs.lesson3.service;

import pl.kurs.lesson3.exceptions.NotRecognizedCarException;
import pl.kurs.lesson3.model.Car;

public class CarFactory {

    public Car createNewCar(String chosenCar) throws NotRecognizedCarException {
        return switch (chosenCar){
            case "Lamborghini" -> new Car("Lamborghini", "Revuelto",1015);
            case "Ferrari" -> new Car("Ferrari", "SF90 Stradale", 1000);
            default -> throw new NotRecognizedCarException("Nie rozpoznano auta: " + chosenCar);
        };
    }
}
