package pl.kurs.lesson3.model;

import pl.kurs.lesson3.exceptions.DogNotHungryException;

public class Animal {
    private String name;
    private double hungryLevel;

    public Animal(String name, double hungryLevel) {
        this.name = name;
        this.hungryLevel = hungryLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHungryLevel() {
        return hungryLevel;
    }

    public void setHungryLevel(double hungryLevel) {
        this.hungryLevel = hungryLevel;
    }

    public void feed() throws DogNotHungryException {
        if (hungryLevel < 20) {
            throw new DogNotHungryException("Zwierzę nie jest głodne");
        } else {
            hungryLevel -= 20;

        }
    }
}
