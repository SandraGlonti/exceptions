package pl.kurs.lesson2.exception;

public class NotEnoughBatteryLevelException extends Exception {
    public NotEnoughBatteryLevelException() {
    }

    public NotEnoughBatteryLevelException(String message) {
        super(message);
    }
}
