package pl.kurs.preTestHomework.contacts.exception;

public class EmptyFieldException extends Exception{
    public EmptyFieldException() {
    }

    public EmptyFieldException(String message) {
        super(message);
    }
}
