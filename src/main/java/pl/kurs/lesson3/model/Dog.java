package pl.kurs.lesson3.model;

import pl.kurs.lesson3.exceptions.DogNotHungryException;

public class Dog extends Animal {
    private String type;

    public Dog(String name, double hungryLevel, String type) {
        super(name, hungryLevel);
        this.type = type;
    }

    @Override
    public void feed() throws DogNotHungryException{
        if (getHungryLevel() < 25) {
            throw new DogNotHungryException();

        } else {
            setHungryLevel(getHungryLevel() - 25);
        }
    }
}
