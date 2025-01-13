package pl.kurs.lesson3.app;

import pl.kurs.lesson3.exceptions.NotRecognizedCarException;
import pl.kurs.lesson3.model.Car;
import pl.kurs.lesson3.service.CarFactory;

import java.util.Scanner;

public class CarFactoryRunner {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car myCar = null;

        System.out.println("Podaj nazwę auta:");
        try (Scanner scanner = new Scanner(System.in)){
            myCar = carFactory.createNewCar(scanner.nextLine());
        } catch (NotRecognizedCarException e) {
            System.out.println(e.getMessage());
        }
        if (myCar != null) {
            System.out.println(myCar);
        }

    }
}
