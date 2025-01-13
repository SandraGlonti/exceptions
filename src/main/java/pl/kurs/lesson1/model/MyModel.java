package pl.kurs.lesson1.model;

public class MyModel implements AutoCloseable {


    @Override
    public void close()  {
        System.out.println("Zamykam");
    }
}
