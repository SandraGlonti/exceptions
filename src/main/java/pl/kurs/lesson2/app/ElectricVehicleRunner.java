package pl.kurs.lesson2.app;

import pl.kurs.lesson2.exception.NotEnoughBatteryLevelException;
import pl.kurs.lesson2.exception.OverloadedBatteryException;
import pl.kurs.lesson2.model.ElectricVehicle;

public class ElectricVehicleRunner {
    public static void main(String[] args) throws OverloadedBatteryException, NotEnoughBatteryLevelException {

        ElectricVehicle tesla = new ElectricVehicle("Tesla","Plaid",10);
        try{
            tesla.drive();
            tesla.drive();
            tesla.drive();
        }catch (NotEnoughBatteryLevelException e){
            System.out.println(e.getMessage());
            tesla.charge(20);
        }
        tesla.drive();

        //System.out.println(" Zrób coś z tym :)");

    }
}
