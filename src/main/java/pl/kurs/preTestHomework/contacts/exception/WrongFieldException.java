package pl.kurs.preTestHomework.contacts.exception;

public class WrongFieldException extends Exception{
    public WrongFieldException() {
    }

    public WrongFieldException(String message) {
        super(message);
    }
}
