package pl.kurs.lesson3.exceptions;

public class NotRecognizedCarException extends Exception{
    public NotRecognizedCarException() {
    }

    public NotRecognizedCarException(String message) {
        super(message);
    }
}
