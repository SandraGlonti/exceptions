package pl.kurs.lesson1.app;

import pl.kurs.lesson1.model.MyModel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchWithResourcesRunner {
    public static void main(String[] args) {



        try(
                Scanner scanner = new Scanner(System.in);
                MyModel myModel = new MyModel()) {
            System.out.println("Podaj liczbę całkowitą");
            long number = scanner.nextLong();
            System.out.println(number);
            // W tym miejscu zostanie zamkniety scanner oraz obiekt myModel - po wszystkich poprzednich instrukcjach
        }catch (InputMismatchException exception){
            // Najpierw zostanie zamkniety scanner oraz obiekt myModel, a nastepnie zostana wykonane instrukcje w catch
            System.out.println("Wprowadziłeś złe dane");
        }
    }
}
