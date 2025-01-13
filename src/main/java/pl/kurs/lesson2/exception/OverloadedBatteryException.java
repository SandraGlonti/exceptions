package pl.kurs.lesson2.exception;

public class OverloadedBatteryException extends Exception{
    public OverloadedBatteryException() {
    }

    public OverloadedBatteryException(String message) {
        super(message);
    }
}
