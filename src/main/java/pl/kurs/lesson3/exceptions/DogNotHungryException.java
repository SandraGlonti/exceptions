package pl.kurs.lesson3.exceptions;

public class DogNotHungryException extends Exception{
    public DogNotHungryException() {
    }

    public DogNotHungryException(String message) {
        super(message);
    }
}
