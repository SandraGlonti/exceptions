package pl.kurs.lesson2.model;

import pl.kurs.lesson2.exception.NotEnoughBatteryLevelException;
import pl.kurs.lesson2.exception.OverloadedBatteryException;

public class ElectricVehicle {
    public static final double ELECTRICITY_CONSUMPTION = 5;
    public static final double BATTERY_CAPACITY = 40;

    private String producer;
    private String model;
    private double currentBatteryLevel;

    public ElectricVehicle(String producer, String model, double currentBatteryLevel) {
        this.producer = producer;
        this.model = model;
        this.currentBatteryLevel = currentBatteryLevel;
    }

    public void drive() throws NotEnoughBatteryLevelException {
        if (currentBatteryLevel - ELECTRICITY_CONSUMPTION < 0) {
            throw new NotEnoughBatteryLevelException("Masz zbyt mało energii");
        } else {
            currentBatteryLevel = currentBatteryLevel - ELECTRICITY_CONSUMPTION;
            System.out.println("Jedzie :)");
        }
    }

    public void charge(double energyAmount) throws OverloadedBatteryException {
        if (currentBatteryLevel + energyAmount > BATTERY_CAPACITY) {
            throw new OverloadedBatteryException("Bateria przeładowana");
        } else {
            currentBatteryLevel = currentBatteryLevel + energyAmount;
            System.out.println("Aktualny stan baterii: " + currentBatteryLevel);
        }

    }

}
